package dev.practice.recipeappback.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto {

    @NotBlank(message = "User first name cannot be blank")
    @Length(max = 50, message = "Users first name should be 50 chars max")
    private String firstName;

    @NotBlank(message = "User last name cannot be blank")
    @Length(max = 50, message = "Users last name should be 50 chars max")
    private String lastName;

    @NotBlank(message = "Username cannot be blank")
    @Length(max = 50, message = "Username should be 50 chars max")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "User email cannot be blank")
    @Length(max = 50, message = "Email length should be 50 chars max")
    @Email(message = "Incorrect email format")
    private String email;

    private String avatar;
}
