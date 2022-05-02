Als je gedurende het project meemaakt dat er een list van klanten een lijst van recepten  heeft
met daarin weer een lijst van klanten en zo voort, dan kan het zijn
dat je een JacksonException krijgt. Eigenlijk directe of indirecte recursie.

Kijk dan naar de annotatie: @JsonIgnoreProperties. Daarmee schakel je dan
bijvoorbeeld het renderen  van de klant zijn recepten in de lijst van recepten uit. Dus
daarmee voorkomen je dan indirecte recursie en foutmelding van Jackson 

Ander voorbeeld: Boek en Author. Boek heeft Author en Author heeft meerdere boeken. Dan zoiets

=> 


@Entity
public class Author {

	@OneToMany
	@JsonIgnoreProperties("author") // rendert niet opnieuw de author van het boek want die heb je hier al ... 
	private List<Book> boeken;

}



