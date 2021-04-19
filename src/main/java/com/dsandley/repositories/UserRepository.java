/**
 * contains all the repos.
 */
package com.dsandley.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsandley.models.general.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
