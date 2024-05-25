package br.com.cc.cleancut.services;

import org.springframework.stereotype.Service;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.repositories.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordService passwordService;

    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public User save(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(passwordService.encrypt(user.getPassword()));
        return userRepository.save(user);
    }



    
}

