package com.arinahitech.englishcards.service;

import com.arinahitech.englishcards.modal.db.Card;
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
    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public void addCard(Card card) {
        if (cardRepository.findByPhrase(card.getPhrase()).isPresent()) {
            throw new RuntimeException("The phrase '" + card.getPhrase() + "' already exists.");
        }
        card.setCreateDate(LocalDateTime.now());
        cardRepository.save(card);
    }
}
