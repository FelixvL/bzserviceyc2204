package nl.youngcapital.bezorgservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.bezorgservice.persistance.BezorgerService;
import nl.youngcapital.bezorgservice.persistance.DocentService;

@RestController
public class BezorgerEndpoint {
	@Autowired
	BezorgerService bs;
	
    
}
