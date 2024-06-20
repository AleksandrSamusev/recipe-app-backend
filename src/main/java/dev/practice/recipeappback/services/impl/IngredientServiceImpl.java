package dev.practice.recipeappback.services.impl;

import dev.practice.recipeappback.dtos.NewIngredientDto;
import dev.practice.recipeappback.mappers.IngredientMapper;
import dev.practice.recipeappback.models.Ingredient;
import dev.practice.recipeappback.repositories.IngredientRepository;
import dev.practice.recipeappback.services.IngredientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class IngredientServiceImpl implements IngredientService {

    public final IngredientRepository ingredientRepository;


    @Override
    public Ingredient createIngredient(NewIngredientDto dto) {
        dto.setName(dto.getName().trim().replaceAll("\\s{2,}", " "));
        Ingredient savedIngredient = ingredientRepository.save(IngredientMapper.toIngredient(dto));
        log.info("New ingredient with id = {} created", savedIngredient.getIngredientId());
        return savedIngredient;
    }
}
