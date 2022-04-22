package nl.youngcapital.bezorgservice.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Restaurant;



@Service 
public class RestaurantService {
	@Autowired
	RestaurantRepository rr;
	
	public void opslaan(Restaurant b) {
		rr.save(b);
	}
	
	public List<Restaurant> geefRestaurants(){
		return rr.findAll();
	}
	
	public Restaurant vindRestaurantById(long restaurantid) {
		Restaurant gevonden = rr.findById(restaurantid).get();
		return gevonden;
	}
}
