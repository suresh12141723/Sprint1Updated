package com.capgemini.onlinetestmanagement.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetestmanagement.entity.User;

public interface UserService {
	
	    //User details.......
		public boolean addUser(User user);
		public boolean editUser(User user);
		public User getUserById(int userId);
		public List<User> getAllUsers();
		public void deleteTheatre(int userId);
		
		
		

}
