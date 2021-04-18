/**
 * handles the users endpoints
 */
package com.dsandley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsandley.models.User;
import com.dsandley.services.UserService;

@RestController
public class UserController {

    /**
     * autowires to the service UserService bean.
     */
    @Autowired
    private UserService service;

    /**
     * returns back all the users in the DB.
     * @return List<User>
     */
    @GetMapping("/users")
    public List<User> findUsers() {
        return service.findAll();
    }

}
