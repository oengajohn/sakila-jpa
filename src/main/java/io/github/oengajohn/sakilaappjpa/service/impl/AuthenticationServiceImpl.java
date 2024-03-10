package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.component.PasswordHasher;
import io.github.oengajohn.sakilaappjpa.controller.dto.UserDto;
import io.github.oengajohn.sakilaappjpa.exception.AuthenticationException;
import io.github.oengajohn.sakilaappjpa.exception.UserNotFoundException;
import io.github.oengajohn.sakilaappjpa.repository.UserRepository;
import io.github.oengajohn.sakilaappjpa.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    boolean isAuthenticated = checkPassword(password, user.getUserPassword());
                    if (isAuthenticated) {
                        return DtoMapper.mapToUserDto(user);
                    }
                    throw new AuthenticationException("Login failed");
                })
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }




    private boolean checkPassword(String inputPassword, String dbPassword) {
        return PasswordHasher.verifyPassword(inputPassword, dbPassword);
    }
}
