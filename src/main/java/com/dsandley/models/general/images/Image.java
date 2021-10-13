package com.dsandley.models.general.images;

import com.dsandley.models.general.locations.Location;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import sun.rmi.runtime.Log;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String location;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "location_id", nullable = false)
    private Location locationObj;

    public  Image(){

    }

    public Image(int id, String location, Location locationObjParam) {
        this.id = id;
        this.location = location;
        this.locationObj = locationObjParam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Location getLocationObj() {
        return locationObj;
    }

    @JsonSetter
    public void setLocationObj(Location locationObj) {
        this.locationObj = locationObj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
