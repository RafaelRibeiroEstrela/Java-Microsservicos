package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping
	public ResponseEntity<Payment> getPayment(@RequestParam Long workerId, @RequestParam Integer daysWorked){
		return ResponseEntity.ok().body(paymentService.getPayment(workerId, daysWorked));
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer daysWorked){
		Payment payment = new Payment("Brann", 400.0, daysWorked);
		return ResponseEntity.ok().body(payment);
	}
	
	
}
