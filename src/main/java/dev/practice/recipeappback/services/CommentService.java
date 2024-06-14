package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.CommentSmallDto;
import dev.practice.recipeappback.dtos.NewCommentDto;
import dev.practice.recipeappback.models.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    CommentSmallDto createCommentToRecipe(Long recipeId, NewCommentDto dto);

    Page<Comment> findAllByRecipeId(Long recipeId, int page, int size);
}
