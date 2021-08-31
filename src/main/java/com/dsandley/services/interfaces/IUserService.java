/**
 * outlines what kind of queries we want.
 */
package com.dsandley.services.interfaces;

import java.util.List;

import com.dsandley.dto.general.users.UserDTO;
import com.dsandley.models.general.users.User;

public interface IUserService {

    /**
     * returns all users.
     * @return List<User> - all users
     */
    List<User> findAll();

    /**
     * Create
     */
    User createUser(UserDTO userDTO);
}
