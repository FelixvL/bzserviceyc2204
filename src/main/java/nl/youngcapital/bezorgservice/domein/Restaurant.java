package nl.youngcapital.bezorgservice.domein;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String naam;
	String adres;
	String telefoonnummer;
	String rekeningnummer;
	String openingstijden;
	
	@ManyToMany
	List<Bezorger> bezorgers;
	
	// Voegt een bezorger toe aan lijst bezorgers die bij het restaurant horen
	public void addbezorger(Bezorger b) {
		this.bezorgers.add(b);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public String getRekeningnummer() {
		return rekeningnummer;
	}
	public void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}
	public String getOpeningstijden() {
		return openingstijden;
	}
	public void setOpeningstijden(String openingstijden) {
		this.openingstijden = openingstijden;
	}

	public List<Bezorger> getBezorgers() {
		return bezorgers;
	}

	public void setBezorgers(List<Bezorger> bezorgers) {
		this.bezorgers = bezorgers;
	}
	
}
