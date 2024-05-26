package br.com.cc.cleancut.services;

import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class PasswordService {

    public String encrypt(String password) {

        String encryptedPassword = password;
        encryptedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return encryptedPassword;    
    }
}