package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.feignclients.WorkerFeignClient;
import com.example.demo.model.Payment;
import com.example.demo.model.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, Integer daysWorked) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
	}

}
