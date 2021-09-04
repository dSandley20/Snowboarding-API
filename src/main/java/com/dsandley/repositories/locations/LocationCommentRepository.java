package com.dsandley.repositories.locations;

import com.dsandley.models.general.locations.LocationComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationCommentRepository extends JpaRepository<LocationComment, Integer> {

    LocationComment getCommentById(int commentId);
    public List<LocationComment> findAllByLocationId(int locationId) ;
}
