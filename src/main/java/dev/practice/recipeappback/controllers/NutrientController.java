package dev.practice.recipeappback.controllers;

import dev.practice.recipeappback.dtos.NewNutrientDto;
import dev.practice.recipeappback.models.Nutrient;
import dev.practice.recipeappback.services.NutrientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/nutrients")
@AllArgsConstructor
@Validated
public class NutrientController {

    private final NutrientService nutrientService;

    @PostMapping()
    public ResponseEntity<Nutrient> createNutrient(@RequestBody @Valid NewNutrientDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nutrientService.createNutrient(dto));
    }

}
