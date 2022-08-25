package com.arinahitech.englishcards.exceptions.db;

import java.util.function.Supplier;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(Long id) {
        super("The phrase with id = `" + id + "` not found in database.");
    }
}
