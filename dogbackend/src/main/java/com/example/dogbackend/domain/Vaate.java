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
	private String tyyppi;

	private String vari;
	
	private String koko;
	
	private double hinta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "valmistajaid")
	private Valmistaja valmistaja;
	
	public Vaate() {}
	
	public Vaate(String tyyppi, String vari, String koko, double hinta, Valmistaja valmistaja) {
		super();
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
	public String getTyyppi() {
		return tyyppi;
	}
	public void setTyyppi(String tyyppi) {
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
		return "Vaate [id=" + id + ", tyyppi=" + tyyppi + ", vari=" + vari + ", koko=" + koko + ", hinta=" + hinta
				+ ", valmistaja=" + valmistaja + "]";
	}

	
	
}