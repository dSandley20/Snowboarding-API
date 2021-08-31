/**
 * handles the users endpoints
 */
package com.dsandley.controllers;

import java.util.List;

import com.dsandley.dto.general.users.UserDTO;
import com.dsandley.models.authentication.AuthenticationResponse;
import com.dsandley.services.authentication.AuthUserDetailsService;
import com.dsandley.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.dsandley.models.general.users.User;
import com.dsandley.services.users.UserService;

@RestController
public class UserController {

    /**
     * autowires to the service UserService bean.
     */
    @Autowired
    private UserService service;
    /**
     * Allows us to actually authenticate our user/data.
     */
    @Autowired
    private AuthenticationManager authManager;

    /**
     * Allows us to create the token itself.
     */
    @Autowired
    private AuthUserDetailsService userDetailsService;

    /**
     * Allows us to use the util functions to create our token.
     */
    @Autowired
    private JwtUtil jwtTokenUtil;

    /**
     * Creates a new user to login with
     * @return
     */
    @PostMapping("/user")
    private ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws  Exception{
        service.createUser(userDTO);
        //return userObj back to user w/ JWT.
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userDTO.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    /**
     * Returns a user by ID
     */
    @GetMapping("/user/{id}")
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
