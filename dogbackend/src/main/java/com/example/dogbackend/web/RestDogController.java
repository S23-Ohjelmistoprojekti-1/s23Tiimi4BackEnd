package com.example.dogbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@CrossOrigin(origins = "http://localhost:5174")
	
	// Rest kaikki vaatteet http://localhost:8080/vaatteet
    @RequestMapping(value="/vaatteet", method = RequestMethod.GET)
    public @ResponseBody List<Vaate> vaateListRest() {	
        return (List<Vaate>) repository.findAll();
    }  
    
	// Rest kaikki vaatteet id:llä http://localhost:8080/vaate/1
    @RequestMapping(value="/vaate/{tyyppi}", method = RequestMethod.GET)
    public @ResponseBody List<Vaate> findByTyyppi(@PathVariable("tyyppi") String tyyppiId) {	
    	return repository.findByTyyppi(tyyppiId);
    }  
}