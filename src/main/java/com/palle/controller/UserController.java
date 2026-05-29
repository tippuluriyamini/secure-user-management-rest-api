package com.palle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palle.dto.UserDto;
import com.palle.entity.User;
import com.palle.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/myapp2")
public class UserController {

	@Autowired
	private UserService service;
	
	//1.REST API to insert
	@PostMapping("/insert")
	public User insert(@RequestBody @Valid UserDto u) {
		return service.insert(u);
	}
	
	// 2. REST API TO read all
	@GetMapping("/readall")
	public List<User> readall(){
		return service.readAll();
	}
	
	//3. REST API to read one
	@GetMapping("/readone/{id}")
	public Optional<User> readOne(@PathVariable int  id) {
	   Optional<User> optional = service.readOne(id);
	   return optional;
	}
	
	//4.REST API to update
	@PutMapping("/update/{id}")
	public User updateData(@PathVariable int id,@RequestBody User newuser) {
		return service.update(id, newuser);
	}
	
	// 5 REST API to delete
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
	

}
