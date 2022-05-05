package nl.youngcapital.bezorgservice.persistance;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.domein.Klant;
import nl.youngcapital.bezorgservice.domein.Restaurant;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yifongau
 */
@Component
public interface BestellingRepository extends CrudRepository<Bestelling, Long>  {
   // List<Bestelling> findBestellingByBezorgtijd(int tijd);
    
    Iterable<Bestelling> findBestellingByKlant(Klant k);
    
    Iterable<Bestelling> findByRestaurantAndStatusIsNot(Restaurant r, int status);
}
