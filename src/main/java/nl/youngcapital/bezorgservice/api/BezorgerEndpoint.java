package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Bezorger;
import nl.youngcapital.bezorgservice.persistance.BezorgerService;

@RestController
public class BezorgerEndpoint {
	@Autowired
	BezorgerService bs;
	
	@GetMapping("/bezorgerbyid/{id}")
	public Bezorger bezorgerbyid(@PathVariable("id") int bezorgerid) {
		return bs.vindBezorgerById(bezorgerid);
	}
	
	@GetMapping("/toonbezorgers") 
	public Iterable<Bezorger> toonbezorgers(){
		return bs.geefBezorgers();
	}
	
	@PostMapping("/bezorgertoevoegen")
	public void voegbezorgertoe(@RequestBody Bezorger b) {
		bs.opslaan(b);
	}
}
