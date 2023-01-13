package com.example.deparments.controllers;

import com.example.deparments.dto.UserGetDto;
import com.example.deparments.dto.UserPostDto;
import com.example.deparments.entities.User;
import com.example.deparments.services.UserServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceImp userService;

    @GetMapping
    ResponseEntity<List<UserGetDto>> getAllUsers() {
        List<User> users = userService.getUsers();
        List<UserGetDto> usersDto = userService.convertUsersToUsersDto(users);
        return ResponseEntity.ok( usersDto );
    }

    @GetMapping("/{id}")
    ResponseEntity<UserGetDto> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        UserGetDto userDto = userService.convertUserToUserDto(user);
        return ResponseEntity.ok( userDto );
    }

    @PostMapping
    ResponseEntity<UserGetDto> saveUser(@RequestBody UserPostDto userPostDto) {
        User user = userService.saveUser(userPostDto);
        UserGetDto userGetDto = userService.convertUserToUserDto(user);
        return new ResponseEntity<>(userGetDto, HttpStatus.CREATED);
    }

}
