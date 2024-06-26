package br.com.cc.cleancut.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.services.UserService;

@Controller
public class IndexController {

    UserService userService;
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("isIndex", true);

        return mv;
    }




} 
