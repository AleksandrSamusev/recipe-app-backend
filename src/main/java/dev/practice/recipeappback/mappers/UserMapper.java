package dev.practice.recipeappback.mappers;

import dev.practice.recipeappback.dtos.NewUserDto;
import dev.practice.recipeappback.models.User;

public class UserMapper {


    public static User toUser(NewUserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setAvatar(dto.getAvatar());
        return user;
    }

}
