package com.arinahitech.englishcards.modal.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PracticeMode {

    private Long numberOfCards;
    private String startWith;
}
