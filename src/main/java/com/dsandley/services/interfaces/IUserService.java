/**
 * outlines what kind of queries we want.
 */
package com.dsandley.services.interfaces;

import java.util.List;

import com.dsandley.models.general.User;

public interface IUserService {

    /**
     * returns all users.
     * @return List<User> - all users
     */
    List<User> findAll();
}
