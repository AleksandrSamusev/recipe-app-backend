package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.recipe.recipeId = :recipeId")
    Page<Comment> findAllByRecipeId(Long recipeId, Pageable pageable);
}
