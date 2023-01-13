package com.example.deparments.services;

import com.example.deparments.dto.UserPostDto;
import com.example.deparments.entities.User;
import java.util.List;

public interface IUserService {

    List<User> getUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    User saveUser(UserPostDto userDto);

}
