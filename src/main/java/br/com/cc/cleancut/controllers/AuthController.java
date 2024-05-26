package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("loggedUser") // Armazena "loggedUser" na sessão
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public ModelAndView login() {
        return new ModelAndView("pages/authentication");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model) {

        try {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            userService.register(user, confirmPassword);
            model.addAttribute("loggedUser", user);
            return new ModelAndView("redirect:/");
        } catch (RuntimeException e) {
            ModelAndView mav = new ModelAndView("pages/authentication");
            mav.addObject("error", e.getMessage());
            return mav;
        }
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model model) {
        try {
            // Autentica o usuário
            User user = userService.login(email, password);
            model.addAttribute("loggedUser", user);
            return new ModelAndView("redirect:/");
        } catch (RuntimeException e) {
            ModelAndView mav = new ModelAndView("pages/authentication");
            mav.addObject("error", e.getMessage());
            return mav;
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
}
