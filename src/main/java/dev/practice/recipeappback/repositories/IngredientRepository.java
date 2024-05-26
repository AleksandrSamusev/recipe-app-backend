package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
