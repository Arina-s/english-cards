package com.arinahitech.englishcards.repository;

import com.arinahitech.englishcards.modal.db.PracticeTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeTaskRepository extends JpaRepository<PracticeTask, Long> {

}
