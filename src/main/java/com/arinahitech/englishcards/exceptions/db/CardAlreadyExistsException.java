package com.arinahitech.englishcards.exceptions.db;

public class CardAlreadyExistsException extends RuntimeException {

    public CardAlreadyExistsException(String phrase) {
        super("The phrase '" + phrase + "' already exists.");
    }
}
