package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
}
