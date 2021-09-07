package com.dsandley.services.interfaces.locations;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;

public interface IImageService {

//    public Image getImageById(int id);

    public Image createImage(ImageDTO image);

}
