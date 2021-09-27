package com.example.demo.resource;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

	@Autowired
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG: " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok().body(workerRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		return ResponseEntity.ok().body(workerRepository.findById(id).orElseThrow(() -> new RuntimeException()));
	}
	
	

}
