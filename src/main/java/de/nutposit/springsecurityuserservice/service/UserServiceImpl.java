package de.nutposit.springsecurityuserservice.service;

import de.nutposit.springsecurityuserservice.dto.UserDto;
import de.nutposit.springsecurityuserservice.mapper.Mapper;
import de.nutposit.springsecurityuserservice.model.User;
import de.nutposit.springsecurityuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    public UserServiceImpl(@Autowired UserRepository userRepository,
                           @Autowired Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public ArrayList<UserDto> getUsers() {
        ArrayList<UserDto> users = new ArrayList<>();
        this.userRepository.findAll().forEach(u -> users.add(mapper.toDto(u)));
        return users;
    }

    @Override
    public boolean registerUser(User user) {
        if(!this.userRepository.existsByEmail(user.getEmail())) {
            User newUser = mapper.toUser(user);
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            this.userRepository.save(newUser);
            return true;
        } else {
         return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(!this.userRepository.existsByEmail(email)) {
            throw new UsernameNotFoundException(email);
        }
        return this.userRepository.findByEmail(email);
    }
}
