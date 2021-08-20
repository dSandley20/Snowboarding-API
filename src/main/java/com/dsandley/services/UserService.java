package com.dsandley.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dsandley.models.general.User;
import com.dsandley.repositories.UserRepository;
import com.dsandley.services.interfaces.IUserService;

@Service
@Component
public class UserService implements IUserService {

    /**
     * autowired repository.
     */
    @Autowired
    private UserRepository repository;

    /**
     * @return UserList : Array - A list of all the users located in the
     *         database
     */
    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

}
