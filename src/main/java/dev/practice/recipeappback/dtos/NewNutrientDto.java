package dev.practice.recipeappback.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "New nutrient Dto",
        description = "model to create new nutrient"
)
public class NewNutrientDto {
    @Schema(
            description = "The name of the nutrient",
            example = "Carbon - 1 mg."
    )
    private String name;

    @Schema(
            description = "The recipe id",
            example = "1"
    )
    private Long recipeId;
}

