package com.org.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.demo.model.Account;
import com.org.demo.model.Transaction;
import com.org.demo.model.User;
import com.org.demo.repositories.AccountRepository;
import com.org.demo.repositories.TransactionRepository;
import com.org.demo.repositories.UserRepository;

@Component
public class UserDAOService {
	
	@Autowired
	UserRepository urep;
	
	@Autowired
	AccountRepository arep;
	
	@Autowired
	TransactionRepository trep;
	
	public List<User> findAllUsers(){
		
		return urep.findAll();
	}
	
	public List<Account> findAllAccounts(){
		List<User> payeeList= urep.findAll();
		List<Account> a = arep.findAll();
		a.forEach(acc -> acc.setPayeeList(payeeList));
		System.out.println(a.get(0).getPayeeList());
		//return a;
		return arep.findAll();
	}
	
	public User save(User user){
		User u = urep.save(user);
		System.out.println("User obj :::"+user.toString());
		return u;
	}
	
	public Account saveUser(User user){
		List<User> allus = urep.findAll();
		
		User u = urep.save(user);
		Account acct = new Account();
		acct.setUserid(u.getId());
		acct.setCreateddate(new Date());
		Long acctn = (long) (Math.random()*100000000000L); 
		acct.setAccountnumber(acctn);
		acct.setPayeeList(allus);
		Account a = arep.save(acct);
		
		System.out.println(a.getId()+"........."+a.getUserid()+"......"+a.getAccountnumber()+"....."+a.getPayeeList());
		
		return a;
	}
	
	public User findOne(int id){
		List<User> users = urep.findAll();
		for(User user:users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}

	public List<Transaction> getTransactionHistory(Long id, String month) {
		// TODO Auto-generated method stub
		String sd = "2020-01-01 00:00:00";
		String ed = "2020-01-30 00:00:00";
		if(month.equals("Jan")) {
			sd = sd.replace(sd.charAt(5),'0');
			sd = sd.replace(sd.charAt(6),'1');
			
			ed = ed.replace(ed.charAt(5),'0');
			ed = ed.replace(ed.charAt(6),'1');
		}
		else if(month.equals("Mar")) {
			sd = sd.replace(sd.charAt(5),'0');
			sd = sd.replace(sd.charAt(6),'3');
			
			ed = ed.replace(ed.charAt(5),'0');
			ed = ed.replace(ed.charAt(6),'3');
		}
		System.out.println("SD : "+sd);
		System.out.println("ED : "+ed);
		List<Transaction> trans = trep.findTransList(id,id,sd,ed);
		
		return trans;
	}
	
}
