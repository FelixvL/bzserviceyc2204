
package nl.youngcapital.bezorgservice.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klant 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String voornaam;
    String achternaam;
    String wachtwoord;
    String adress;
    String postcode;
    String email;
    
}
