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
        name = "New ingredient Dto",
        description = "model to create new ingredient"
)
public class NewIngredientDto {
    @Schema(
            description = "The name of the ingredient",
            example = "Salt - 1 pbs."
    )
    private String name;

    @Schema(
            description = "The recipe id",
            example = "1"
    )
    private Long recipeId;
}
