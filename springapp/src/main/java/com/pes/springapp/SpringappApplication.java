package com.pes.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}
	@GetMapping("/")
	public String Hello() {
		return String.format("helllo");
	}
	
	@GetMapping("/demoapp")
	public String DemoApp(@RequestParam(value = "name",defaultValue = "world")String name) {
		return String.format("welcome "+name);
		
	}
}
