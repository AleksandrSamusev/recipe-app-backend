package dev.practice.recipeappback.services;

import dev.practice.recipeappback.dtos.NewCommentDto;

public interface CommentService {
    void createCommentToRecipe(Long recipeId, NewCommentDto dto);
}
