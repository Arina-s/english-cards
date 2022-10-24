package com.arinahitech.englishcards.modal.db;

import com.arinahitech.englishcards.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracticeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numberOfCards;
    private String startWith;
    private Date startDate;
    private Date endDate;
    @ManyToMany
    private List<Card> cardsList;
    private TaskStatus taskStatus;
}
