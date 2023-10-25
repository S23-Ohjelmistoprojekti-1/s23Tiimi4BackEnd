package com.example.dogbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dogbackend.domain.Vaate;
import com.example.dogbackend.domain.VaateRepository;

@SpringBootApplication
public class DogbackendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DogbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DogbackendApplication.class, args);
	}
	
	public CommandLineRunner dogbackendDemo(VaateRepository repository) {
		return (args) -> {
			
		repository.save(new Vaate(0, "Takki", "Punainen", "S", 21.00, "Rukka"));
		
		
	};
		
	}
	
	}


