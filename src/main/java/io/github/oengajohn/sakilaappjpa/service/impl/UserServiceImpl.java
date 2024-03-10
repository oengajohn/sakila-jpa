package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.UserDto;
import io.github.oengajohn.sakilaappjpa.entity.User;
import io.github.oengajohn.sakilaappjpa.exception.UserNotFoundException;
import io.github.oengajohn.sakilaappjpa.repository.UserRepository;
import io.github.oengajohn.sakilaappjpa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<UserDto> listUsers(Integer groupId) {
        List<User> userList;
        if (groupId !=null){
            userList = userRepository.findAllByGroupId(groupId); 
        }
        else{
            userList = userRepository.findAll();
        }
        return userList.stream().map(DtoMapper::mapToUserDto).toList();
       
    }

    @Override
    public UserDto getUser(Integer userId) {
        return userRepository.findById(userId).map(DtoMapper::mapToUserDto).orElseThrow(()-> new UserNotFoundException("User not found"));
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        User saved = userRepository.save(DtoMapper.mapToUserEntity(userDto));
        return DtoMapper.mapToUserDto(saved);
    }

    @Override
    public void deleteUser(Integer id, UserDto userDto) {
        userRepository.deleteById(id);
    }
}
