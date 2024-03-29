package com.dsandley.services.interfaces.locations;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;
import com.dsandley.models.general.locations.Location;

public interface IImageService {

    public Image getImageById(int id);

    public Image createImage(ImageDTO image);

}
