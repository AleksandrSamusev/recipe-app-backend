package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.NewStepDto;
import dev.practice.recipeappback.models.Step;
import org.springframework.stereotype.Component;

@Component
public class StepMapper {

    public static Step toStep(NewStepDto dto) {
        Step step = new Step();
        step.setDescription(dto.getDescription());
        step.setStepNumber(dto.getStepNumber());
        return step;
    }

}
