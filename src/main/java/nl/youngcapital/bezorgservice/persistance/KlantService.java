
package nl.youngcapital.bezorgservice.persistance;

import nl.youngcapital.bezorgservice.domein.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KlantService 
{
    @Autowired
    KlantRepository kr;
    
    public void addKlant(Klant k)
    {
        Klant klant = k;
        kr.save(klant);
        
    }
    
    public Iterable<Klant> getKlanten()
    {
        return kr.findAll();
    }
    
    public String hoi()
    {
        System.out.println("hoi hoi");
        return "3";
        
    }
            
           
    
}
