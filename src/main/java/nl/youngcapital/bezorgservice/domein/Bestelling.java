package nl.youngcapital.bezorgservice.domein;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yifongau
 */
@Entity
public class Bestelling {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	LocalDateTime tijdstip;
	int status;
        boolean betaald;


	@ManyToOne
	Klant klant;

	@ManyToOne
	Bezorger bezorger;

	@ManyToMany
	List<Gerecht> gerechten;
	
	@ManyToOne
	Restaurant restaurant;

	//Misschien in de toekomst prijs implementeren.

	// GETTERS & SETTERS

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Gerecht> getGerechten() {
		return gerechten;
	}

	public void setGerechten(List<Gerecht> gerechten) {
		this.gerechten = gerechten;
	}


	public Bezorger getBezorger() {
		return bezorger;
	}

	public void setBezorger(Bezorger bezorger) {
		this.bezorger = bezorger;
	}

	public void addbezorger(Bezorger b) {
		this.bezorger = b;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getTijdstip() {
		return tijdstip;
	}
	public void setTijdstip(LocalDateTime tijdstip) {
		this.tijdstip = tijdstip;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}
        
        public void addGerecht(Gerecht g)
        {
            gerechten.add(g);
        }
        
        
        public boolean isBetaald() {
            return betaald;
        }

        public void setBetaald(boolean betaald) {
            this.betaald = betaald;
        }



}
