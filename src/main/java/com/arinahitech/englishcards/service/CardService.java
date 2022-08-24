package com.arinahitech.englishcards.service;

import com.arinahitech.englishcards.modal.Card;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    public List<Card> getCards() {
        return Arrays.asList(
                new Card(
                        1,
                        "house",
                        "дом",
                        "I have a house.",
                        null,
                        LocalDateTime.now()
                ),
                new Card(
                        2,
                        "speed",
                        "скорость",
                        "The car has a big speed.",
                        "Эта машина имеет большую скорость.",
                        LocalDateTime.now()
                )
        );
    }
}
