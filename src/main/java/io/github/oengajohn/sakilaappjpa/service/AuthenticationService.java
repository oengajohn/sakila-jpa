package io.github.oengajohn.sakilaappjpa.service;


import io.github.oengajohn.sakilaappjpa.controller.dto.UserDto;

public interface AuthenticationService {

    UserDto authenticate(String username, String password);
}
