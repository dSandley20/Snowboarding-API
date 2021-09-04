package com.dsandley.models.general.images;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int Id;
    private String location;
    private int locationId;

    public  Image(){

    }

    public Image(int id, String location, int locationId) {
        this.Id = id;
        this.location = location;
        this.locationId = locationId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
