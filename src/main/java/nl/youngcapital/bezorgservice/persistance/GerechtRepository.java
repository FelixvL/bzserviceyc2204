/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import nl.youngcapital.bezorgservice.domein.Gerecht;

/**
 *
 * @author Gebruiker
 */
@Component
public interface GerechtRepository extends CrudRepository<Gerecht, Long> {
    
}
