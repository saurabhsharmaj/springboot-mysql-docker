package com.example.demo;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	
	@RestController
	class Rest{
		@Autowired
		UserRepository userRepository;
		
		@GetMapping({"","/"})
		public String sayHello() {
			return "Hello";
		}
		
		@GetMapping({"/all"})
		public List<User> users() {
			return userRepository.findAll();
		}
		
		@GetMapping({"/save"})
		public User saveUser() {
			return userRepository.save(new User(RandomStringUtils.random(10, true, true)));
		}
	}
}
