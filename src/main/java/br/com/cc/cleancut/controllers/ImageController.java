package br.com.cc.cleancut.controllers;

import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.services.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/remove-background")
    public ModelAndView edit() {
        ModelAndView mv = new ModelAndView("pages/editor");

        return mv;
    }

    @PostMapping("/remove-background")
    public ModelAndView removeBackground(@RequestParam("imageFile") MultipartFile file,
                                         @RequestParam("isPrivate") String isPrivateStr,
                                         @SessionAttribute("loggedUser") User loggedUser,
                                         RedirectAttributes redirectAttributes) {
        Boolean isPrivate = Boolean.parseBoolean(isPrivateStr);
        String imageUrl = "";

        try {

            byte[] bytes = file.getBytes();

            Image image = new Image();
            image.setData(bytes);
            image.setIsPrivate(isPrivate);

            imageService.saveImage(image, loggedUser);
            imageUrl = "/images/" + image.getId();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelAndView mv = new ModelAndView("pages/editor");
        mv.addObject("imageUrl", imageUrl);
        return mv;
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Image image = imageService.getImageById(id);

        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/png");
            return new ResponseEntity<>(image.getData(), headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/images/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {

        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/images/download/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        Image image = imageService.getImageById(id);

        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=image.png");
            headers.set(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
            return new ResponseEntity<>(image.getData(), headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
