package dev.practice.recipeappback.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentSmallDto {
    @NotEmpty(message = "Comment id cannot be empty")
    private Long commentId;
    @NotEmpty(message = "Comment cannot be empty")
    private String comment;
    @NotEmpty(message = "Author cannot be empty")
    private String author;
    @NotEmpty(message = "Date cannot be empty")
    private LocalDateTime date;

}
