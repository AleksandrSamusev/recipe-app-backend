package dev.practice.recipeappback.services.impl;

import dev.practice.recipeappback.dtos.NewIngredientDto;
import dev.practice.recipeappback.dtos.NewNutrientDto;
import dev.practice.recipeappback.dtos.NewRecipeDto;
import dev.practice.recipeappback.dtos.NewStepDto;
import dev.practice.recipeappback.exception.ResourceNotFoundException;
import dev.practice.recipeappback.mappers.RecipeMapper;
import dev.practice.recipeappback.models.*;
import dev.practice.recipeappback.repositories.RecipeRepository;
import dev.practice.recipeappback.repositories.UserRepository;
import dev.practice.recipeappback.services.IngredientService;
import dev.practice.recipeappback.services.NutrientService;
import dev.practice.recipeappback.services.RecipeService;
import dev.practice.recipeappback.services.StepService;
import dev.practice.recipeappback.utils.Validations;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private final StepService stepService;
    private final NutrientService nutrientService;
    private final Validations validations;
    private final UserRepository userRepository;

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public boolean createRecipe(NewRecipeDto dto, String login) {

        User user = validations.checkUserExistsByUsernameOrEmail(login);

        Set<Ingredient> savedIngredients = new HashSet<>();
        Set<Nutrient> savedNutrients = new HashSet<>();

        Set<NewIngredientDto> ingredientDtos = dto.getIngredients();
        Set<NewNutrientDto> nutrientDtos = dto.getNutrients();
        Set<NewStepDto> stepDtos = dto.getSteps();

        ingredientDtos.forEach(item -> {
            savedIngredients.add(ingredientService.createIngredient(item));
        });
        nutrientDtos.forEach(item -> {
            savedNutrients.add(nutrientService.createNutrient(item));
        });

        Recipe recipe = RecipeMapper.toRecipe(dto, user);
        recipe.setIngredients(savedIngredients);
        recipe.setNutrients(savedNutrients);

        Recipe savedRecipe = recipeRepository.save(recipe);
/*        user.getRecipes().add(savedRecipe);
        userRepository.save(user);*/

        stepDtos.forEach(item -> {
            stepService.createStep(item, savedRecipe.getRecipeId());
        });

        log.info("Recipe created id = {}", savedRecipe.getRecipeId());
        return true;
    }

    @Override
    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElseThrow(
                () -> new ResourceNotFoundException("Recipe", "recipeId", recipeId.toString()));
    }

    @Override
    public List<Recipe> findAllByCategoryAndType(String category, String type, String text) {
        List<Recipe> recipes = recipeRepository.findAllByCategoryAndType(category, type);
        if (text != null && !text.equals("")) {
           return recipes.stream()
                    .filter(recipe -> recipe.getTitle().toLowerCase().contains(text.trim().toLowerCase())
                            || recipe.getDescription().toLowerCase().contains(text.trim().toLowerCase()))
                    .collect(Collectors.toList());
        }
        return recipes;
    }

    @Override
    public void deleteRecipe(String username, Long recipeId) {
        User user = validations.checkUserExistsByUsernameOrEmail(username);
        Recipe recipe = validations.checkRecipeExist(recipeId);

        if (!validations.isAdmin(username)) {
            validations.checkUserIsAuthor(recipe, user.getUserId());
        }

        recipeRepository.deleteById(recipeId);
        log.info("Recipe with id {} was deleted", recipeId);
    }
}
