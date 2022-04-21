
 
package nl.youngcapital.bezorgservice.api;

import nl.youngcapital.bezorgservice.domein.Klant;
import nl.youngcapital.bezorgservice.persistance.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public class KlantEndpoint 
{
    @Autowired
    KlantService ks;
    
    @PostMapping(path = "/addklant")
    public void addKlant()
    {
        
    }
    
    
    @GetMapping(path = "/getklanten")
    public Iterable<Klant> getKlanten()
    {
        return ks.getKlanten();
    }
            
}
