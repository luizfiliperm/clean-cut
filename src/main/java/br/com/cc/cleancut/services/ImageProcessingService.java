package br.com.cc.cleancut.services;

import br.com.cc.cleancut.model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class ImageProcessingService {

    @Value("${api.removebg.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public ImageProcessingService() {
        this.restTemplate = new RestTemplate();
    }

    public Image removeBackground(Image inputImage) {
        try {

            Resource imageResource = new ByteArrayResource(inputImage.getData()) {
                @Override
                public String getFilename() {
                    return "image.png";
                }
            };


            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", imageResource);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // Send the request to the API
            ResponseEntity<byte[]> response = restTemplate.postForEntity(apiUrl, requestEntity, byte[].class);

            // Check the response status and update the image data if successful
            if (response.getStatusCode() == HttpStatus.OK) {
                byte[] responseData = response.getBody();
                if (responseData != null) {
                    inputImage.setData(responseData);
                }
            } else {
                throw new RuntimeException("Failed to remove background. API response code: " + response.getStatusCode());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while removing background", e);
        }

        return inputImage;
    }
}
