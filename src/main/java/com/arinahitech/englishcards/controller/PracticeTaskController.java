package com.arinahitech.englishcards.controller;

import com.arinahitech.englishcards.modal.db.Card;
import com.arinahitech.englishcards.modal.db.PracticeMode;
import com.arinahitech.englishcards.modal.db.PracticeTask;
import com.arinahitech.englishcards.service.impl.PracticeTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/practices")
@RequiredArgsConstructor
public class PracticeTaskController {

    private final PracticeTaskService practiceTaskService;

    @PostMapping
    public void createPractiseTask(@RequestBody PracticeMode practiceMode) {
        practiceTaskService.createPracticeTask(practiceMode);
    }

    @GetMapping
    public List<PracticeTask> getPractiseTasks() {
        return practiceTaskService.getPracticeTasks();
    }

    @PostMapping("/finish/{id}")
    public void finishPractiseTask(@PathVariable("id") Long id) {
        practiceTaskService.finishPracticeTask(id);
    }

    @GetMapping("/cards")
    public List<Card> getCardsForPracticeTask() {
        return practiceTaskService.getLastStartedPracticeTask().getCardsList();
    }
}
