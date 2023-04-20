package com.helloworld.ex4HelloWorld.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.ex4HelloWorld.models.User;
import com.helloworld.ex4HelloWorld.repo.UserRepo;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		System.out.println("Log: GET Http Request | Get all users | End Point: /");
		return userRepo.findAll();
	}
	
	@PostMapping("/user")
	public String createUser(@RequestBody User user) {
		System.out.println("Log: POST Http Request | Create new user | End Point: /user");
		userRepo.save(user);
		return "Save Success...";
	}
	
	@PutMapping("/user/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody User user) {
		System.out.println("Log: PUT Http Request | Update existing user | End Point: /user/{id}");
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setOccupation(user.getOccupation());
		updatedUser.setAge(user.getAge());
		userRepo.save(updatedUser);
		return "Update Success...";
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		System.out.println("Log: DELETE Http Request | Delete existing user | End Point: /user/{id}");
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Delete User by : " + id + " Success... ";
	}
}
