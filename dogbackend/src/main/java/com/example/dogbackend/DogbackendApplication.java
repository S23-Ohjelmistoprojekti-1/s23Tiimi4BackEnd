package com.example.dogbackend;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dogbackend.domain.Vaate;
import com.example.dogbackend.domain.VaateRepository;
import com.example.dogbackend.domain.Valmistaja;
import com.example.dogbackend.domain.ValmistajaRepository;

@SpringBootApplication
public class DogbackendApplication {
	
//	private static final Logger log = LoggerFactory.getLogger(DogbackendApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(DogbackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dogbackendDemo(VaateRepository repository, ValmistajaRepository vrepository) {
		return (args) -> {
			
			vrepository.save(new Valmistaja("Rukka"));
			
		Vaate v1 = new Vaate("Takki", "Punainen", "S", 21.5, vrepository.findByNimi("Rukka").get(0));
		
		repository.save(v1);
	};
		
	}
	
	}


