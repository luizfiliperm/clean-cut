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
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("index");
       User user = new User();
       user.setEmail("jpsoares16@hotmail.com");
       user.setPassword("123456");
       user.setName("tuamae");
       userService.save(user);
        return mv;
    }

    

    @GetMapping("/editor")
    public ModelAndView editor() {
        ModelAndView mv = new ModelAndView("pages/editor");
       

        return mv;
    }


    @GetMapping("/perfil")
    public ModelAndView perfil() {
        ModelAndView mv = new ModelAndView("pages/perfil");
       

        return mv;
    }
} 
