package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Page<Recipe> findAllByCategoryAndType(String category, String type, Pageable pageable);

    @Query("SELECT r FROM Recipe r WHERE r.category = :category AND r.type = :type" +
            " AND (lower(r.title) LIKE lower(concat('%',:text,'%'))" +
            " OR lower(r.description) LIKE lower(concat('%', :text, '%')))")
    Page<Recipe> findByCategoryTypeAndText(String category, String type, String text, Pageable pageable);
}
