package br.com.cc.cleancut.services;

import org.springframework.stereotype.Service;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.repositories.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(user);
    }



    
}

