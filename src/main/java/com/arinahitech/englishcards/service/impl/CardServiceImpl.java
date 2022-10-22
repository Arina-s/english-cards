package com.arinahitech.englishcards.service.impl;

import com.arinahitech.englishcards.enums.CardStatus;
import com.arinahitech.englishcards.exceptions.db.CardAlreadyExistsException;
import com.arinahitech.englishcards.exceptions.db.CardNotFoundException;
import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.repository.CardRepository;
import com.arinahitech.englishcards.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
    }

    @Override
    public Card addCard(Card card) {
        if (cardRepository.findByPhrase(card.getPhrase()).isPresent()) {
            throw new CardAlreadyExistsException(card.getPhrase());
        }

        log.info("Saving a new card with the phrase: {}", card.getPhrase());
        card.setCreateDate(LocalDateTime.now());
        card.setCardStatus(CardStatus.CREATED);
        return cardRepository.save(card);
    }

    @Override
    public boolean deleteCard(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new CardNotFoundException(id);
        }

        log.info("Deleting the card with id: {}", id);
        cardRepository.deleteById(id);
        return true;
    }

    @Override
    public Card updateCard(Long id, Card updateCard) {
        Card card = getCard(id);

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

        log.info("Updating the card with the phrase: {}", card.getPhrase());
        return cardRepository.save(card);
    }

    private boolean isFieldSet(String field) {
        return !(field == null || field.isEmpty());
    }
}
