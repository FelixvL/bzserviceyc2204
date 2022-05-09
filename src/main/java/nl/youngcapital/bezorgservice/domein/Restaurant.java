package nl.youngcapital.bezorgservice.domein;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
        String logo;
        String banner;
	
	@ManyToMany
	List<Bezorger> bezorgers;
	
	@OneToMany
	List<Gerecht> gerechten;
	


	public List<Gerecht> getGerechten() {
		return gerechten;
	}
	public void setGerechten(List<Gerecht> gerecht) {
		this.gerechten = gerecht;
	}
	// Voegt een bezorger toe aan lijst bezorgers die bij het restaurant horen
	public void addbezorger(Bezorger b) {
		this.bezorgers.add(b);
	}
	//voegt een gerecht toe aan de lijst gerechten
	public void addGerecht(Gerecht g) {
		this.gerechten.add(g);
	}
	
	// verwijderd gerecht van de lijst gerechten
	public void deleteGerecht(Gerecht g) {
		this.gerechten.remove(g);
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

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }
	
}
