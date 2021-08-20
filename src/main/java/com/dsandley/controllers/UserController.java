/**
 * handles the users endpoints
 */
package com.dsandley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsandley.models.general.User;
import com.dsandley.services.UserService;

@RestController
public class UserController {

    /**
     * autowires to the service UserService bean.
     */
    @Autowired
    private UserService service;

    /**
     * Creates a new user to login with
     * @return
     */
    @PostMapping("/user")
    public String home(){
        return "Hello World!";
    }

    /**
     * Returns a user by ID
     */
    @GetMapping("/user/:id")
    public User getUser(){
        return null;
    }


    /**
     * returns back all the users in the DB.
     * @return List<User>
     */

    @GetMapping("/users")
    public List<User> findUsers() {
        return service.findAll();
    }

}
