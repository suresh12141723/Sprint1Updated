package com.capgemini.onlinetestmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagement.entity.User;
import com.capgemini.onlinetestmanagement.exceptions.UserExceptions;
import com.capgemini.onlinetestmanagement.service.UserService;


@RestController
@RequestMapping("/onlineTestManagement")
public class Controller {
	
	@Autowired
	private UserService service;
	
	
	
	@PostMapping("/user")
	public ResponseEntity<Boolean> addUser(@RequestBody User user) throws UserExceptions{
		boolean status = service.addUser(user);
		if(status == true)
		{
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		  throw new UserExceptions("Unable to Create the User ");
		
	}
	
	
	
	@GetMapping("/view/{userId}")
	public ResponseEntity<User>getUserById(@PathVariable("userId") int userId) throws UserExceptions{
		User status = service.getUserById(userId);
		if(status!=null)
		{
			return new ResponseEntity<User>(status,HttpStatus.OK);
		}
		else
		{
			throw new UserExceptions(userId+"Unable to find the User! Please try again");
		}
	}
	
	@GetMapping("/getuser")
    public ResponseEntity<List<User>> getuserlist() throws UserExceptions{
			List<User> list = service.getAllUsers();
					
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) throws UserExceptions
	{
		service.deleteTheatre(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	
	
	
	
	
	
	}
