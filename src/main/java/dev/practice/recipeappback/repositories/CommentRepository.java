package dev.practice.recipeappback.repositories;

import dev.practice.recipeappback.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
