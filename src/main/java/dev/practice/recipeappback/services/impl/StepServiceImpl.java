package dev.practice.recipeappback.services.impl;

import dev.practice.recipeappback.dtos.NewStepDto;
import dev.practice.recipeappback.exception.ResourceNotFoundException;
import dev.practice.recipeappback.mappers.StepMapper;
import dev.practice.recipeappback.models.Recipe;
import dev.practice.recipeappback.models.Step;
import dev.practice.recipeappback.repositories.RecipeRepository;
import dev.practice.recipeappback.repositories.StepRepository;
import dev.practice.recipeappback.services.StepService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class StepServiceImpl implements StepService {

    private final StepRepository stepRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public Step createStep(NewStepDto dto, Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(
                () -> new ResourceNotFoundException("Recipe", "recipeId", recipeId.toString())
        );
        Step step = StepMapper.toStep(dto);
        step.setRecipe(recipe);
        Step savedStep = stepRepository.save(step);
        log.info("Step with id = {} created", savedStep.getStepId());
        return savedStep;
    }
}
