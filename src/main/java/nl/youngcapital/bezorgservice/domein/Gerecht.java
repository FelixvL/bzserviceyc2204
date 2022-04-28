package nl.youngcapital.bezorgservice.domein;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gerecht {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        long id;
	String naam;
	int prijs;
	String afbeelding;
	
	
	
	
	// Getters & setters
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
	public int getPrijs() {
		return prijs;
	}
	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}
	public String getAfbeelding() {
		return afbeelding;
	}
	public void setAfbeelding(String afbeelding) {
		this.afbeelding = afbeelding;
	}

}
