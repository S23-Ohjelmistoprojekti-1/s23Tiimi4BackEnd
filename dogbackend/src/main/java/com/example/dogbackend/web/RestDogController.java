package com.example.dogbackend.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@CrossOrigin(origins = "http://localhost:5173")
	
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
    
	// Rest kaikki vaatteet id:llä http://localhost:8080/vaate/tyyppi
    @RequestMapping(value="/vaate/{tyyppi}", method = RequestMethod.GET)
    public @ResponseBody List<Vaate> findByTyyppi(@PathVariable("tyyppi") String tyyppiId) {
    	return repository.findByTyyppiIgnoreCase(tyyppiId);
    } 
    
	@RequestMapping(value="/asiakkaat", method = RequestMethod.GET)
	public @ResponseBody List<Asiakas> asiakasListRest() {	
	    return (List<Asiakas>) drepository.findAll();
	}
    
    @PostMapping
    public Asiakas addAsiakas(@RequestBody Asiakas asiakas) {
    	Asiakas savedAsiakas = drepository.save(asiakas);
    	return savedAsiakas;
    }
    
}