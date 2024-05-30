package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.NewCommentDto;
import dev.practice.recipeappback.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public static Comment toComment(NewCommentDto dto) {
        Comment comment = new Comment();
        comment.setComment(dto.getComment());
        comment.setAuthor(dto.getAuthor());
        comment.setDate(dto.getDate());
        return comment;
    }
}
