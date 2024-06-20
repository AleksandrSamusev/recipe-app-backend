package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.NewNutrientDto;
import dev.practice.recipeappback.models.Nutrient;
import org.springframework.stereotype.Component;

@Component
public class NutrientMapper {

    public static Nutrient toNutrient(NewNutrientDto dto) {
        Nutrient nutrient = new Nutrient();
        nutrient.setName(dto.getName());
        return nutrient;
    }
}
