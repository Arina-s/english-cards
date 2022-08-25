package com.arinahitech.englishcards.service;

import com.arinahitech.englishcards.exceptions.db.CardAlreadyExistsException;
import com.arinahitech.englishcards.exceptions.db.CardNotFoundException;
import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            throw new CardAlreadyExistsException(card.getPhrase());
        }

        card.setCreateDate(LocalDateTime.now());
        cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new CardNotFoundException(id);
        }

        cardRepository.deleteById(id);
    }

    @Transactional
    public Card updateCard(Long id, Card updateCard) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));

        if (isFieldSet(updateCard.getPhrase())) {
            card.setPhrase(updateCard.getPhrase());
        }
        if (isFieldSet(updateCard.getTranslate())) {
            card.setTranslate(updateCard.getTranslate());
        }
        if (isFieldSet(updateCard.getSentence())) {
            card.setSentence(updateCard.getSentence());
        }
        if (isFieldSet(updateCard.getSentenceTranslate())) {
            card.setSentenceTranslate(updateCard.getSentenceTranslate());
        }

        return cardRepository.save(card);
    }

    public boolean isFieldSet(String field) {
        return !(field == null || field.isEmpty());
    }
}
