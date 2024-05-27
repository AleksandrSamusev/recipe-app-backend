package dev.practice.recipeappback.controllers;

import dev.practice.recipeappback.dtos.NewRecipeDto;
import dev.practice.recipeappback.models.Recipe;
import dev.practice.recipeappback.services.RecipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/recipes")
@Validated
@AllArgsConstructor
@Tag(
        name = "Controller to perform operations with a Recipes",
        description = "Controller to perform operations with a Recipes"
)
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping()
    public ResponseEntity<List<Recipe>> getRecipes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recipeService.getRecipes());
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long recipeId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recipeService.getRecipeById(recipeId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<Recipe>> findAllByCategoryAndType(@RequestParam String category,
                                                                 @RequestParam String type,
                                                                 @RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "6") int size,
                                                                 @RequestParam(required = false) String text) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recipeService.findAllByCategoryAndType(category, type, text, page, size));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping()
    public ResponseEntity<String> createRecipe(@RequestBody @Valid NewRecipeDto dto,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        boolean isCreated = recipeService.createRecipe(dto, userDetails.getUsername());
        return ResponseEntity
                .status(isCreated ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR)
                .body(isCreated ? "Recipe created!" : "Something went wrong");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@AuthenticationPrincipal UserDetails userDetails,
                                               @PathVariable Long recipeId) {
        recipeService.deleteRecipe(userDetails.getUsername(), recipeId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Recipe deleted!");
    }

}
