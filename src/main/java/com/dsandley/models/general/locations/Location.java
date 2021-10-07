package com.dsandley.models.general.locations;

import com.dsandley.models.general.images.Image;

import javax.persistence.*;
import java.util.List;

/**
 * @author Daniel. holds data such as id, name, country, state, city, and
 *         zipcode
 */
@Entity
@Table(name = "locations")
public class Location {

    /**
     * id field that is serialized / auto generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;
    private String country;
    private String state;
    private String city;
    @Column(nullable = true)
    private String zipcode;
   

    public Location() {
    }

    /**
     * autogenerated constructor for the location class.
     * @param idParam
     * @param nameParam
     * @param countryParam
     * @param stateParam
     * @param cityParam
     * @param zipcodeParam
     */
    public Location(final int idParam, final String nameParam,
            final String countryParam, final String stateParam,
            final String cityParam, final String zipcodeParam) {
        super();
        this.id = idParam;
        this.name = nameParam;
        this.country = countryParam;
        this.state = stateParam;
        this.city = cityParam;
        this.zipcode = zipcodeParam;
    }

    /**
     * returns back the id of the location.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returns back the name of the location.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the new name of the location.
     * @param nameParam
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * gets the country that the location is in.
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * set the new country of the location.
     * @param countryParam
     */
    public void setCountry(final String countryParam) {
        this.country = countryParam;
    }

    /**
     * returns the state of the location (if applicable).
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * set the state of the location.
     * @param stateParam
     */
    public void setState(final String stateParam) {
        this.state = stateParam;
    }

    /**
     * returns the city of the location.
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * set the new city of the location.
     * @param cityParam
     */
    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    /**
     * gets the zipcode of the location.
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * set the new zipcode of the location.
     * @param zipcodeParam
     */
    public void setZipcode(final String zipcodeParam) {
        this.zipcode = zipcodeParam;
    }

}
