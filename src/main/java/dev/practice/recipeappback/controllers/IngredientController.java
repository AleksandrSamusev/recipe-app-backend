package dev.practice.recipeappback.controllers;

import dev.practice.recipeappback.dtos.NewIngredientDto;
import dev.practice.recipeappback.models.Ingredient;
import dev.practice.recipeappback.services.IngredientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ingredients")
@AllArgsConstructor
@Validated
public class IngredientController {

        public final IngredientService ingredientService;

        @PostMapping()
    public ResponseEntity<Ingredient> createIngredient(@RequestBody @Valid NewIngredientDto dto) {
            ;
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ingredientService.createIngredient(dto));
        }

}
