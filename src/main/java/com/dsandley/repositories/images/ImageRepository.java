package com.dsandley.repositories.images;

import com.dsandley.models.general.images.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Integer > , CrudRepository<Image, Integer > {

    public Image getImageById(int Id);

}
