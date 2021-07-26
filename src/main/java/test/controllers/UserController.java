package test.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.dtos.UserDto;
import test.dtos.UserIdDto;
import test.models.UserEntity;
import test.models.UserId;
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

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto newUser) {
        UserEntity user = userService.createUser(convertDto(newUser));
        return convertEntity(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserIdDto userId) {
        userService.deleteUser(modelMapper.map(userId, UserId.class));
    }

    private UserDto convertEntity(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    private UserEntity convertDto(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}