package com.arinahitech.englishcards.repository;

import com.arinahitech.englishcards.modal.db.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByPhrase(String phrase);

}
