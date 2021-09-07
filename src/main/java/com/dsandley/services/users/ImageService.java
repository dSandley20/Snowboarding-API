package com.dsandley.services.users;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;
import com.dsandley.repositories.ImageRepository;
import com.dsandley.services.interfaces.locations.IImageService;
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
        System.out.println(repository.getImageById(Id).getId());
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
