package com.arinahitech.englishcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class EnglishCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishCardsApplication.class, args);
	}

	@GetMapping
	public List<String> hello() {
		return Arrays.asList("Hello", "World");
	}

}
