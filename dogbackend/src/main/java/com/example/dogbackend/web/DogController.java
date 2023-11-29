package com.example.dogbackend.web;

import java.util.List;

//import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

//import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dogbackend.domain.Asiakas;
import com.example.dogbackend.domain.AsiakasRepository;
import com.example.dogbackend.domain.TyyppiRepository;
import com.example.dogbackend.domain.Vaate;
import com.example.dogbackend.domain.VaateRepository;
import com.example.dogbackend.domain.Valmistaja;
import com.example.dogbackend.domain.ValmistajaRepository;

import jakarta.validation.Valid;

@Controller
public class DogController {
	@Autowired
	private VaateRepository repository;
	@Autowired
	private ValmistajaRepository vrepository;
	@Autowired
	private AsiakasRepository drepository;
	@Autowired
	private TyyppiRepository trepository;
	
	@GetMapping({"/", "index"})
	public String showHome() {
		return "index";
	}
	
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	
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
	
	@RequestMapping("/asiakaslist")
	public String asiakaslist(Model model) {
		model.addAttribute("Asiakkaat", drepository.findAll());
		return "asiakasList";
	}
	
	@RequestMapping(value = "/delete/asiakas/{asiakasid}", method = RequestMethod.GET)
	public String deleteAsiakas(@PathVariable Long asiakasid) {
	    drepository.deleteById(asiakasid);
	    return "redirect:/asiakaslist";
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
		model.addAttribute("tyypit", trepository.findAll());
		return "addItem";
	}
	
	@RequestMapping(value = "addValmistaja")
	public String addValmistaja (Model model) {
		model.addAttribute("valmistaja", new Valmistaja());
		model.addAttribute("Valmistajat", vrepository.findAll());
		return "addValmistaja";
	}
	
	@RequestMapping(value = "addAsiakas")
	public String addAsiakas (Model model) {
		model.addAttribute("asiakas", new Asiakas());
		model.addAttribute("Asiakkaat", drepository.findAll());
		return "addAsiakas";
	}
	
	//saving
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveVaate (@Valid @ModelAttribute("vaate") Vaate vaate, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Valid error" + vaate);
			// model.addAttribute("vaate", new Vaate());
			model.addAttribute("valmistajat", vrepository.findAll());
		    return "addItem";
		}
		System.out.println("SAVE " + vaate);
		repository.save(vaate);
		return "redirect:/itemlist";
	}
	
	//savevalmistaja
	@RequestMapping(value = "/saveValmistaja", method = RequestMethod.POST)
	public String saveValmistaja (@Valid @ModelAttribute("valmistaja") Valmistaja valmistaja, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "addValmistaja";
		}
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
	
	@RequestMapping(value = "/editasiakas/{id}")
	public String editCustomer(@PathVariable("id") Long Id, Model model){
	    model.addAttribute("asiakas", drepository.findById(Id));
	    return "editAsiakas";
	}
	
	//saveasiakas
	@RequestMapping(value = "/saveasiakas", method = RequestMethod.POST)
	public String saveAsiakas (@Valid @ModelAttribute("asiakas") Asiakas asiakas, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Valid error" + asiakas);
		    return "addAsiakas";
		}
		
		drepository.save(asiakas);
	    return "redirect:/asiakaslist";
	}
	
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addValid(Vaate vaate, Model model) {
    	model.addAttribute("Vaate", vaate);
	    return "addItem";
    }
    
    @GetMapping("/valmistaja/{valmistajaid}/vaatteet")
    public String valmistajaVaatteet(@PathVariable Long valmistajaid, Model model) {
        Valmistaja valmistaja = vrepository.findById(valmistajaid).orElse(null);
        if (valmistaja != null) {
            List<Vaate> valmistajaVaatteet = repository.findByValmistaja(valmistaja);
            model.addAttribute("valmistaja", valmistaja);
            model.addAttribute("valmistajaVaatteet", valmistajaVaatteet);
            return "valmistajaVaatteet";
        } else {
            System.out.println("Valmistajaa ei löytynyt");
            return "error";
        }
    }
}