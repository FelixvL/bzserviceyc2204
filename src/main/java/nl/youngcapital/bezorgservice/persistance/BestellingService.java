/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.persistance;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.domein.Bezorger;
import nl.youngcapital.bezorgservice.domein.Gerecht;
import nl.youngcapital.bezorgservice.domein.Klant;
import nl.youngcapital.bezorgservice.domein.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yifongau
 */

@Service
public class BestellingService {
    
    @Autowired
    BestellingRepository br;
    
    @Autowired
    KlantRepository kr;
    
    @Autowired
    GerechtRepository gr;
    
    @Autowired
    RestaurantRepository rr;
   
    
    // bestelling opslaan met klantid
    public void opslaanBestelling(Bestelling b, long klantid, long restaurantid) 
    {
        Bestelling tmpBestelling = br.save(b);
        Klant tmpKlant = geefKlant(klantid);
        Restaurant tmpRestaurant = geefRestaurant(restaurantid); 
        tmpBestelling.setKlant(tmpKlant);
        tmpBestelling.setRestaurant(tmpRestaurant);
        
        br.save(tmpBestelling);
    }
    
    
    // bestelling opslaan generiek
    public void opslaan(Bestelling b) {
		br.save(b);
	}
    
    public Klant geefKlant(long id)
    {
        Klant klant = kr.findById(id).get();
        return klant;
    }
    
    public Restaurant geefRestaurant(long id)
    {
        Restaurant res = rr.findById(id).get();
        return res;
    }
    
    public Iterable<Bestelling> geefBestellingen(){
        return br.findAll();
}
    public Bestelling vindBestellingById(long bid){
        Bestelling gevonden = br.findById(bid).get();
        return gevonden;
    }
    
    public Iterable<Bestelling> geefBestellingVanKlant(long id)
    {
        Klant k = kr.findById(id).get();
        Iterable<Bestelling> gevonden = br.findBestellingByKlant(k);
        return gevonden;
    }
    
    public void voegGerechtToe(long bid, long gid)
    {
        Bestelling tmpb = vindBestellingById(bid);
        Gerecht tmpg = gr.findById(gid).get();
        tmpb.addGerecht(tmpg);
        br.save(tmpb);
    }
    
}
