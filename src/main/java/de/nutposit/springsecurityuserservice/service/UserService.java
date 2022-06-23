package de.nutposit.springsecurityuserservice.service;

import de.nutposit.springsecurityuserservice.dto.UserDto;
import de.nutposit.springsecurityuserservice.model.User;

import java.util.ArrayList;

public interface UserService {

    ArrayList<UserDto> getUsers();
    boolean registerUser(User user);
}
