package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> listUsers(Integer groupId);

    UserDto createUser(UserDto userDto);

    void deleteUser(Integer id, UserDto userDto);

    UserDto getUser(Integer userId);
}
