package dev.practice.recipeappback.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(
        name = "New Comment Dto",
        description = "model to hold new comment"
)
public class NewCommentDto {
    @Schema(
            description = "The body of the comment",
            example = "This is a vary tasty dish!"
    )
    @NotEmpty(message = "Comment cannot be empty")
    private String comment;
    @Schema(
            description = "The name of the comment author",
            example = "Admin"
    )
    @NotEmpty(message = "Author cannot be empty")
    private String author;
}
