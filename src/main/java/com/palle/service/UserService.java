package com.palle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palle.dto.UserDto;
import com.palle.entity.User;
import com.palle.repository.UserRepository;

@Service
public class UserService {
	//service repository dependency
	@Autowired
	private UserRepository repository;
	// 1 . Insert data
	public User insert(UserDto userdto) {
		User user = User.build(0, userdto.getName(), userdto.getEmail(), userdto.getMobile_no(), userdto.getAge(), userdto.getNational());
		return repository.save(user);
			
	}
	// 2 .read all data
	public List<User> readAll(){
		return repository.findAll();
	}
	//3. read one data 
	public Optional<User> readOne(int id) {
		Optional<User> byId = repository.findById(id);
		return byId;
	}
	//4 . update user data
	public User update(int id, User newuser) {
		
		Optional<User> byId = repository.findById(id);
		User existinguser=null;
		if(byId.isPresent()) {
			existinguser=byId.get();
			existinguser.setName(newuser.getName());
			existinguser.setEmail(newuser.getEmail());
			existinguser.setMobile_no(newuser.getMobile_no());
			existinguser.setAge(newuser.getAge());
			existinguser.setNational(newuser.getNational());
			repository.save(existinguser);
		}
		
		return existinguser;
		
	}
	public String delete(int id) {
		Optional<User> optional = repository.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			repository.delete(user);
			return "user data with id"+id+" is deleted.";
		}
		return "user data with id"+id+" is not existed.";

	}
	
	

}
