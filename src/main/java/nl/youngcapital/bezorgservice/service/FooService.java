package nl.youngcapital.bezorgservice.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Klant;
import nl.youngcapital.bezorgservice.persistance.KlantRepository;


/**
 * 
 * @author rloman
 *
 *	Hieronder stukje uitleg over het gebruik van Transacties
 */
@Service
public class FooService {

	@Autowired
	private KlantRepository klantRepository;
	
	
	@Transactional
	public Optional<Klant> updateKlantById(long id, Klant input) {
		Optional<Klant> optionalKlant = this.klantRepository.findById(id);
		if(optionalKlant.isPresent()) {
			Klant target = optionalKlant.get();
			target.setAchternaam(input.getAchternaam());
			// en voor alle getters
			
			this.klantRepository.save(target);
			
			// !!! En wat nu als er tijdens de update een NullPointerException of een andere
			// exceptie optreedt?
			
			// => Dan kun je je methode (of de gehele class) voorzien van de 
			// @Transactional annotatie
			// Die hanteert dan een all-or-nothing approach. Of alles wordt geupdate. Of niets.
			
			return Optional.of(target);
		}
		else {
			return Optional.empty(); // eventueel Optional returnen of zo laten. 
		}
	}
	
	// Hoeft niet direct bij ophalen van een List
	
	
	public void bar() {
		this.updateKlantById(0, null); // dan start er GEEN transactie
	}
	
	/* Sidenote: 
	 * De transactie wordt gestart als je de methode VAN BUITEN EEN ANDERE klasse aanroept.
	 * Als je vanuit deze klasse in  een niet geannoteerde methode een wel met @Transactional geannoteerde methode aanroept,
	 * dan wordt er GEEN transactie gestart. 
	 */
	
}
