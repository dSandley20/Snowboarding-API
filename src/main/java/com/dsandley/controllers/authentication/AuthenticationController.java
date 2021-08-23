/**
 *Handles the loggin in of a user.
 */
package com.dsandley.controllers.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsandley.models.authentication.AuthenticationRequest;
import com.dsandley.models.authentication.AuthenticationResponse;
import com.dsandley.services.AuthUserDetailsService;
import com.dsandley.utils.JwtUtil;

/**
 * @author danie
 *
 */
@RestController
public class AuthenticationController {

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
     * Logs the user in and returns a string version of the token.
     * @param authenticationRequest - {username, password}
     * @return ResponseEntity
     * @throws Exception
     */
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody final AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
