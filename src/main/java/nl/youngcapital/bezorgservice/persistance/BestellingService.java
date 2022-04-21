/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.persistance;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yifongau
 */

@Service
public class BestellingService {
    
    @Autowired
    BestellingRepository bestellingRepository;
    
    public void opslaanBestelling(Bestelling b) {
        bestellingRepository.save(b);
    }
    
    public Iterable<Bestelling> geefBestellingen(){
        return bestellingRepository.findAll();
}
    public Bestelling vindBestellingById(long bid){
        Bestelling gevonden = bestellingRepository.findById(bid).get();
        return gevonden;
    }
}
