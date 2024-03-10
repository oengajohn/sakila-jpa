package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.controller.dto.LoginRequest;
import io.github.oengajohn.sakilaappjpa.controller.dto.UserDto;
import io.github.oengajohn.sakilaappjpa.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    GenericResponse<UserDto> authenticate(@RequestBody LoginRequest loginRequest) {
        return GenericResponse.success(
                authenticationService.authenticate(loginRequest.username(), loginRequest.password())
        );
    }
}
