package nl.youngcapital.bezorgservice.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.domein.Docent;

@Service
public class DocentService {

	@Autowired
	DocentRepository dr;
	
	@Autowired
	BestellingRepository br;
	
	public void testFunctie() {
		dr.save(new Docent());
	}
	
	public Iterable<Docent> geefAlleDocenten(){
		return dr.findAll();
	}
	public Docent geefDocent(long id) {
		Docent docent = dr.findById(id).get();
		return docent;
	}
	public void saveDocent(Docent docent) {
		dr.save(docent);
	}

	public void addBestelling(long docentid, long bestellingid) {
		Docent tempDocent = geefDocent(docentid);
		Bestelling tempBestelling = br.findById(bestellingid).get();
		tempDocent.getBestellingen().add(tempBestelling);
		dr.save(tempDocent);
		
	}
}
