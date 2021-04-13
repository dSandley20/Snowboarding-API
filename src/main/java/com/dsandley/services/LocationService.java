package com.dsandley.services;

import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dsandley.models.Location;
import com.dsandley.repositories.LocationRepository;
import com.dsandley.services.interfaces.ILocationService;

@Service
@Component
public class LocationService implements ILocationService {

	@Autowired
	private LocationRepository repository;

	@Override
	public List<Location> findAll(String name, String country, String state, String city, int zipcode) {
		// cq - critera query
		// cb -> critera builder
		List<Location> locations = repository.findAll((Specification<Location>)(root, cq, cb) -> {
			Predicate p = cb.conjunction();
			//add parameters to the query
			//NOTE: can't use isEmpty anymore as it is deprecated as of 5.3
			if(!StringUtils.hasText(name)) {
				p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
			}
			if(!StringUtils.hasText(country)) {
				p = cb.and(p, cb.like(root.get("country"), "%" + country + "%"));
			}
			if(!StringUtils.hasText(state)) {
				p = cb.and(p, cb.like(root.get("state"), "%" + state + "%"));
			}
			if(!StringUtils.hasText(city)) {
				p = cb.and(p, cb.like(root.get("city"), "%" + city  + "%"));
			}
			//TODO: add toString method  
			if(!StringUtils.hasText(""+zipcode+"")) {
				p = cb.and(p, cb.like(root.get("zipcode"), "%" + zipcode  + "%"));
			}
			//end of adding parameters to query
			//sort the query
			 cq.orderBy(cb.desc(root.get("name")), cb.asc(root.get("id")));
			return p;
		});
		return locations;
	}

}
	
	