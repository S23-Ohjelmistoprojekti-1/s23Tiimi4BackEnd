package com.example.dogbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Asiakas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String etunimi;
	private String sukunimi;
	private String puhelinnumero;
	private String email;
	
	@ManyToOne
	private Asiakas asiakas;

	public Asiakas () {}

	public Asiakas(Long id, String etunimi, String sukunimi, String puhelinnumero, String email, Asiakas asiakas) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelinnumero = puhelinnumero;
		this.email = email;
		this.asiakas = asiakas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getPuhelinnumero() {
		return puhelinnumero;
	}

	public void setPuhelinnumero(String puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Asiakas getAsiakas() {
		return asiakas;
	}

	public void setAsiakas(Asiakas asiakas) {
		this.asiakas = asiakas;
	}

	@Override
	public String toString() {
		return "Asiakas [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", puhelinnumero="
				+ puhelinnumero + ", email=" + email + ", asiakas=" + asiakas + "]";
	}
	
	
}
	
	
