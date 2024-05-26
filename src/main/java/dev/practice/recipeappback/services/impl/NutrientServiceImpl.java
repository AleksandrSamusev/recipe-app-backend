package dev.practice.recipeappback.services.impl;

import dev.practice.recipeappback.dtos.NewNutrientDto;
import dev.practice.recipeappback.mappers.NutrientMapper;
import dev.practice.recipeappback.models.Nutrient;
import dev.practice.recipeappback.repositories.NutrientRepository;
import dev.practice.recipeappback.services.NutrientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NutrientServiceImpl implements NutrientService {

    private final NutrientRepository nutrientRepository;

    @Override
    public Nutrient createNutrient(NewNutrientDto dto) {
        Nutrient savedNutrient =  nutrientRepository.save(NutrientMapper.toNutrient(dto));
        log.info("Nutrient with id = {} created", savedNutrient.getNutrientId());
        return savedNutrient;
    }
}
