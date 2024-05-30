package dev.practice.recipeappback.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewCommentDto {
    @NotEmpty(message = "Comment cannot be empty")
    private String comment;
    @NotEmpty(message = "Author cannot be empty")
    private String author;
    @NotEmpty(message = "Date cannot be empty")
    private String date;
}
