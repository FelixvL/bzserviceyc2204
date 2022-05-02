package nl.youngcapital.bezorgservice.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("api/restaurants")
public class RestaurantEndpoint {
	@Autowired
	RestaurantService rs;
	
	@Autowired
	private BezorgerService bs;
	
	@Autowired
	BestellingService bestelservice;
	
	@PostMapping
	public void voegrestauranttoe(@RequestBody Restaurant r) {
		rs.opslaan(r);
	}
	
	@GetMapping("{id}")
	public RestaurantDtoVoorKlant restaurantbyid(@PathVariable("id") int restaurantid) {
		Restaurant r =rs.vindRestaurantById(restaurantid);
		RestaurantDtoVoorKlant rdto = new RestaurantDtoVoorKlant(r.getId(),r.getNaam(), r.getAdres(), r.getTelefoonnummer(), r.getOpeningstijden());
		return rdto;
	}
	
	@GetMapping 
	public Iterable<Restaurant> toonrestaurants(){
		return rs.geefRestaurants();
                
	}
	
	@GetMapping("rekeningvoorklant") 
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
	@PostMapping("bestelling/{bezorgerid}")
	public void kenbezorgertoe(@PathVariable int bezorgerid, @RequestBody Bestelling best){
		Bestelling foundb = bestelservice.vindBestellingById(best.getId());
		Bezorger b = bs.vindBezorgerById(bezorgerid);
		foundb.addbezorger(b);
		bestelservice.opslaan(best);
	}
	
	// bezorger toevoegen aan restaurant
	@PutMapping("{id}/bezorger/{bezorgerid}") 
	// Method: PUT, url: http://localhost:8080/api/restaurants/3/bezorger/15
	public void voegbezorgertoe(@PathVariable int bezorgerid, @PathVariable long id){
		Restaurant vindr = rs.vindRestaurantById(id);
		Bezorger b = bs.vindBezorgerById(bezorgerid);
		vindr.addbezorger(b);
		
		rs.opslaan(vindr);
	}
	//gerecht toevoegen aan restaurant met restaurantid rid
	@PostMapping("{rid}/gerechttoevoegen")
	public void voegGerrechttoe(@PathVariable("rid") int rid, @RequestBody Gerecht g) {
		rs.addGerecht(rid, g);
        
	}
	
	//Restaurant tonen voor bepaalde gerechtid
	// !!! Let op: als je meerdere @GetMappings zou hebben
	// met alleen een long id dan snapt Spring Boot het niet. 
	// want @GetMapping("{id}") en @GetMapping("{gerechtId}" is ambigu.
	// dan los je dat op door iets te doen zoals hier, gewoon prefixen met
	// een woord zoals 'toonRestaurantVanGerecht' of zoiets
	@GetMapping("/toonrestaurantvangerecht/{gerechtid}")
	public Restaurant toonRestaurantVanGerecht(@PathVariable int gerechtid) {
		return rs.toonRestaurantVanGerecht(gerechtid);
	}
	
	//alle gerechten van een restaurant tonen
	@GetMapping("{id}/toonmenu")
	public List<Gerecht> toonmenu(@PathVariable("id") int id) {
		List <Gerecht> gerechten = rs.vindRestaurantById(id).getGerechten();
		
		return gerechten;
	}
	/**
	 * toon de bestellingen alle bestellingen een restaurant
	 * @param id
	 * @return
	 */
	@GetMapping("{id}/toonBestellingen")
	public List<Bestelling> toonresbestellingen(@PathVariable("id") long id) {
		List<Bestelling> result = new LinkedList<Bestelling>();
		Iterable<Bestelling> bestel = bestelservice.geefBestellingen();
		for (Bestelling b:bestel) {
			if (b.getRestaurant().getId()==id) {
				result.add(b);
			}
		}
		return result;
	}
}
