package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Docent;
import nl.youngcapital.bezorgservice.persistance.DocentService;

@RestController
@RequestMapping("api/docenten")
public class DocentEndpoint {
	@Autowired
	private DocentService ds;
	
	
	@GetMapping("/docent")
	public Docent getMockDocent() {
		ds.testFunctie();
		return new Docent();
	}
	
	@PostMapping
	public void nieuweDocent(@RequestBody Docent docent) {
		ds.saveDocent(docent);
	}
	
	@GetMapping("{id}")
	public Docent geefDocent(@PathVariable("id") int id ) {
		return ds.geefDocent(id);
	} 

	@GetMapping
	public Iterable<Docent> geefAlleDocenten(){
		return ds.geefAlleDocenten();
	}
	@GetMapping("addBestelling/{docentid}/{bestellingid}")
	public void addBestelling(@PathVariable int docentid, @PathVariable int bestellingid) {
		ds.addBestelling(docentid, bestellingid);
	}
	
}
