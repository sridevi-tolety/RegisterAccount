package com.org.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.demo.model.Account;
import com.org.demo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction , Long>{
	
	@Query(value="select * from transaction where fromuserid=?1 or touserid=?2 and transdate between ?3 and ?4" ,nativeQuery=true)
	List<Transaction> findTransList(Long id1 , Long id2 , String startdate , String enddate);
	
	//List<Transaction> findTransList(Long id1 , Long id2 , String startdate , String enddate);

}
