package com.example.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dogbackend.domain.Vaate;
import com.example.dogbackend.domain.VaateRepository;
import com.example.dogbackend.domain.Valmistaja;
import com.example.dogbackend.domain.ValmistajaRepository;

@Controller
public class DogController {
	@Autowired
	private VaateRepository repository;
	@Autowired
	private ValmistajaRepository vrepository;
	
	@RequestMapping("/itemlist")
	public String itemList(Model model) {
		model.addAttribute("Vaatteet", repository.findAll());
		return "itemlist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVaate(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/itemlist";
}
	@RequestMapping(value = "add")
	public String addVaate (Model model) {
		model.addAttribute("vaate", new Vaate());
		model.addAttribute("valmistajat", vrepository.findAll());
		return "addItem";
	}
	
	@RequestMapping(value = "addValmistaja")
	public String addValmistaja (Model model) {
		model.addAttribute("valmistaja", new Valmistaja());
		return "addValmistaja";
	}
	
	@RequestMapping(value = "/saveVaate", method = RequestMethod.POST)
	public String saveVaate (Vaate vaate) {
		repository.save(vaate);
		return "redirect:itemlist";
	}
	
	@RequestMapping(value = "/saveValmistaja", method = RequestMethod.POST)
	public String saveValmistaja (Valmistaja valmistaja) {
		vrepository.save(valmistaja);
		return "redirect:itemlist";
	}
}
