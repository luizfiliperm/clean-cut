package br.com.cc.cleancut.services;

import br.com.cc.cleancut.model.Image;
import br.com.cc.cleancut.repositories.ImageRepository;
import org.springframework.stereotype.Service;


@Service
public class ImageService {

    ImageRepository imageRepository;

    ImageProcessingService imageProcessingService;

    public ImageService(ImageRepository imageRepository, ImageProcessingService imageProcessingService) {
        this.imageRepository = imageRepository;
        this.imageProcessingService = imageProcessingService;
    }

    public void saveImage(Image image) {
        imageRepository.save(removeBackground(image));
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public Image removeBackground(Image image){
        image = imageProcessingService.removeBackground(image);
        return image;
    }
}
