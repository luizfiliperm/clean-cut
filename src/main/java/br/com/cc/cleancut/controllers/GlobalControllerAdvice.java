package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.model.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("loggedUser")
    public User getLoggedUser(@SessionAttribute(value = "loggedUser", required = false) User loggedUser) {
        return loggedUser;
    }
}