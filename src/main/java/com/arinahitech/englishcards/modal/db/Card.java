package com.arinahitech.englishcards.modal.db;

import com.arinahitech.englishcards.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "The phase cannot be empty or null.")
    private String phrase;
    private String translate;
    private String sentence;
    private String sentenceTranslate;
    private LocalDateTime createDate;
    @Transient
    private Integer daysInStudy;
    private CardStatus cardStatus;

    public int getDaysInStudy() {
        return Period.between(getCreateDate().toLocalDate(), LocalDate.now()).getDays();
    }
}
