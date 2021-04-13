package com.dsandley.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsandley.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>, JpaSpecificationExecutor<Location> {

}
