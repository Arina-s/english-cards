package com.arinahitech.englishcards.controller;

import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.modal.db.Response;
import com.arinahitech.englishcards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResponseEntity<Response> getCards() {
        System.out.println("Working Directory = " + System.getProperty("user.dir") + "src/main/resources/static/img");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK)
                        .message("Cards retrieved")
                        .data(Map.of("cards", cardService.list(10)))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<Response> newPhraseRegistration(@RequestBody @Valid Card card) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .message("Card saved")
                        .data(Map.of("card", cardService.addCard(card)))
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Response> updateCard(@PathVariable("id") Long id, @RequestBody @Valid Card card) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK)
                        .message("Card updated")
                        .data(Map.of("card", cardService.updateCard(id, card)))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK)
                        .message("Card deleted")
                        .data(Map.of("delete", cardService.deleteCard(id)))
                        .build()
        );
    }

    @GetMapping(path = "/images/cardStatus/{id}", produces = IMAGE_PNG_VALUE)
    public byte[] getStatusImage(@PathVariable("id") Long id) throws IOException {
        return Files.readAllBytes(Paths.get(
                System.getProperty("user.dir") + "/src/main/resources/static/images/cardstatus/" +
                        cardService.getCard(id).getCardStatus().getImgName()));
    }
}
