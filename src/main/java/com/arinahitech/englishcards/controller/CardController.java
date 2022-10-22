package com.arinahitech.englishcards.controller;

import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @PostMapping
    public Card addCard(@RequestBody @Valid Card card) {
        return cardService.addCard(card);
    }

    @PatchMapping("/{id}")
    public Card updateCard(@PathVariable("id") Long id, @RequestBody @Valid Card card) {
        return cardService.updateCard(id, card);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCard(@PathVariable("id") Long id) {
        return cardService.deleteCard(id);
    }
}
