package dev.practice.recipeappback.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "New recipe Dto",
        description = "model to hold new recipe"
)
public class NewRecipeDto {

    @Schema(
            description = "The category of the recipe",
            example = "soups"
    )
    @NotEmpty(message = "Category parameter cannot be empty")
    private String category;

    @Schema(
            description = "The type (or sub-category) of the recipe",
            example = "vegetarian"
    )
    @NotEmpty(message = "Type parameter cannot be empty")
    private String type;

    @Schema(
            description = "The main ingredient of the recipe",
            example = "chicken"
    )
    @NotEmpty(message = "Main ingredient parameter cannot be empty")
    private String mainIngredient;

    @Schema(
            description = "The title of the recipe",
            example = "Indian Chicken Curry"
    )
    @NotEmpty(message = "Title parameter cannot be empty")
    @Length(max = 50)
    private String title;

    @Schema(
            description = "The description of the recipe",
            example = "This crispy fried chicken recipe uses a batter instead of a flour coating."
    )
    @NotEmpty(message = "Description parameter cannot be empty")
    @Length(max = 500)
    private String description;

    @Schema(
            description = "The rating of the recipe",
            example = "3"
    )
    @PositiveOrZero(message = "The value should be positive or zero")
    @Max(value = 5, message = "The max value is 5")
    private Integer rating;

    @Schema(
            description = "Time required to prepare for the start of the cooking process",
            example = "15 min."
    )
    @NotEmpty(message = "Prepare time parameter cannot be empty")
    @Length(max = 100)
    private String prepareTime;

    @Schema(
            description = "Time required to prepare the dish (excluding preparatory steps)",
            example = "45 min."
    )
    @NotEmpty(message = "Cooking time parameter cannot be empty")
    @Length(max = 100)
    private String cookingTime;

    @Schema(
            description = "Main large image 800x600 placed on Recipes page"
    )
    @NotEmpty(message = "Large image parameter cannot be empty")
    private String imgLarge;

    @Schema(
            description = "Medium image 400x400 placed on certain recipe page"
    )
    @NotEmpty(message = "Medium image parameter cannot be empty")
    private String imgMedium;

    @Schema(
            description = "Small image 200x200 placed on certain recipe page (top-left)"
    )
    @NotEmpty(message = "Small image 1 parameter cannot be empty")
    private String imgSmall1;

    @Schema(
            description = "Small image 200x200 placed on certain recipe page (bottom-left)"
    )
    @NotEmpty(message = "Small image 2 parameter cannot be empty")
    private String imgSmall2;

    @Schema(
            description = "Small image 200x200 placed on certain recipe page (top-right)"
    )
    @NotEmpty(message = "Small image 3 parameter cannot be empty")
    private String imgSmall3;

    @Schema(
            description = "Small image 200x200 placed on certain recipe page (bottom-right)"
    )
    @NotEmpty(message = "Small image 4 parameter cannot be empty")
    private String imgSmall4;

    Set<NewIngredientDto> ingredients;

    Set<NewNutrientDto> nutrients;

    Set<NewStepDto> steps;
}
