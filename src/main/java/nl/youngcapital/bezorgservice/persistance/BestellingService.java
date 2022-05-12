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
import nl.youngcapital.bezorgservice.domein.ResultDto;
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
    
    @Autowired
    BezorgerRepository bzr;
   
    
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
    
     public Iterable<Bestelling> geefBestellingVanRestaurant(long id)
    {
        Restaurant r = rr.findById(id).get();
        Iterable<Bestelling> gevonden = br.findByRestaurantAndStatusIsNot(r, 3);
        return gevonden;
    }
     public Iterable<Bestelling> geefBestellingVanBezorger(long id)
     {
         Bezorger b = bzr.findById(id).get();
         Iterable<Bestelling> gevonden = br.findByBezorgerAndStatusIsNot(b, 3);
         return gevonden;
     }
    
    public void voegGerechtToe(long bid, long gid)
    {
        Bestelling tmpb = vindBestellingById(bid);
        Gerecht tmpg = gr.findById(gid).get();
        tmpb.addGerecht(tmpg);
        br.save(tmpb);
    }
    
    public ResultDto setStatus(int status, long bid)
    {
        Bestelling tmpb = vindBestellingById(bid);
        int bestelstatus = tmpb.getStatus();
        ResultDto res = new ResultDto();
        if (status == 1)
        {
            if (bestelstatus >=1)
            {
                res.setResult(false);
            }
            else
            {
                tmpb.setStatus(status);
                br.save(tmpb);
                res.setResult(true);
            }
        }
        else if (status == 2)
        {
            if (bestelstatus >=2)
            {
                res.setResult(false);
            }
            else
            {
                tmpb.setStatus(status);
                br.save(tmpb);
                res.setResult(true);
            }
            
        }
        else if (status == 3)
        {
            if (bestelstatus >=4)
            {
                res.setResult(false);
                
            }
            else
            {
                tmpb.setStatus(status);
                br.save(tmpb);
                res.setResult(true);
            }
            
        }
        else if (status == 4)
        {
            if (bestelstatus >=1)
            {
                res.setResult(false);;
            }
            else
            {
                tmpb.setStatus(status);
                br.save(tmpb);
                res.setResult(true);
            }
        }
                
        else
        {
            res.setResult(false);
        }
        return res;
    }
    
    public void addBezorgerToBestelling(long bid, long zid)
    {
        Bezorger tmpBz = bzr.findById(zid).get();
        Bestelling tmpb = vindBestellingById(bid);
        tmpb.addbezorger(tmpBz);
        br.save(tmpb);
    }
    
    public void removeBestelling(long bid)
    {
        br.deleteById(bid);
    }
    
}
