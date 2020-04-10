package com.org.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
