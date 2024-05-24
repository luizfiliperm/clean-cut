package br.com.cc.cleancut.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("isIndex", true);

        return mv;
    }

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    

} 
