package com.dsandley.controllers.images;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;
import com.dsandley.services.images.ImageService;
import org.eclipse.jgit.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;

@RestController
public class ImageController {

    @Autowired
    ImageService service;


    //TODO convert image
    @GetMapping("/images/{id}")
    public  Image getImage(@RequestParam int id){
        return  service.getImageById(id);
    }

    //TODO maybe revamp the DTO saving object -> include id of location + add timestamp
    @PostMapping("/images")
    public Image saveImage(@RequestBody ImageDTO image){

        //skips over the file type
        String imageData = image.getFileData().substring(image.getFileData().indexOf(",") + 1);
        String fileType = image.getFileData().substring(image.getFileData().indexOf("/"),image.getFileData().indexOf(""));
        String timestamp =  new Timestamp(System.currentTimeMillis()).toString();
        String imageLocation = "c:/images/locationImage-" + timestamp + "." + fileType;
        byte[] decodedImageData = Base64.decode(imageData);
        //locationImage + locationId + timestamp + fileType
        try(OutputStream stream = new FileOutputStream(imageLocation)){
            stream.write(decodedImageData);
            image.setLocation((imageLocation));
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        //TODO create new response entity
        return service.createImage(image);
    }
}
