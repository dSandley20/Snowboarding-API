/**
 * our own custom userDeatilsService.
 */
package com.dsandley.services.authentication;

import com.dsandley.models.authentication.AuthUserDetails;
import com.dsandley.models.general.users.User;
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

    /**
     * loads the user by username and password.
     * @param userName - the username of the account trying to be logged in
     */
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(AuthUserDetails::new).get();
    }
}
