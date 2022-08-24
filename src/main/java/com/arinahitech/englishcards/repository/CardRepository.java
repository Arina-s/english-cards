package com.arinahitech.englishcards.repository;

import com.arinahitech.englishcards.modal.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
