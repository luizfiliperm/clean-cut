package br.com.cc.cleancut.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("isIndex", true);

        return mv;
    }

    @GetMapping("/editor")
    public ModelAndView editor() {
        ModelAndView mv = new ModelAndView("pages/editor");
       

        return mv;
    }

    @GetMapping("/explore")
    public ModelAndView explore() {
        ModelAndView mv = new ModelAndView("pages/explore");
       

        return mv;
    }

} 
