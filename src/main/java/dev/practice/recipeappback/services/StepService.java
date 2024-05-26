package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.NewStepDto;
import dev.practice.recipeappback.models.Step;

public interface StepService {
    Step createStep(NewStepDto dto, Long recipeId);
}
