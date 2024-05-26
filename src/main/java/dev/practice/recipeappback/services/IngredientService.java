package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.NewIngredientDto;
import dev.practice.recipeappback.models.Ingredient;

public interface IngredientService {
    Ingredient createIngredient(NewIngredientDto dto);
}
