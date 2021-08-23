/**
 * our own custom userDeatilsService.
 */
package com.dsandley.services;

import com.dsandley.models.authentication.AuthUserDetails;
import com.dsandley.models.general.User;
import com.dsandley.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    //TODO make it so we can look up username/email and password + hash
    /**
     * loads the user by username and password.
     * @param userName - the username of the account trying to be logged in
     */
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
       User user = userRepository.getUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new AuthUserDetails(user);
    }

}
