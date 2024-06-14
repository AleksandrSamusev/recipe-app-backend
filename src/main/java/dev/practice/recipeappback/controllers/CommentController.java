package dev.practice.recipeappback.controllers;

import dev.practice.recipeappback.models.Comment;
import dev.practice.recipeappback.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/comments")
@AllArgsConstructor
@Validated
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/recipes/{recipeId}")
    public ResponseEntity<Page<Comment>> findAllByRecipeId(@PathVariable Long recipeId,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "6") int size
                                                           ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.findAllByRecipeId(recipeId, page, size));
    }

}
