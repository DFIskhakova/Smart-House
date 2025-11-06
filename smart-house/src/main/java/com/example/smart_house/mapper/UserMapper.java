package com.example.smart_house.mapper;

import java.util.stream.Collectors;

import com.example.smart_house.dto.UserDto;
import com.example.smart_house.dto.UserLoggedDto;
import com.example.smart_house.model.Permission;
import com.example.smart_house.model.User;

public class UserMapper {
    public static UserDto userToUserDto (User user) {
        return new UserDto(user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getRole().getAuthority(),
        user.getRole().getPermissions().stream().map(Permission::getAuthority).collect(Collectors.toSet()));
    }

    public static UserLoggedDto userToUserLoggedDto (User user) {
        return new UserLoggedDto(user.getUsername(),
        user.getRole().getAuthority(),
        user.getRole().getPermissions().stream().map(Permission::getAuthority).collect(Collectors.toSet()));
    }
}
