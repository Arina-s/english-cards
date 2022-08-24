package com.arinahitech.englishcards.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card {

    private long id;
    private String phrase;
    private String translate;
    private String sentence;
    private String sentenceTranslate;
    private LocalDateTime createDate;
}
