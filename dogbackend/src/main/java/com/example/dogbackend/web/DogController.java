package com.example.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dogbackend.domain.VaateRepository;

@Controller
public class DogController {
	@Autowired
	private VaateRepository repository;
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteVaate(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/itemlist";
}
}
