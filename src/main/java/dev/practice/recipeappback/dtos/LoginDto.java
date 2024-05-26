package dev.practice.recipeappback.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotEmpty(message = "Email field cannot be empty")
    private String usernameOrEmail;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
