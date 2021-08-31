package com.dsandley.dto.general.locations;

public class LocationCommentDTO {
    private int locationId;
    private String content;

    public LocationCommentDTO(int locationId, String content){
        this.locationId = locationId;
        this.content = content;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
