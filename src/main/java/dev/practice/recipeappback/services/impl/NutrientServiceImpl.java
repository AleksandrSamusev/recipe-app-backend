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
        dto.setName(dto.getName().trim().replaceAll("\\s{2,}", " "));
        dto.setValue(dto.getValue().trim().replaceAll("\\s{2,}", " "));
        dto.setUnits(dto.getUnits().trim().replaceAll("\\s{2,}", " "));
        Nutrient savedNutrient =  nutrientRepository.save(NutrientMapper.toNutrient(dto));
        log.info("Nutrient with id = {} created", savedNutrient.getNutrientId());
        return savedNutrient;
    }

}
