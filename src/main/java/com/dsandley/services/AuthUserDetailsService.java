package com.dsandley.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    //TODO make it so we can look up username/email and password + hash
    /**
     * loads the user by username and password.
     * @param username - the username of the account trying to be logged in
     */
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        System.out.println(username);
        return new User("foo", "foo", new ArrayList<>());
    }

}
