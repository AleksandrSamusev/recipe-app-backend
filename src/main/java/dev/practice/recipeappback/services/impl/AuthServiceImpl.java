package dev.practice.recipeappback.services.impl;

import dev.practice.recipeappback.dtos.JWTAuthResponse;
import dev.practice.recipeappback.dtos.LoginDto;
import dev.practice.recipeappback.dtos.NewUserDto;
import dev.practice.recipeappback.exception.InvalidParameterException;
import dev.practice.recipeappback.exception.ResourceNotFoundException;
import dev.practice.recipeappback.mappers.UserMapper;
import dev.practice.recipeappback.models.Role;
import dev.practice.recipeappback.models.User;
import dev.practice.recipeappback.repositories.RoleRepository;
import dev.practice.recipeappback.repositories.UserRepository;
import dev.practice.recipeappback.security.JWTTokenProvider;
import dev.practice.recipeappback.services.AuthService;
import dev.practice.recipeappback.utils.Validations;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;
    private final Validations validations;

    @Override
    public String register(NewUserDto userNewDto) {

        if (validations.usernameAlreadyExists(userNewDto.getUsername())) {
            throw new InvalidParameterException(
                    "User with given username '" + userNewDto.getUsername() + "' is already exists");
        }
        if (validations.isExistsByEmail(userNewDto.getEmail())) {
            throw new InvalidParameterException(
                    "User with given email '" + userNewDto.getEmail() +"' is already exists");
        }

        User user = UserMapper.toUser(userNewDto);
        user.setPassword(passwordEncoder.encode(userNewDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName("ROLE_USER");

        if(userRole.isPresent()) {
            roles.add(userRole.get());
            user.setRoles(roles);
            User savedUser = userRepository.save(user);
            log.info("New user with ID = {} successfully registered", savedUser.getUserId());
            return "New user with ID = " + savedUser.getUserId() + " successfully registered";
        } else {
            throw new ResourceNotFoundException("Role", "role", "ROLE_USER");
        }
    }

    @Override
    public JWTAuthResponse login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        Optional<User> userOptional = userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(),
                loginDto.getUsernameOrEmail());

        String role = null;

        if (userOptional.isPresent()) {
            User loggedInUser = userOptional.get();
            Optional<Role> optionalRole = loggedInUser.getRoles().stream().findFirst();
            if (optionalRole.isPresent()) {
                Role userRole = optionalRole.get();
                role = userRole.getName();
            }
        }

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setRole(role);
        jwtAuthResponse.setAccessToken(token);
        userOptional.ifPresent(user -> jwtAuthResponse.setUserId(user.getUserId().toString()));

        return jwtAuthResponse;
    }
}
