/**
 * contains all the repos.
 */
package com.dsandley.repositories;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsandley.models.general.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userName LIKE :username")
    public User getUserByUsername(@Param("username") String username);
}
