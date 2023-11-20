package com.example.dogbackend;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dogbackend.domain.Asiakas;
import com.example.dogbackend.domain.AsiakasRepository;
import com.example.dogbackend.domain.Kayttaja;
import com.example.dogbackend.domain.KayttajaRepository;
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
	public CommandLineRunner dogbackendDemo(VaateRepository repository, ValmistajaRepository vrepository, AsiakasRepository drepository, KayttajaRepository krepository) {
		return (args) -> {
			
			vrepository.save(new Valmistaja("Rukka"));
			vrepository.save(new Valmistaja("Pomppa"));
			vrepository.save(new Valmistaja("Trixie"));
			vrepository.save(new Valmistaja("Dogman"));
			vrepository.save(new Valmistaja("Hurtta"));
			vrepository.save(new Valmistaja("Feel Active"));
			
			
		Vaate v1 = new Vaate("Takki", "Punainen", "S", 21.5, vrepository.findByNimi("Rukka").get(0));
		Vaate v2 = new Vaate("Liivi", "Sininen", "M", 15.50, vrepository.findByNimi("Hurtta").get(0));

		Asiakas a1 = new Asiakas("Matti", "Meikäläinen", "Matinkuja 3", "00100", "Helsinki", "020123456", "matti.meika@gmail.com"); 
		
		//käyttäjänimi on admin, salasana on "salasana"
		Kayttaja k1 = new Kayttaja("admin", "$2a$12$uv0pjvLc.L/mr.nisKDOO.AavxHOR7dWz1AjydS2Eya83Ivryc1ce", "ADMIN");
		
		repository.save(v1);
		drepository.save(a1);

		repository.save(v2);
		
		krepository.save(k1);
	};
		
	}
	
}


