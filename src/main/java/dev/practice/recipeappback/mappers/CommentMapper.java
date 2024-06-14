package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.CommentSmallDto;
import dev.practice.recipeappback.dtos.NewCommentDto;
import dev.practice.recipeappback.models.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentMapper {

    public static Comment toComment(NewCommentDto dto) {
        Comment comment = new Comment();
        comment.setComment(dto.getComment());
        comment.setAuthor(dto.getAuthor());
        comment.setDate(LocalDateTime.now());
        return comment;
    }

    public static CommentSmallDto toCommentSmallDto(Comment comment) {
        CommentSmallDto dto = new CommentSmallDto();
        dto.setCommentId(comment.getCommentId());
        dto.setComment(comment.getComment());
        dto.setAuthor(comment.getAuthor());
        dto.setDate(comment.getDate());
        return dto;
    }
}
