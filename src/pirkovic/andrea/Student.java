package pirkovic.andrea;
import java.io.Serializable;
public class Student implements Serializable{ // Da bi se izvrsila serijalizacija, mora se implementirati interfejs Serializable. On spada u Javine marker Interfejse 
	// i nema metode ni polja

	private static final long serialVersionUID = 2L;
	//serialVersionUID se koristi da osigura da se isti objekat (koji je korišćen tokom serijalizacije) učita tokom deserijalizacije.
	//serialVersionUID se koristi za kontrolu verzija objekta.
	//Primer:Moguće je npr da smo serijalizovali objekat u datoteci i da smo ga deserijalizovali nakon nekog perioda na drugom sistemu. 
	//Između serijalizacije i deserijalizacije deklaracija klase može biti promenjena. 
	//SerialVersionId služi da proveri da li deserijalizujemo istu verziju objekta koju smo serijalizovali.
	
	    int indeksId;
	    String ime;
		public Student() {
			
		}
		public int getIndeksId() {
			return indeksId;
		}
		public void setIndeksId(int indeksId) {
			this.indeksId = indeksId;
		}
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
	    
	 
}