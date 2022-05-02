package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import nl.youngcapital.bezorgservice.domein.Bezorger;
import nl.youngcapital.bezorgservice.persistance.BezorgerService;

@RestController
@RequestMapping("api/bezorgers") // default api/bezorgers
public class BezorgerEndpoint {

	@Autowired
	BezorgerService bs;

	@GetMapping("{id}")  // voegt {id} toe aan api/bezorgers. bv. http://localhost:8080/api/bezorgers/3
	public Bezorger bezorgerbyid(@PathVariable("id") int bezorgerid) {
		return bs.vindBezorgerById(bezorgerid);
	}

	@GetMapping // Getmapping dus toont alle bezorgers (default mapping: api/bezorgers)
	public Iterable<Bezorger> toonbezorgers() {
		return bs.geefBezorgers();
	}

	@PostMapping // Post is standaard voor toevoegen dus POST naar api/bezorgers is impliciet een niewe maken.
	public void voegbezorgertoe(@RequestBody Bezorger b) {
		bs.opslaan(b);
	}
}
