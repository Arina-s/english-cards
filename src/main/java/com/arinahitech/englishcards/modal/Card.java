package com.arinahitech.englishcards.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phrase;
    private String translate;
    private String sentence;
    private String sentenceTranslate;
    private LocalDateTime createDate;
    @Transient
    private Integer daysInStudy;

    public int getDaysInStudy() {
        return Period.between(getCreateDate().toLocalDate(), LocalDate.now()).getDays();
    }
}
