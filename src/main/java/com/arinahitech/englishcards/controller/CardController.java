package com.arinahitech.englishcards.controller;

import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @PostMapping
    public void newPhraseRegistration(@RequestBody Card card) {
        cardService.addCard(card);
    }
}
