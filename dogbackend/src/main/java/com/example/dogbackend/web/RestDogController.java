package com.example.dogbackend.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.dogbackend.domain.Asiakas;
import com.example.dogbackend.domain.AsiakasRepository;
import com.example.dogbackend.domain.Vaate;
import com.example.dogbackend.domain.VaateRepository;
import com.example.dogbackend.domain.Valmistaja;
import com.example.dogbackend.domain.ValmistajaRepository;

@Controller
public class RestDogController {
	
	@Autowired
	private VaateRepository repository;
	@Autowired
	private ValmistajaRepository vrepository;
	@Autowired
	private AsiakasRepository drepository;
	
	@Configuration
	public class CorsConfig {

	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("http://localhost:5173"); // Add your frontend origin here
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("OPTIONS");
	        config.addAllowedMethod("GET");
	        config.addAllowedMethod("POST");
	        config.addAllowedMethod("PUT");
	        config.addAllowedMethod("DELETE");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	}
	
	@RequestMapping(value="/vaatteet", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> vaateListRest() {    
	    List<Vaate> vaatteet = (List<Vaate>) repository.findAll();
	    List<Map<String, Object>> result = new ArrayList<>();

	    for (Vaate vaate : vaatteet) {
	        Map<String, Object> vaateMap = new LinkedHashMap<>();

	        vaateMap.put("id", vaate.getId());
	        vaateMap.put("tyyppi", vaate.getTyyppi());
	        vaateMap.put("vari", vaate.getVari());
	        vaateMap.put("koko", vaate.getKoko());
	        vaateMap.put("hinta", vaate.getHinta());
	        vaateMap.put("valmistaja", vaate.getValmistaja().getNimi());

	        result.add(vaateMap);
	    }

	    return result;
	}

	
	@RequestMapping(value="/valmistajat", method = RequestMethod.GET)
	public @ResponseBody List<Valmistaja> valmistajaListRest() {	
	    return (List<Valmistaja>) vrepository.findAll();
	}
    
	// Rest kaikki vaatteet id:llä http://localhost:8080/vaate/nimi
    //@RequestMapping(value="/vaate/{nimi}", method = RequestMethod.GET)
    //public @ResponseBody List<Vaate> findByVaate(@PathVariable("vaate") String VaateId) {
   // 	return repository.findByVaate(VaateId);
   // } 
    
	@RequestMapping(value="/asiakkaat", method = RequestMethod.GET)
	public @ResponseBody List<Asiakas> asiakasListRest() {	
	    return (List<Asiakas>) drepository.findAll();
	}
    
	@PostMapping("/asiakkaat")
	public ResponseEntity<?> addAsiakas(@RequestBody Asiakas asiakas) {
	    try {
	        Asiakas savedAsiakas = drepository.save(asiakas);
	        return ResponseEntity.ok(savedAsiakas);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Asiakas to the database");
	    }
	}
    
}