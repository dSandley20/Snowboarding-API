package com.dsandley.services.interfaces.locations;

import com.dsandley.dto.general.locations.LocationCommentDTO;
import com.dsandley.models.general.locations.LocationComment;

import java.util.List;

public interface ILocationCommentService {

   public List<LocationComment> findAllByLocationId(int locationId) ;


   public LocationComment getCommentById(int commentId);

   public LocationComment createLocationComment(LocationCommentDTO locationComment);
}
