package de.nutposit.springsecurityuserservice.mapper;

import de.nutposit.springsecurityuserservice.dto.UserDto;
import de.nutposit.springsecurityuserservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserDto toDto(User user) {
        return new UserDto(user);
    }

    public User toUser(User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        return newUser;
    }
}
