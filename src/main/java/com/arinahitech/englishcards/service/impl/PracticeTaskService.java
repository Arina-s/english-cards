package com.arinahitech.englishcards.service.impl;

import com.arinahitech.englishcards.enums.TaskStatus;
import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.modal.db.PracticeMode;
import com.arinahitech.englishcards.modal.db.PracticeTask;
import com.arinahitech.englishcards.repository.PracticeTaskRepository;
import com.arinahitech.englishcards.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PracticeTaskService {

    private final CardService cardService;
    private final PracticeTaskRepository practiceTaskRepository;

    public List<PracticeTask> getPracticeTasks() {
        return practiceTaskRepository.findAll();
    }

    public void createPracticeTask(PracticeMode practiceMode) {
        PracticeTask practiceTask = new PracticeTask();
        practiceTask.setNumberOfCards(practiceMode.getNumberOfCards());
        practiceTask.setStartWith(practiceMode.getStartWith());
        practiceTask.setStartDate(new Date());
        practiceTask.setTaskStatus(TaskStatus.CREATED);
        practiceTask.setCardsList(getFilteredCards(practiceTask, cardService.getCards()));
        practiceTaskRepository.save(practiceTask);
    }

    public void finishPracticeTask(Long id) {
        var practiceTask = practiceTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found task"));
        practiceTask.setEndDate(new Date());
        practiceTask.setTaskStatus(TaskStatus.FINISHED);
        practiceTaskRepository.save(practiceTask);
    }

    public PracticeTask getLastStartedPracticeTask() {
        return getPracticeTasks().stream()
                .filter(practiceTask -> practiceTask.getTaskStatus().equals(TaskStatus.CREATED))
                .max((Comparator.comparing(PracticeTask::getStartDate)))
                .orElseThrow(() -> new RuntimeException("not found practice task"));
    }

    private List<Card> getFilteredCards(PracticeTask practiceTask, List<Card> allCards) {
        List<Card> resultList = new ArrayList<>();
        switch (practiceTask.getStartWith()) {
            case "startWithNewest":
                resultList = allCards.stream()
                        .sorted((Comparator.comparing(Card::getCreateDate)).reversed())
                        .limit(practiceTask.getNumberOfCards())
                        .collect(Collectors.toList());
                break;
            case "startWithOldest":
                resultList = allCards.stream()
                        .sorted((Comparator.comparing(Card::getCreateDate)))
                        .limit(practiceTask.getNumberOfCards())
                        .collect(Collectors.toList());
                break;
            case "random":
                Collections.shuffle(allCards, new Random(System.nanoTime()));
                resultList = allCards.stream()
                        .limit(practiceTask.getNumberOfCards())
                        .collect(Collectors.toList());
                break;

        }
        return resultList;
    }
}
