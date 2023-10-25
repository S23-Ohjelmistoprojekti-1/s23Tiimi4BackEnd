package com.example.dogbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String tyyppi;
	private String väri;
	private String koko;
	private double hinta;
	private String valmistaja;
	
	public Vaate(long id, String tyyppi, String väri, String koko, double hinta, String valmistaja) {
		super();
		this.id = id;
		this.tyyppi = tyyppi;
		this.väri = väri;
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
	public String getVäri() {
		return väri;
	}
	public void setVäri(String väri) {
		this.väri = väri;
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
	public String getValmistaja() {
		return valmistaja;
	}
	public void setValmistaja(String valmistaja) {
		this.valmistaja = valmistaja;
	}
	
	@Override
	public String toString() {
		return "Vaate [id=" + id + ", tyyppi=" + tyyppi + ", väri=" + väri + ", koko=" + koko + ", hinta=" + hinta
				+ ", valmistaja=" + valmistaja + "]";
	}

	
	
}