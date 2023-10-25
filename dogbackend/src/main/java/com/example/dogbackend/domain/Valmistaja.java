package com.example.dogbackend.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Valmistaja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long valmistajaid;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Vaate> vaates;
	
	public Valmistaja() {}
	
	public Valmistaja(String name) {
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
	
	@Override
	public String toString() {
		return "Category [categoryid=" + valmistajaid + ", name=" + nimi + "]";
	}
}
