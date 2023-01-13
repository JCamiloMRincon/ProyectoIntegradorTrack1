package com.example.deparments.services;

import com.example.deparments.dto.UserGetDto;
import com.example.deparments.dto.UserPostDto;
import com.example.deparments.entities.City;
import com.example.deparments.entities.Role;
import com.example.deparments.entities.User;
import com.example.deparments.repositories.ICityRepository;
import com.example.deparments.repositories.IRoleRepository;
import com.example.deparments.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICityRepository cityRepository;
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The user with id " + id + " does not exist");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The user with email " + email + " does not exist");
        }
    }

    @Override
    public User saveUser(UserPostDto userDto) {
        User user = convertUserDtoToUser(userDto);
        return userRepository.save( user );
    }

    public User convertUserDtoToUser(UserPostDto userDto) {

        User user = new User();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (userDto.getCiudadId() == null) {
            userDto.setCiudadId(1L);
        }
        if (userDto.getRolId() == null) {
            userDto.setRolId(2L);
        }

        City city = cityRepository.findById(userDto.getCiudadId()).get();
        Role role = roleRepository.findById(userDto.getRolId()).get();

        user.setNombre( userDto.getNombre() );
        user.setApellido( userDto.getApellido() );
        user.setEmail( userDto.getEmail() );
        user.setContrasenia( passwordEncoder.encode(userDto.getContrasenia()) );
        user.setCiudad( city );
        user.setRol( role );

        return user;
    }

    public UserGetDto convertUserToUserDto(User user) {

        UserGetDto userDto = new UserGetDto();

        userDto.setId( user.getId() );
        userDto.setNombre( user.getNombre() );
        userDto.setApellido( user.getApellido() );
        userDto.setEmail( user.getEmail() );

        return userDto;
    }

    public List<UserGetDto> convertUsersToUsersDto(List<User> users) {

        List<UserGetDto> usersDto = new ArrayList<>();

        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UserGetDto userDto = new UserGetDto();

            userDto.setId( user.getId() );
            userDto.setNombre( user.getNombre() );
            userDto.setApellido( user.getApellido() );
            userDto.setEmail( user.getEmail() );

            usersDto.add( userDto );
        }

        return usersDto;
    }
}
