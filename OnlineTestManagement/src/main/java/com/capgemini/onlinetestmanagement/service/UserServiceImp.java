package com.capgemini.onlinetestmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinetestmanagement.dao.UserDaoI;
import com.capgemini.onlinetestmanagement.entity.User;

@Service
@Transactional
public class UserServiceImp implements UserService{
 
	LocalDate datee;
	
	@Autowired
	private UserDaoI userDaoI;
	
	
	@Override
	public boolean addUser(User user) {
		userDaoI.save(user);
		return true;
	}

	@Override
	public boolean editUser(User user) {
		userDaoI.saveAndFlush(user);
		return true;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> user = userDaoI.findById(userId);
		if(user.isPresent())
		{
			User userobj = user.get();
			return userobj;
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user =userDaoI.findAll();
		return user;
	}

	@Override
	public void deleteTheatre(int userId) {
		userDaoI.deleteById(userId);
		
	}

	
	
}
