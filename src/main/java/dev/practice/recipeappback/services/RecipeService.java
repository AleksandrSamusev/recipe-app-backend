package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.NewRecipeDto;
import dev.practice.recipeappback.models.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();

    boolean createRecipe(NewRecipeDto dto, String login);

    Recipe getRecipeById(Long recipeId);

    List<Recipe> findAllByCategoryAndType(String category, String type, String text);

    void deleteRecipe(String username, Long recipeId);
}
