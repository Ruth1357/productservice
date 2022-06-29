package com.example.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.models.User;
import com.example.productservice.repo.UserRepo;

@RestController
public class mycontroller {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
public String getPage() {
	return "welcome";
}
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "saved.......";
	}

	@PutMapping("update/{id}")
	public String updateUser(@PathVariable long id,@RequestBody User user) {
		User updateUser=userRepo.findById(id).get();
		updateUser.setFirstname(user.getFirstname());
		updateUser.setLastname(user.getLastname());
		updateUser.setOccupation(user.getOccupation());
		updateUser.setAge(user.getAge());
		userRepo.save(updateUser);
		return "updated....";
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@RequestBody long id) {
		User deleteUser=userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "deleted user with the"+id;
	}
	
	
}
