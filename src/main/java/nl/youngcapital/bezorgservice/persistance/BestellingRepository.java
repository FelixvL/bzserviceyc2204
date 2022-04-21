package nl.youngcapital.bezorgservice.persistance;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.youngcapital.bezorgservice.domein.Bestelling;

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
    
}
