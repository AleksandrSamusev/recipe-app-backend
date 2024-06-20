package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.NewRecipeDto;
import dev.practice.recipeappback.models.Recipe;
import dev.practice.recipeappback.models.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class RecipeMapper {

    public static Recipe toRecipe(NewRecipeDto dto, User user) {
        Recipe recipe = new Recipe();
        recipe.setCategory(dto.getCategory());
        recipe.setAuthor(user);
        recipe.setType(dto.getType());
        recipe.setMainIngredient(dto.getMainIngredient());
        recipe.setTitle(dto.getTitle());
        recipe.setDescription(dto.getDescription());
        recipe.setRating(dto.getRating());
        recipe.setPrepareTime(dto.getPrepareTime());
        recipe.setCookingTime(dto.getCookingTime());
        recipe.setImgMedium(dto.getImgMedium());
        recipe.setImgSmall1(dto.getImgSmall1());
        recipe.setImgSmall2(dto.getImgSmall2());
        recipe.setImgSmall3(dto.getImgSmall3());
        recipe.setImgSmall4(dto.getImgSmall4());
        recipe.setIngredients(new HashSet<>());
        recipe.setNutrients(new HashSet<>());
        recipe.setSteps(new HashSet<>());
        recipe.setComments(new HashSet<>());
        return recipe;
    }
}
