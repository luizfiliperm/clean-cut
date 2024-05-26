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

    public boolean check(String password, String userPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), userPassword);
        return result.verified;
    }

}