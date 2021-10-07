package com.dsandley.controllers.images;

import com.dsandley.dto.general.images.ImageDTO;
import com.dsandley.models.general.images.Image;
import com.dsandley.services.users.ImageService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.jgit.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.sql.Timestamp;

@RestController
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping(value = "/images/{id}", produces ={MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public @ResponseBody byte[] getImage(@PathVariable int id) throws IOException {
        Image image =  service.getImageById(id);
        //IOUtils coudn't find the files so we are using Java's file system
        File tempFile = new File(image.getLocation());
        return FileUtils.readFileToByteArray(tempFile);
    }

    //TODO maybe revamp the DTO saving object -> include id of location + add timestamp
    @PostMapping("/images")
    public Image saveImage(@RequestBody ImageDTO image) {
        saveImageData(image);
        return service.createImage(image);
    }

    public void saveImageData (ImageDTO image) {
        //postitions 0 + 1 = fileType
        //postition 2 = fileData
        int [] postionArray = { image.getFileData().indexOf("/") + 1 , image.getFileData().indexOf(";") ,  image.getFileData().indexOf(",") + 1};
        //skips over the file type
        final String imageData = image.getFileData().substring(postionArray[2]);
        final String fileType = image.getFileData().substring(postionArray[0], postionArray[1]);
        final String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        final String imageDir  = "/Users/danielsandley/workspace/personal-projects/Snowboarding-API/src/main/resources/Images/";
        final String imageLocation = imageDir + "locationImage-" + timestamp + "." + fileType;
        byte[] decodedImageData = Base64.decode(imageData);
        //locationImage + locationId + timestamp + fileType
        try (OutputStream stream = new FileOutputStream(imageLocation)) {
            stream.write(decodedImageData);
            image.setLocation((imageLocation));
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
