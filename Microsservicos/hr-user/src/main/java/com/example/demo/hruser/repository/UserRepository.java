package com.example.demo.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hruser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);

}
