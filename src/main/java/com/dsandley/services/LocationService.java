package com.dsandley.services;

import java.util.List;

import javax.persistence.criteria.Predicate;

import com.dsandley.dto.general.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dsandley.models.general.Location;
import com.dsandley.repositories.LocationRepository;
import com.dsandley.services.interfaces.ILocationService;

@Service
@Component
public class LocationService implements ILocationService {

    /**
     * LocationRepository bean that utilizes CrudRepository.
     */
    @Autowired
    private LocationRepository repository;

    /**
     * builds the query for the supplied parameters.
     */
    @Override
    public List<Location> getLocations(final String name, final String country,
            final String state, final String city, final String zipcode) {
        // cq - critera query
        // cb -> critera builder
        List<Location> locations = repository
                .findAll((Specification<Location>) (root, cq, cb) -> {

                    Predicate p = cb.conjunction();
                    // add parameters to the query
                    // NOTE: can't use isEmpty anymore - deprecated as of 5.3
                    if (StringUtils.hasText(name)) {
                        System.out.println(!StringUtils.hasText(name));
                        String nameString = "%" + name + "%";
                        p = cb.and(p, cb.like(root.get("name"), nameString));
                    }
                    if (StringUtils.hasText(country)) {
                        String cntyString = "%" + country + "%";
                        p = cb.and(p, cb.like(root.get("country"), cntyString));
                    }
                    if (StringUtils.hasText(state)) {
                        String stateString = "%" + state + "%";
                        p = cb.and(p, cb.like(root.get("state"), stateString));
                    }
                    if (StringUtils.hasText(city)) {
                        String cityString = "%" + city + "%";
                        p = cb.and(p, cb.like(root.get("city"), cityString));
                    }
                    if (StringUtils.hasText(zipcode)) {
                        String zip = "%" + zipcode + "%";
                        p = cb.and(p, cb.like(root.get("zipcode"), zip));
                    }
                    // end of adding parameters to query
                    // sort the query
                    cq.orderBy(cb.desc(root.get("name")),
                            cb.asc(root.get("id")));
                    return p;
                });
        return   locations;
    }

    /**
     * returns all locations.
     */
    @Override
    public List<Location> findAll() {
        return (List<Location>) repository.findAll();
    }

    @Override
    public Location createLocations(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        location.setCountry(locationDTO.getCountry());
        location.setState(locationDTO.getState());
        location.setCity(locationDTO.getCity());
        location.setZipcode(locationDTO.getZipcode());
        return  repository.save(location);
    }

}
