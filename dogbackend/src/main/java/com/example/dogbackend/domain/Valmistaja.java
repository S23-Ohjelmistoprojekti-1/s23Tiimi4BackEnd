package com.example.dogbackend.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;



@Entity
public class Valmistaja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long valmistajaid;
	
	@NotEmpty
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Tuote> vaatteet;
	
	public Valmistaja() {}
	
	public Valmistaja(String nimi) {
		super();
		this.nimi = nimi;
		
	}

	public long getValmistajaid() {
		return valmistajaid;
	}

	public void setValmistajaid(long valmistajaid) {
		this.valmistajaid = valmistajaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public List<Tuote> getVaatteet() {
		return vaatteet;
	}

	
	@Override
	public String toString() {
		return "Category [categoryid=" + valmistajaid + ", name=" + nimi + "]";
	}
}
