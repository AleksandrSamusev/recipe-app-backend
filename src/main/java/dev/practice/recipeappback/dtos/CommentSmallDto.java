package dev.practice.recipeappback.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        name = "Comment small Dto",
        description = "model to hold comment small DTO"
)
public class CommentSmallDto {

    @Schema(
            description = "Comment id",
            example = "1"
    )
    @NotEmpty(message = "Comment id cannot be empty")
    private Long commentId;

    @Schema(
            description = "Comment content",
            example = "Some comment content goes here"
    )
    @NotEmpty(message = "Comment cannot be empty")
    private String comment;

    @Schema(
            description = "Comment author",
            example = "guest"
    )
    @NotEmpty(message = "Author cannot be empty")
    private String author;

    @Schema(
            description = "The date of creation",
            example = "2024-06-14 03:11:48"
    )
    @NotEmpty(message = "Date cannot be empty")
    private LocalDateTime date;

}
