package nl.youngcapital.bezorgservice.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
	@OneToMany
	List<Gerecht> gerechten;
	@OneToOne
	Restaurant restaurant;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Gerecht> getGerechten() {
		return gerechten;
	}
	public void setGerechten(List<Gerecht> gerechten) {
		this.gerechten = gerechten;
	}
	
	public void addGerecht(Gerecht g) {
		gerechten.add(g);
	}

}
