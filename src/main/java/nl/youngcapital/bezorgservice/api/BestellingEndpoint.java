/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nl.youngcapital.bezorgservice.api;

import nl.youngcapital.bezorgservice.domein.Bestelling;
import nl.youngcapital.bezorgservice.persistance.BestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yifongau
 */

@RestController
public class BestellingEndpoint {
    
    @Autowired
    BestellingService bestellingService;
            
    @PostMapping("/nieuwebestelling")
        public void voegbestellingtoe(@RequestBody Bestelling b){
            bestellingService.opslaanBestelling(b);
        }
    @GetMapping("/geefallebestellingen")
            public Iterable GeefAlleBestellingen(){
                return bestellingService.geefBestellingen();
            }
            
    @GetMapping("/geefbestelling/{bid}")
    public Bestelling bestellingbyid(@PathVariable("bid") int bezorgerid) {
        return bestellingService.vindBestellingById(bezorgerid);
    }
    
    //@PostMapping("/")
}