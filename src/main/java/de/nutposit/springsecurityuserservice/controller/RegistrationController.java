package de.nutposit.springsecurityuserservice.controller;

import de.nutposit.springsecurityuserservice.dto.UserDto;
import de.nutposit.springsecurityuserservice.model.User;
import de.nutposit.springsecurityuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> newUser(@RequestBody User user) {
        return this.userService.registerUser(user) ?
                new ResponseEntity<>(new UserDto(user), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
