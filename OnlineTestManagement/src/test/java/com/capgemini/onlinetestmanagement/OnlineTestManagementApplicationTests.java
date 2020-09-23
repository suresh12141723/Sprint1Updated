package com.capgemini.onlinetestmanagement;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.onlinetestmanagement.dao.UserDaoI;
import com.capgemini.onlinetestmanagement.entity.User;
import com.capgemini.onlinetestmanagement.service.UserServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineTestManagementApplicationTests {

	@Autowired
	private UserDaoI userDao;
	
//	@Autowired
//	private ExamDaoI examDaoI;
//	
//	@Autowired
//	private UserDaoI userDaoI;
	
	@Autowired
	private UserServiceImp userServiceImpl;

	
	@Test
	void contextLoads() {
		
	}
	
	
	//@Test
	@DisplayName("Testing the User by UniqueId :Valid Credits")
	void getUserByIdValidCreditsTest() {
		User userObjTest = new User(1,"vijay","passs","user");
		User userObj = userServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj.getRole());
		assertEquals("user",userObj.getRole());
	}

	@Test
	@DisplayName("Testing the User by UniqueId :InValid Credits")
	void getUserByIdInValidCreditsTest() {
		User userObjTest = new User(55,"vijay","passs","user");
		User userObj = userServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj);
		assertEquals(null,userObj);
	}
	
	@Test
	@DisplayName("Testing the List<User> if List is notEmpty")
	void getAllUsersForNonEmptyListTest() {
		List<User> userList = userServiceImpl.getAllUsers();
		System.out.println("The UserList Size is :"+userList.size());
		int excpectedSize  = 3;
		assertEquals(excpectedSize,userList.size());
	}
	
	
	@Test
	@DisplayName("Testing the List<User if the List is Empty")
	void getAllUsersForEmptyListTest() {
		List<User> userList = userServiceImpl.getAllUsers();
		System.out.println("The UserList Size is :"+userList.size());
		int excepectedSize =0;
		if(userList.size() !=0) 
		{
			excepectedSize = 3;
			assertEquals(excepectedSize,userList.size());
		}
		else
		{
			System.out.println("UserList size is Zero: 0");
			assertEquals(excepectedSize,userList.size());
		}
	}
	
	
}
