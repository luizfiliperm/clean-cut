package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public ModelAndView login() {
        return new ModelAndView("pages/login");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword) {

        try {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userService.register(user, confirmPassword);
            return new ModelAndView("redirect:/");
        } catch (RuntimeException e) {
            ModelAndView mv = new ModelAndView("pages/login");
            mv.addObject("error", e.getMessage());
            return mv;
        }
    }

}
