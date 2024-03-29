package com.dsandley.controllers.location;

import java.util.List;

import com.dsandley.dto.general.locations.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dsandley.models.general.locations.Location;
import com.dsandley.services.locations.LocationService;

@RestController
public class LocationController {

    /**
     * Autowire instantiate a bean.
     */
    @Autowired
    private LocationService service;

    /**
     * A list of locations endpoint that uses qb to have a dynamic query.
     * @param name
     * @param country
     * @param state
     * @param city
     * @param zipcode
     * @return List<Location> - all the locations that meet the desired query
     */
    @GetMapping("/locations")
    public List<Location> findLocations(
            @RequestParam(required = false) final String name,
            @RequestParam(required = false) final String country,
            @RequestParam(required = false) final String state,
            @RequestParam(required = false) final String city,
            @RequestParam(required = false) final String zipcode) {
        return service.getLocations(name, country, state, city, zipcode);
    }

    /**
     *Returns all locations.
     *@return List<Location> - all the locations
     */
    @GetMapping("/locations/all")
    public List<Location> findLocations() {
        return service.findAll();
    }

    @PostMapping("/location")
    private Location createLocation(@RequestBody LocationDTO locationDTO){
       return service.createLocations(locationDTO);
    }
}
