package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.services.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cc.cleancut.model.Image;

import java.io.IOException;

@Controller
public class ImageController {

    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView mv = new ModelAndView("pages/editor");

        return mv;
    }

    @PostMapping("/remove-background")
    public ModelAndView removeBackground(@RequestParam("imageFile") MultipartFile file,
                                   @RequestParam("isPrivate") String isPrivateStr,
                                   RedirectAttributes redirectAttributes) {
        Boolean isPrivate = Boolean.parseBoolean(isPrivateStr);
        String imageUrl = "";

        try {

            byte[] bytes = file.getBytes();

            Image image = new Image();
            image.setData(bytes);
            image.setIsPrivate(isPrivate);

            imageService.saveImage(image);
            imageUrl = "/images/" + image.getId();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelAndView mv = new ModelAndView("pages/editor");
        mv.addObject("imageUrl", imageUrl);
        return mv;
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id){
        Image image = imageService.getImageById(id);

        if(image != null){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/jpeg");
            return new ResponseEntity<>(image.getData(), headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
