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
	private String kotiosoite;
	private String postinumero;
	private String postitoimipaikka;
	private String puhelinnumero;
	private String email;
	
	public Asiakas () {}


	public Asiakas(String etunimi, String sukunimi, String kotiosoite, String postinumero,
			String postitoimipaikka, String puhelinnumero, String email) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.kotiosoite = kotiosoite;
		this.postinumero = postinumero;
		this.postitoimipaikka = postitoimipaikka;
		this.puhelinnumero = puhelinnumero;
		this.email = email;
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


	public String getKotiosoite() {
		return kotiosoite;
	}


	public void setKotiosoite(String kotiosoite) {
		this.kotiosoite = kotiosoite;
	}


	public String getPostinumero() {
		return postinumero;
	}


	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}


	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}


	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
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


	@Override
	public String toString() {
		return "Asiakas [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", kotiosoite=" + kotiosoite
				+ ", postinumero=" + postinumero + ", postitoimipaikka=" + postitoimipaikka + ", puhelinnumero="
				+ puhelinnumero + ", email=" + email + "]";
	}
	
	
}
	
	
