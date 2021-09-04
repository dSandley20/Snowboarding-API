package com.dsandley.services.images;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;
import com.dsandley.repositories.images.ImageRepository;
import com.dsandley.services.interfaces.images.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ImageService implements IImageService {

    @Autowired
    private ImageRepository repository;


    @Override
    public Image getImageById(int Id) {
        return  repository.getImageById(Id);
    }

    @Override
    public Image createImage(ImageDTO image) {
        Image newImage  = new Image();
        newImage.setLocationId(image.getLocationId());
        newImage.setLocation(image.getLocation());
        return repository.save(newImage);
    }
}
