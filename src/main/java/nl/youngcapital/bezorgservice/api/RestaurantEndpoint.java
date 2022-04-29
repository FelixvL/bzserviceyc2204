package nl.youngcapital.bezorgservice.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.domein.Bezorger;
import nl.youngcapital.bezorgservice.domein.Gerecht;
import nl.youngcapital.bezorgservice.domein.Restaurant;
import nl.youngcapital.bezorgservice.domein.RestaurantDtoVoorKlant;
import nl.youngcapital.bezorgservice.persistance.BestellingService;
import nl.youngcapital.bezorgservice.persistance.BezorgerService;
import nl.youngcapital.bezorgservice.persistance.RestaurantService;

@RestController
public class RestaurantEndpoint {
	@Autowired
	RestaurantService rs;
	
	@Autowired
	BezorgerService bs;
	
	@Autowired
	BestellingService bestelservice;
	
	@PostMapping("/restauranttoevoegen")
	public void voegrestauranttoe(@RequestBody Restaurant r) {
		rs.opslaan(r);
	}
	
	@GetMapping("/restaurantbyid/{id}")
	public RestaurantDtoVoorKlant restaurantbyid(@PathVariable("id") int restaurantid) {
		Restaurant r =rs.vindRestaurantById(restaurantid);
		RestaurantDtoVoorKlant rdto = new RestaurantDtoVoorKlant(r.getId(),r.getNaam(), r.getAdres(), r.getTelefoonnummer(), r.getOpeningstijden());
		return rdto;
	}
	
	@GetMapping("/toonrestaurants") 
	public Iterable<Restaurant> toonrestaurants(){
		return rs.geefRestaurants();
	}
	
	@GetMapping("/toonrestaurants/voorklant") 
	public List<RestaurantDtoVoorKlant> toonrestaurantsvoorklant(){
		List <Restaurant> tmprestaurant = rs.geefRestaurants();
		List <RestaurantDtoVoorKlant> restdtolist = new LinkedList <RestaurantDtoVoorKlant>() ;
		for(Restaurant r : tmprestaurant) {
			RestaurantDtoVoorKlant tmprestdto = new RestaurantDtoVoorKlant(r.getId(),r.getNaam(), r.getAdres(), r.getTelefoonnummer(), r.getOpeningstijden());
			restdtolist.add(tmprestdto);
		
		}
		return restdtolist;
	}

	// bezorger toevoegen aan bestelling
	@PostMapping("/bestelling_voegbezorgertoe")
	public void kenbezorgertoe(@RequestBody int bezorgerid, @RequestBody Bestelling best){
		Bestelling foundb = bestelservice.vindBestellingById(best.getId());
		Bezorger b = bs.vindBezorgerById(bezorgerid);
		foundb.addbezorger(b);
		bestelservice.opslaan(best);
	}
	
	// bezorger toevoegen aan restaurant
	@PostMapping("voegbezorgertoe")
	public void voegbezorgertoe(@RequestBody int bezorgerid, @RequestBody Restaurant r){
		Restaurant vindr = rs.vindRestaurantById(r.getId());
		Bezorger b = bs.vindBezorgerById(bezorgerid);
		vindr.addbezorger(b);
		rs.opslaan(r);
	}
	//gerecht toevoegen aan restaurant met restaurantid rid
	@PostMapping("/gerechttoevoegen/{rid}")
	public void voegGerrechttoe(@RequestBody Gerecht g, @PathVariable("rid") int rid) {
		rs.addGerecht(rid, g);
        
	}
	//Restaurant tonen voor bepaalde gerechtid
	@GetMapping("/toonrestaurantvangerecht/{gerechtid}")
	public Restaurant toonRestaurantVanGerecht(@PathVariable int gerechtid) {
		return rs.toonRestaurantVanGerecht(gerechtid);
	}
	
	//alle gerechten van een restaurant tonen
	@GetMapping("/toonmenu/{restaurantid}")
	public List<Gerecht> toonmenu(@PathVariable("restaurantid") int restaurantid) {
		List <Gerecht> gerechten = rs.vindRestaurantById(restaurantid).getGerechten();
		return gerechten;
	}
	/**
	 * toon de bestellingen alle bestellingen een restaurant
	 * @param restaurantid
	 * @return
	 */
	@GetMapping("/toonresbestellingen/{restaurantid}")
	public List<Bestelling> toonresbestellingen(@PathVariable("restaurantid") int restaurantid) {
		List<Bestelling> result = new LinkedList<Bestelling>();
		Iterable<Bestelling> bestel = bestelservice.geefBestellingen();
		for (Bestelling b:bestel) {
			if (b.getRestaurant().getId()==restaurantid) {
				result.add(b);
			}
		}
		return result;
	}

}
