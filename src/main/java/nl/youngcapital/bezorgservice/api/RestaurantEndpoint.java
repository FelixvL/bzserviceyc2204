package nl.youngcapital.bezorgservice.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Bezorger;
import nl.youngcapital.bezorgservice.domein.Gerecht;
import nl.youngcapital.bezorgservice.domein.Restaurant;
import nl.youngcapital.bezorgservice.domein.RestaurantDtoVoorKlant;
import nl.youngcapital.bezorgservice.persistance.BezorgerService;
import nl.youngcapital.bezorgservice.persistance.RestaurantService;

@RestController
public class RestaurantEndpoint {
	@Autowired
	RestaurantService rs;
	
	@Autowired
	BezorgerService bs;
	
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

	@PostMapping("voegbezorgertoe")
	public void voegbezorgertoe(@RequestBody int bezorgerid, @RequestBody Restaurant r){
		Restaurant vindr = rs.vindRestaurantById(r.getId());
		Bezorger b = bs.vindBezorgerById(bezorgerid);
		vindr.addbezorger(b);
		rs.opslaan(r);
	}
	
	@PostMapping("/gerechttoevoegen")
	public void voegGerrechttoe(@RequestBody Gerecht g, @RequestBody Restaurant r) {
		rs.vindRestaurantById(r.getId()).addbgerechten(g);
	}
	
	@GetMapping("/toonmenu/{restaurantid}")
	public void toonmenu(@PathVariable("restaurantid") int restaurantid) {
		rs.vindRestaurantById(restaurantid).getMenu().getGerechten();
	}
}
