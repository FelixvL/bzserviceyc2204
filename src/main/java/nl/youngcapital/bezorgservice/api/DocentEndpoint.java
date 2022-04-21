package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Docent;
import nl.youngcapital.bezorgservice.persistance.DocentService;

@RestController
public class DocentEndpoint {
	@Autowired
	DocentService ds;
	
	
	@GetMapping("/docent")
	public Docent getMockDocent() {
		ds.testFunctie();
		return new Docent();
	}
	
	@PostMapping("nieuweDocent")
	public void nieuweDocent(@RequestBody Docent docent) {
		ds.saveDocent(docent);
	}
	
	@GetMapping("geefDocent/{id}")
	public Docent geefDocent(@PathVariable("id") int id ) {
		return ds.geefDocent(id);
	} 

	@GetMapping("geefAlleDocenten")
	public Iterable<Docent> geefAlleDocenten(){
		return ds.geefAlleDocenten();
	}
}
