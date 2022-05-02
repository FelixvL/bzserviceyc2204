package nl.youngcapital.bezorgservice.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Bezorger;

@Service
public class BezorgerService {
	
	@Autowired
	BezorgerRepository br;
	
	public void testBezorger() {
		br.save(new Bezorger());
	}

	public Bezorger opslaan(Bezorger b) {
		return br.save(b);
	}
	
	public Iterable<Bezorger> geefBezorgers(){
		return br.findAll();
	}
	
	public Bezorger vindBezorgerById(long bezorgerid) {
		Bezorger gevonden = br.findById(bezorgerid).get();
		return gevonden;
	}
}
