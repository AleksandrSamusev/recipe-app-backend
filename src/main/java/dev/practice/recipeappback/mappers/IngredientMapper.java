package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.NewIngredientDto;
import dev.practice.recipeappback.models.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public static Ingredient toIngredient(NewIngredientDto dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setValue(dto.getValue());
        ingredient.setUnits(dto.getUnits());
        return ingredient;
    }
}
