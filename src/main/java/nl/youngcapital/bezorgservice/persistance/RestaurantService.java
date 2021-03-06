package nl.youngcapital.bezorgservice.persistance;

import java.util.List;
import nl.youngcapital.bezorgservice.domein.Gerecht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Restaurant;

//

@Service 
public class RestaurantService {
	@Autowired
	RestaurantRepository rr;
        
        @Autowired
        GerechtRepository gr;
        
        @Autowired
        BestellingRepository br;
	
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
	public void addGerecht(long id, Gerecht g)
	{
		Restaurant r = rr.findById(id).get();
		Gerecht ge = gr.save(g);
		r.addGerecht(ge);
		rr.save(r);

	}
	
	
	// remove gerecht uit restaurant
	public void removeGerecht(long gid) {
		Gerecht g = gr.findById(gid).get();
		Restaurant r = rr.findByGerechten(g);
		r.deleteGerecht(g);
		rr.save(r);
		
	}

	public Restaurant toonRestaurantVanGerecht(long gerechtid) {
		Gerecht g = gr.findById(gerechtid).get();
		Restaurant r = rr.findByGerechten(g);
		return r;
	}

	
}
