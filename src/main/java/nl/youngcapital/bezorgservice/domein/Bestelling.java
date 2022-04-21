package nl.youngcapital.bezorgservice.domein;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
}
