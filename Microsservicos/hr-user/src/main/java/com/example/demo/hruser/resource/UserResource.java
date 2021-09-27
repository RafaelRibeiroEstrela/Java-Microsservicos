package com.example.demo.hruser.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hruser.model.User;
import com.example.demo.hruser.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userRepository.findById(id).orElseThrow(() -> new RuntimeException()));
	}
	
	@GetMapping
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok().body(userRepository.findByEmail(email));
	}

}
