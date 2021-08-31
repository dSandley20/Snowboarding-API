package com.dsandley.services.interfaces.locations;

import com.dsandley.models.general.locations.LocationComment;

import java.util.List;

public interface ILocationCommentService {
   List<LocationComment> findAllByLocation(int locationId);
   LocationComment getCommentById(int commentId);
}
