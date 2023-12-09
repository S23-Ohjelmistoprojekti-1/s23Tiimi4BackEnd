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
public class Tyyppi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long tyyppiid;
	
	@NotEmpty
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tyyppi")
	private List<Tuote> vaatteet;
	
	public Tyyppi() {}
	
	public Tyyppi(String nimi) {
		super();
		this.nimi = nimi;
		
	}

	public long getTyyppiid() {
		return tyyppiid;
	}

	public void setTyyppiid(long tyyppiid) {
		this.tyyppiid = tyyppiid;
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
		return "Category [categoryid=" + tyyppiid + ", name=" + nimi + "]";
	}
}
