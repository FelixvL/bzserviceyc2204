package nl.youngcapital.bezorgservice.persitance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.bezorgservice.domein.Docent;

@Service
public class DocentService {

	@Autowired
	DocentRepository dr;
	
	public void testFunctie() {
		dr.save(new Docent());
	}
}
