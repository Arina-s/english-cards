package com.arinahitech.englishcards;

import com.arinahitech.englishcards.modal.Card;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class EnglishCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishCardsApplication.class, args);
	}

    @GetMapping
    public List<Card> hello() {
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
