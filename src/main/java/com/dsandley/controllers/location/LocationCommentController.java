package com.dsandley.controllers.location;

import com.dsandley.dto.general.locations.LocationCommentDTO;
import com.dsandley.models.general.locations.LocationComment;
import com.dsandley.services.locations.LocationCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationCommentController {
    @Autowired
    private LocationCommentService service;

    @GetMapping("/comments/location/{locationId}")
    public List<LocationComment> getByLocation(@PathVariable int locationId){
        return service.findAllByLocationId(locationId);
    }

    @GetMapping("/comments/{id}")
    public LocationComment getById(@PathVariable int id){
        return  service.getCommentById(id);
    }

    @PostMapping("/comments")
    public LocationComment createComment(@RequestBody LocationCommentDTO commentDTO){
        return  service.createLocationComment(commentDTO);
    }
}
