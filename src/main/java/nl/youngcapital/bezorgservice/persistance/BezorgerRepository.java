package nl.youngcapital.bezorgservice.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.youngcapital.bezorgservice.domein.Bezorger;
@Component
public interface BezorgerRepository extends CrudRepository<Bezorger, Long> {

}
