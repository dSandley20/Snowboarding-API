package com.dsandley.models.general.locations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location_comments")
public class LocationComments {
   @Id
   @Column(name = "id")
    private int id;
   @Column(name = "location_id")
    private int locationId;
    private  String content;

    LocationComments(int id, int locationId, String content){
        this.id = id;
        this.locationId = locationId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
