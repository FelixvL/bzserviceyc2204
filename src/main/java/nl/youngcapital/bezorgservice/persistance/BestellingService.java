/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.persistance;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.domein.Klant;
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
    
    @Autowired
    KlantRepository ks;
    
    public void opslaanBestelling(Bestelling b, long klantid) 
    {
        Bestelling tmpBestelling = bestellingRepository.save(b);
        Klant tmpKlant = geefKlant(klantid);
        tmpBestelling.setKlant(tmpKlant);
        
        bestellingRepository.save(tmpBestelling);
    }
    
    public Klant geefKlant(long id)
    {
        Klant klant = ks.findById(id).get();
        return klant;
    }
    
    public Iterable<Bestelling> geefBestellingen(){
        return bestellingRepository.findAll();
}
    public Bestelling vindBestellingById(long bid){
        Bestelling gevonden = bestellingRepository.findById(bid).get();
        return gevonden;
    }
    
    
}
