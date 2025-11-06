package com.example.smart_house.service;

import java.util.List;
import com.example.smart_house.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.example.smart_house.dto.UserDto;
import com.example.smart_house.exception.ResourceNotFoundException;
import com.example.smart_house.mapper.UserMapper;
import com.example.smart_house.model.User;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::userToUserDto).toList();
    }

    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + "not found"));
        return UserMapper.userToUserDto(user);
    }

    public UserDto getUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User with username " + username + "not found"));
        return UserMapper.userToUserDto(user);
    }
}
