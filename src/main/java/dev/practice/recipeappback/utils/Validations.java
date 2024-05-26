package dev.practice.recipeappback.utils;

import dev.practice.recipeappback.exception.ActionForbiddenException;
import dev.practice.recipeappback.exception.InvalidParameterException;
import dev.practice.recipeappback.exception.ResourceNotFoundException;
import dev.practice.recipeappback.models.Recipe;
import dev.practice.recipeappback.models.Role;
import dev.practice.recipeappback.models.User;
import dev.practice.recipeappback.repositories.RecipeRepository;
import dev.practice.recipeappback.repositories.RoleRepository;
import dev.practice.recipeappback.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class Validations {
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;
    private final RecipeRepository recipeRepository;

    public User checkUserExist(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            log.error("User with id {} wasn't found", userId);
            throw new ResourceNotFoundException("User", "user id", userId.toString() );
        }
        return user.get();
    }

    public User checkUserExistsByUsernameOrEmail(String usernameOrEmail) {
        Optional<User> user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
        if (user.isEmpty()) {
            log.error("User with given credentials not found");
            throw new ResourceNotFoundException("User", "username or email", usernameOrEmail);
        }
        return user.get();
    }

    public Boolean isExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Boolean isExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public void checkUserIsAuthor(Recipe recipe, Long userId) {
        if (!recipe.getAuthor().getUserId().equals(userId)) {
            log.error("Recipe with id {} is not belongs to user with id {}", recipe.getRecipeId(), userId);
            throw new ActionForbiddenException(String.format(
                    "Article with id %d is not belongs to user with id %s. Action is forbidden",
                    recipe.getRecipeId(), userId));
        }
    }

    public void isUserAuthorized(Long userId, User currentUser) {
        if (!userId.equals(currentUser.getUserId())) {
            log.error("ActionForbiddenException. Action forbidden for current user");
            throw new ActionForbiddenException("Action forbidden for current user");
        }
    }

    public Recipe checkRecipeExist(Long recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (recipe.isEmpty()) {
            log.error("Recipe with id {} wasn't found", recipeId);
            throw new ResourceNotFoundException("Recipe", "id", recipeId.toString());
        }
        return recipe.get();
    }

    public Boolean isAdmin(String username) {
        UserDetails details = userDetailsService.loadUserByUsername(username);
        return details != null && details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    public Boolean usernameAlreadyExists(String username) {
        String formattedUsername = username.trim().replaceAll("\\s+", "").toLowerCase();
        return userRepository.findAll().stream()
                .anyMatch(n -> n.getUsername().toLowerCase().equals(formattedUsername));
    }

    public Boolean isRoleExistsByName(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        return role.isPresent();
    }
}
