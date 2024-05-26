package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
