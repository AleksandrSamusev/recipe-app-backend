package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByCategoryAndType(String category, String type);

    @Query("SELECT r FROM Recipe r WHERE lower(r.title) LIKE lower(concat('%',:text,'%'))" +
            " OR lower(r.description) LIKE lower(concat('%', :text, '%'))")
    List<Recipe> findByText(@RequestParam("text") String text);
}
