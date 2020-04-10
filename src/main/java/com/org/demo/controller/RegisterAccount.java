package com.org.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.org.demo.model.Account;
import com.org.demo.model.Transaction;
import com.org.demo.model.User;
import com.org.demo.repositories.UserRepository;
import com.org.demo.service.UserDAOService;

@RestController
public class RegisterAccount {
	
	@Autowired
	UserDAOService service;
	
	@Autowired
	UserRepository repo;
	
	@GetMapping("/jpa/getAllAccounts")
	public List<Account> getAllAccounts(){
		
		return service.findAllAccounts();		
	}
	
	@GetMapping("/jpa/users")
	public List<User> getJpaAllUsers(){
		
		return service.findAllUsers();
		
	}
	
	@GetMapping("/jpa/userById/{id}")
	public Optional<User> getJpaUserById(@PathVariable int id){
		Optional<User> user =  repo.findById(id);
		return user;
		
	}
	
	@GetMapping("/jpa/deleteById/{id}")
	public void deleteJpaUserById(@PathVariable int id){		
		repo.deleteById(id);		
	}
	
	@PostMapping("/jpa/insertUser")
	public ResponseEntity<Object> insertUser(@RequestBody User user){
		User savedUser = repo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}")
	public User getIdUsers(@PathVariable int id){
		
		return service.findOne(id);
		
	}
	@PostMapping("/jpa/saveuser")
	public void createUser(@RequestBody User user) {
		service.save(user);
	}
	
	@PostMapping("/jpa/saveAccount")
	public void saveUser(@RequestBody User user) {
		service.saveUser(user);
	}	
	
	@GetMapping("/jpa/transactionhistory/{id}/{month}")
	public List<Transaction> getTransactionHistory(@PathVariable Long id, @PathVariable String month){
		
		return service.getTransactionHistory(id, month);
		
	}

}
