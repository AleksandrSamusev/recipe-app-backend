package dev.practice.recipeappback.services;


import dev.practice.recipeappback.dtos.JWTAuthResponse;
import dev.practice.recipeappback.dtos.LoginDto;
import dev.practice.recipeappback.dtos.NewUserDto;

public interface AuthService {
    String register(NewUserDto userNewDto);

    JWTAuthResponse login(LoginDto loginDto);
}
