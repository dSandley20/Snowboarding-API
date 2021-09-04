package com.dsandley.dto.general.images;

public class ImageDTO {


    private String fileData;
    private int locationId;
    private  String location;

    public ImageDTO(String fileData, int locationId, String location) {
        this.fileData = fileData;
        this.locationId = locationId;
        this.location = location;
    }

    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
