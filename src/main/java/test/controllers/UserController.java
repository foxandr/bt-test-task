package test.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.dtos.UserDto;
import test.models.UserEntity;
import test.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public List<UserDto> getUsersList() {
        return userService.getUsers().stream()
                .map(this::convertEntity)
                .collect(Collectors.toList());
    }

    private UserDto convertEntity(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }
}