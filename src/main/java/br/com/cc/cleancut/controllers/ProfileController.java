package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.model.Image;
import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {

    ImageService imageService;

    public ProfileController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/perfil")
    public ModelAndView perfil(@SessionAttribute("loggedUser") User loggedUser) {
        ModelAndView mv = new ModelAndView("pages/perfil");

        List<Long> imagesIds = imageService.findAllUserImages(loggedUser.getId());
        Long totalImages = imageService.countImagesByUserId(loggedUser.getId());
        Long totalLikes = imageService.countTotalLikes(loggedUser.getId());
        Long totalDownloads = imageService.countTotalDownloads(loggedUser.getId());

        mv.addObject("imagesIds", imagesIds);
        mv.addObject("totalImages", totalImages);
        mv.addObject("totalLikes", totalLikes);
        mv.addObject("totalDownloads", totalDownloads);

        return mv;
    }

}
