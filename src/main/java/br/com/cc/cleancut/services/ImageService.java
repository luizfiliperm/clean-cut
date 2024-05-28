package br.com.cc.cleancut.services;

import br.com.cc.cleancut.dtos.ExplorerDto;
import br.com.cc.cleancut.dtos.ImageDto;
import br.com.cc.cleancut.model.Image;
import br.com.cc.cleancut.model.User;
import br.com.cc.cleancut.repositories.ImageRepository;
import br.com.cc.cleancut.repositories.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageService {

    ImageRepository imageRepository;

    LikeRepository likeRepository;

    ImageProcessingService imageProcessingService;

    public ImageService(ImageRepository imageRepository, ImageProcessingService imageProcessingService, LikeRepository likeRepository) {
        this.imageRepository = imageRepository;
        this.imageProcessingService = imageProcessingService;
        this.likeRepository = likeRepository;
    }

    public void saveImage(Image image, User user) {
        image.setUser(user);
        imageRepository.save(removeBackground(image));
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public Image removeBackground(Image image){
        image = imageProcessingService.removeBackground(image);
        return image;
    }

    public List<Long> findAllUserImages(Long userId){
        return imageRepository.getAllIds(userId);
    }

    public Long countImagesByUserId(Long userId){
        return imageRepository.countImageByUserId(userId);
    }

    public Long countTotalLikes(Long userId){
        return imageRepository.countTotalLikes(userId);
    }

    public Long countTotalDownloads(Long userId){
        return imageRepository.countTotalDownloads(userId);
    }

    public ExplorerDto getExploreImages(Long userId){
        ExplorerDto explorerDto = new ExplorerDto();

        List<Long> imageIds = imageRepository.getExploreIds(userId);

        List<ImageDto> imageDtoList = imageIds.stream().map(id -> {
            Long likes = likeRepository.countLikesByImageId(id);

            String userName = imageRepository.findUserNameById(id);
            return new ImageDto(id, likes, userName);
        }).toList();

        explorerDto.setImageDtoList(imageDtoList);
        return explorerDto;
    }

    public void deleteImage(Long imageId) {
        imageRepository.deleteById(imageId);
    }
}
