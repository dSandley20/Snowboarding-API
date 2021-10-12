/**
 * contains all the repos and their interfaces.
 */
package com.dsandley.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsandley.models.general.locations.Location;

import java.util.List;

@Repository
public interface LocationRepository
        extends
            CrudRepository<Location, Integer>,
            JpaRepository<Location, Integer>,
            JpaSpecificationExecutor<Location> {



}
