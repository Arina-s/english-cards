package com.arinahitech.englishcards.service;

import com.arinahitech.englishcards.modal.Card;
import com.arinahitech.englishcards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        saveCard(new Card(null, "home", "дом", "I love my sweet home.", "Я люблю свой милый дом.", LocalDateTime.now()));
        saveCard(new Card(null, "apple", "яблоко", null, null, LocalDateTime.now()));
    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public void saveCard(Card card) {
        cardRepository.save(card);
    }
}
