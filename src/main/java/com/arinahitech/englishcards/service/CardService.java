package com.arinahitech.englishcards.service;

import com.arinahitech.englishcards.modal.db.Card;

import java.util.List;

public interface CardService {

    List<Card> getCards();

    Card getCard(Long id);

    Card addCard(Card card);

    boolean deleteCard(Long id);

    Card updateCard(Long id, Card updateCard);

    List<Card> list(int limit);
}
