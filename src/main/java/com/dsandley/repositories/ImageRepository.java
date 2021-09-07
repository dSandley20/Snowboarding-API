package com.dsandley.repositories;

import com.dsandley.models.general.images.Image;
import com.dsandley.models.general.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Integer > {

    public Image getImageById(int Id);

}
