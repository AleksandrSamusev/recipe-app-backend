package dev.practice.recipeappback.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewIngredientDto {

    private String name;

    private String value;

    private String units;

    private Long recipeId;
}
