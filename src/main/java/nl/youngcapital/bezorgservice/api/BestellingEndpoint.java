/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.persistance.BestellingService;

/**
 *
 * @author yifongau
 */

@RestController
@RequestMapping("api/bestellingen")
public class BestellingEndpoint {

	@Autowired
	private BestellingService bestellingService;

	@PostMapping("klant/{klantid}/restaurant/{restaurantid}")
	public void voegbestellingtoe(@RequestBody Bestelling b, @PathVariable("klantid") long id,
			@PathVariable("restaurantid") long rid) {
		bestellingService.opslaanBestelling(b, id, rid);
	}

	@PutMapping("voeggerechttoe/{bestellingid}/{gerechtid}")
	public void voegGerechtToe(@PathVariable("bestellingid") long bid, @PathVariable("gerechtid") long id) {
		bestellingService.voegGerechtToe(bid, id);
	}

	@GetMapping
	public Iterable<Bestelling> geefAlleBestellingen() {
		return bestellingService.geefBestellingen();
	}

	@GetMapping("geefbestellingenvanklant/{klantId}") // als de naam van de PathVariable (hier klantId) gelijk is aan de parameter hieronder (in de signature van de method, dan mag je de value onder @PathVariable leeg laten.
	public Iterable<Bestelling> geefBestellingenVanKlant(@PathVariable long klantId) { // kijk, hier is klantId boven de method in de annotatie en als parameter dus hetzelfde.
		return bestellingService.geefBestellingVanKlant(klantId);
	}

	@GetMapping("/geefbestelling/{bezorgerId}")
	public Bestelling findBestellingByBezorgerId(@PathVariable int bezorgerId) {
		return bestellingService.vindBestellingById(bezorgerId);
	}

	@PostMapping("/addbestelling/{klantid}")
	public void addBestelling(@RequestBody Bestelling b) {
		//TODO
	}
}
