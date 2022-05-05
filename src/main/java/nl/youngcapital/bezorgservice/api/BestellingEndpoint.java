/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.api;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.persistance.BestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yifongau
 */

@RestController
public class BestellingEndpoint {

	@Autowired
	BestellingService bestellingService;

	@PostMapping("/nieuwebestelling/{klantid}/{restaurantid}")
	public void voegbestellingtoe(@RequestBody Bestelling b, @PathVariable("klantid")long id, @PathVariable("restaurantid")long rid) {
		bestellingService.opslaanBestelling(b, id, rid);
	}
        
        @PutMapping("voeggerechttoe/{bestellingid}/{gerechtid}")
        public void voegGerechtToe(@PathVariable("bestellingid") long bid, @PathVariable("gerechtid")long id)
        {
            bestellingService.voegGerechtToe(bid, id);
        }
        
                
	@GetMapping("/geefallebestellingen")
	public Iterable<Bestelling> geefAlleBestellingen(){
		return bestellingService.geefBestellingen();
	}
        
        @GetMapping("geefbestellingenvanklant/{kid}")
        public Iterable<Bestelling> geefBestellingenVanKlant(@PathVariable("kid") long klantid)
         {
             return bestellingService.geefBestellingVanKlant(klantid);
         }
        
        @GetMapping("geefbestellingenvanres/{kid}")
        public Iterable<Bestelling> geefBestellingenVanrestaurant(@PathVariable("kid") long restid)
         {
             return bestellingService.geefBestellingVanRestaurant(restid);
         }
        
        @PostMapping("setstatus/{bid}")
        public boolean setStatus(@RequestBody int status, @PathVariable("bid") long bid)
        {
            return bestellingService.setStatus(status, bid);
        }

	@GetMapping("/geefbestelling/{bid}")
	public Bestelling bestellingbyid(@PathVariable("bid") int bezorgerid) {
		return bestellingService.vindBestellingById(bezorgerid);
	}

}
