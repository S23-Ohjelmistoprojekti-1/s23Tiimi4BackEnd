package com.example.dogbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Vaate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@NotEmpty
	@Size(min=2, max=50)
	private String nimi;

	private String vari;
	
	private String koko;
	
	private double hinta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "valmistajaid")
	private Valmistaja valmistaja;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tyyppiid")
	private Tyyppi tyyppi;
	
	public Vaate() {}
	
	public Vaate(String nimi, Tyyppi tyyppi, String vari, String koko, double hinta, Valmistaja valmistaja) {
		super();
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.vari = vari;
		this.koko = koko;
		this.hinta = hinta;
		this.valmistaja = valmistaja;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public Tyyppi getTyyppi() {
		return tyyppi;
	}
	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}
	public String getVari() {
		return vari;
	}
	public void setVari(String vari) {
		this.vari = vari;
	}
	public String getKoko() {
		return koko;
	}
	public void setKoko(String koko) {
		this.koko = koko;
	}
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public Valmistaja getValmistaja() {
		return valmistaja;
	}
	public void setValmistaja(Valmistaja valmistaja) {
		this.valmistaja = valmistaja;
	}

	@Override
	public String toString() {
		return "Vaate [id=" + id + ", tyyppi=" + tyyppi + ", nimi=" + nimi + ", vari=" + vari + ", koko=" + koko
				+ ", hinta=" + hinta + ", valmistaja=" + valmistaja + "]";
	}
	


	
	
}