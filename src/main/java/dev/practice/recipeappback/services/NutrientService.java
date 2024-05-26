package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.NewNutrientDto;
import dev.practice.recipeappback.models.Nutrient;

public interface NutrientService {
    Nutrient createNutrient(NewNutrientDto dto);
}
