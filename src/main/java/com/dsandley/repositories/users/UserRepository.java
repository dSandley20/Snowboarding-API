/**
 * contains all the repos.
 */
package com.dsandley.repositories.users;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsandley.models.general.users.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
