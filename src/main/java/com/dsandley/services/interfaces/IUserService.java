package com.dsandley.services.interfaces;

import com.dsandley.models.User;
import java.util.List;

public interface IUserService {
	
	List<User> findAll();
}
