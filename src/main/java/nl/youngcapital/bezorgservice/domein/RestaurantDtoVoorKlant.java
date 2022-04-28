package nl.youngcapital.bezorgservice.domein;

public class RestaurantDtoVoorKlant {
	long id;
	public long getId() {
		return id;
	}

	String naam;
	String adres;
	String telefoonnummer;
	String openingstijden;
	
	public String getNaam() {
		return naam;
	}

	public String getAdres() {
		return adres;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public String getOpeningstijden() {
		return openingstijden;
	}

	public RestaurantDtoVoorKlant(long id, String naam, 
			String adres,
			String telefoonnummer,
			String openingstijden) {
		
		this.id=id;
		this.naam=naam;
		this.adres=adres;
		this.telefoonnummer=telefoonnummer;
		this.openingstijden=openingstijden;
		
		
		
	}

}
