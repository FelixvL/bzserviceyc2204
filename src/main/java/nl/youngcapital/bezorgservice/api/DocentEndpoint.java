package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Docent;
import nl.youngcapital.bezorgservice.persitance.DocentService;

@RestController
public class DocentEndpoint {
	@Autowired
	DocentService ds;
	
	
	@GetMapping("/docent")
	public Docent getMockDocent() {
		ds.testFunctie();
		return new Docent();
	}

}
