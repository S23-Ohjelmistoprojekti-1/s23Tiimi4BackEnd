package com.example.dogbackend.web;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/valmistajalist")
	public String valmistajaList(Model model) {
		model.addAttribute("Valmistajat", vrepository.findAll());
		return "valmistajaList";
	}
	
	// deleting
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVaate(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/itemlist";
}
	
	@RequestMapping(value = "/delete/valmistaja/{valmistajaid}", method = RequestMethod.GET)
	public String deleteValmistaja(@PathVariable Long valmistajaid) {
		vrepository.deleteById(valmistajaid);
		return "redirect:/valmistajalist";
}
	// adding
	@RequestMapping(value = "add")
	public String addVaate (Model model) {
		model.addAttribute("vaate", new Vaate());
		model.addAttribute("valmistajat", vrepository.findAll());
		return "addItem";
	}
	
	@RequestMapping(value = "addValmistaja")
	public String addValmistaja (Model model) {
		model.addAttribute("valmistaja", new Valmistaja());
		model.addAttribute("Valmistajat", vrepository.findAll());
		return "addValmistaja";
	}
	//saving
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveVaate (Vaate vaate) {
		repository.save(vaate);
		return "redirect:itemlist";
	}
	
	@RequestMapping(value = "/saveValmistaja", method = RequestMethod.POST)
	public String saveValmistaja (Valmistaja valmistaja) {
		vrepository.save(valmistaja);
		return "redirect:valmistajalist";
	}
	
	//editing
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Long Id, Model model){
		model.addAttribute("vaate", repository.findById(Id));
		model.addAttribute("valmistajat", vrepository.findAll());
		return "editItem";
	}
}