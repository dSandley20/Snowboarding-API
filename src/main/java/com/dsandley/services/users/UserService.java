package com.dsandley.services.users;

import java.util.List;

import com.dsandley.dto.general.users.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dsandley.models.general.users.User;
import com.dsandley.repositories.UserRepository;
import com.dsandley.services.interfaces.users.IUserService;

@Service
@Component
public class UserService implements IUserService {

    /**
     * autowired repository.
     */
    @Autowired
    private UserRepository repository;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @return UserList : Array - A list of all the users located in the
     *         database
     */
    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    //TODO throw email exists eception
    @Override
    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getUserName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return repository.save(user);
    }

}
