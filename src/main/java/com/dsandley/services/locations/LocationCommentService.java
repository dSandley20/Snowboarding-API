package com.dsandley.services.locations;

import com.dsandley.dto.general.locations.LocationCommentDTO;
import com.dsandley.models.general.locations.LocationComment;
import com.dsandley.repositories.locations.LocationCommentRepository;
import com.dsandley.services.interfaces.locations.ILocationCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class LocationCommentService implements ILocationCommentService {

    @Autowired
    private LocationCommentRepository repository;

    @Override
    public List<LocationComment> findAllByLocationId(int locationId) {
       return repository.findAllByLocationId(locationId);
    }

    @Override
    public LocationComment getCommentById(int commentId) {
        return repository.getCommentById(commentId);
    }

    @Override
    public LocationComment createLocationComment( LocationCommentDTO locationComment) {
        LocationComment comment = new LocationComment();
        comment.setLocationId(locationComment.getLocationId());
        comment.setContent(locationComment.getContent());
        return repository.save(comment);
    }
}
