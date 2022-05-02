
 
package nl.youngcapital.bezorgservice.api;

import nl.youngcapital.bezorgservice.domein.Klant;
import nl.youngcapital.bezorgservice.persistance.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/klanten")
public class KlantEndpoint 
{
    
    @Autowired
    private KlantService ks;
    
    @GetMapping("/hoi")
    public void hoi()
    {
        System.out.println("hoi");
        ks.hoi();
        ks.addKlant(new Klant());
    }
    
    @PostMapping
    public void addKlant(@RequestBody Klant k)
    {
        ks.addKlant(k);
    }
    
    
    @GetMapping
    public Iterable<Klant> getKlanten()
    {
        return ks.getKlanten();
    }
            
}
