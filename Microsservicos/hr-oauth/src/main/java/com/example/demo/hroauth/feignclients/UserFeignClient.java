package com.example.demo.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.hroauth.model.User;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {
	
	@GetMapping
	public ResponseEntity<User> findByEmail(@RequestParam String email);

}
