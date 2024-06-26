package dev.practice.recipeappback.services.impl;

import dev.practice.recipeappback.dtos.CommentSmallDto;
import dev.practice.recipeappback.dtos.NewCommentDto;
import dev.practice.recipeappback.exception.ResourceNotFoundException;
import dev.practice.recipeappback.mappers.CommentMapper;
import dev.practice.recipeappback.models.Comment;
import dev.practice.recipeappback.models.Recipe;
import dev.practice.recipeappback.repositories.CommentRepository;
import dev.practice.recipeappback.repositories.RecipeRepository;
import dev.practice.recipeappback.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public CommentSmallDto createCommentToRecipe(Long recipeId, NewCommentDto dto) {

        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(
                ()-> new ResourceNotFoundException("Recipe", "id", recipeId.toString()));
        Comment comment = CommentMapper.toComment(dto);
        comment.setRecipe(recipe);
        Comment savedComment = commentRepository.save(comment);
        log.info("Comment created {}", savedComment);
        return CommentMapper.toCommentSmallDto(savedComment);
    }

    @Override
    public Page<Comment> findAllByRecipeId(Long recipeId, int page, int size) {
        return commentRepository.findAllByRecipeId(recipeId, PageRequest.of(page, size, Sort.by("date").descending()));
    }
}
