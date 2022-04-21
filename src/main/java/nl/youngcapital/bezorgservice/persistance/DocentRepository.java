package nl.youngcapital.bezorgservice.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.youngcapital.bezorgservice.domein.Docent;

@Component
public interface DocentRepository extends CrudRepository<Docent, Long>{

}
