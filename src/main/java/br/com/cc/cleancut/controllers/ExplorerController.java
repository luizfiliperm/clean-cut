package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExplorerController {

    ImageService imageService;

    public ExplorerController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/explore")
    public ModelAndView explore(@SessionAttribute("loggedUser") User loggedUser) {

        ModelAndView mv = new ModelAndView("pages/explore");
        mv.addObject("explorer", imageService.getExploreImages(loggedUser.getId()));

        return mv;
    }
}
