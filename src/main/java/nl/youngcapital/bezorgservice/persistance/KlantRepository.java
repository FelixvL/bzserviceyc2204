
 
package nl.youngcapital.bezorgservice.persistance;

import nl.youngcapital.bezorgservice.domein.Klant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface KlantRepository extends CrudRepository<Klant, Long>  
{
    
}
