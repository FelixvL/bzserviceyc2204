package nl.youngcapital.bezorgservice.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	String probeersel;
	
	@OneToMany
	List<Bestelling> bestellingen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProbeersel() {
		return probeersel;
	}

	public void setProbeersel(String probeersel) {
		this.probeersel = probeersel;
	}

	public List<Bestelling> getBestellingen() {
		return bestellingen;
	}

	public void setBestellingen(List<Bestelling> bestellingen) {
		this.bestellingen = bestellingen;
	}
	
	
	
	
}
