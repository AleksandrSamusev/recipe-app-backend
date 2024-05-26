package dev.practice.recipeappback.controllers;

import dev.practice.recipeappback.dtos.NewStepDto;
import dev.practice.recipeappback.models.Step;
import dev.practice.recipeappback.services.StepService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/steps")
@AllArgsConstructor
@Validated
public class StepController {

    private final StepService stepService;

    @PostMapping()
    public ResponseEntity<Step> createStep(@RequestBody @Valid NewStepDto dto, Long recipeId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( stepService.createStep(dto, recipeId));
    }
}
