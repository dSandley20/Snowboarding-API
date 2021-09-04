package com.dsandley.services.interfaces.images;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;

public interface IImageService {

    public Image getImageById(int Id);

    public Image createImage(ImageDTO image);

}
