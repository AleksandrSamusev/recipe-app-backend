package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.NewCommentDto;
import dev.practice.recipeappback.dtos.NewRecipeDto;
import dev.practice.recipeappback.models.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipes();

    boolean createRecipe(NewRecipeDto dto, String login);

    Recipe getRecipeById(Long recipeId);

    Page<Recipe> findAllByCategoryAndType(String category, String type, String text, int page, int size);

    void deleteRecipe(String username, Long recipeId);

    double updateRating(Long recipeId, String rating);
}
