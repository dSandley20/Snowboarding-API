package com.dsandley.services.interfaces;

import com.dsandley.models.User;
import java.util.List;

public interface IUserService {

    /**
     * returns all users.
     * @return List<User> - all users
     */
    List<User> findAll();
}
