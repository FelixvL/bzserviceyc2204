package nl.youngcapital.bezorgservice.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Bezorger;
@Service
public class BezorgerService {
	
	@Autowired
	BezorgerRepository rr;
	
	public void testBezorger() {
		rr.save(new Bezorger());
	}

}
