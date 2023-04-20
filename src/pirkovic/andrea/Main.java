package pirkovic.andrea;// klase koje se koriste da omoguce serijalizaciju/deserijalizaciju objekata:
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Main {

	public static void main(String[] args) {
		
		/*Zadatak:potrebno kreirati projekat, gde će na primeru biti prikazan postupak 
		serijalizacije i deserijalizacije objekta. Koristeći komentare u programskom kodu, odgovorićete na sledeća pitanja:  
			- Zbog čega se radi serijalizacija i deserijalizacija objekta?  
			- Koje klase omogućuju serijalizaciju i deserijalizaciju objekata?  
			- Interfejs Serializable – objasniti i implementirati.  
			- Podatak serialVersionID objasniti i implementirati.  
			- Kreiranje fajla korišćenjem serijalizacije objekta.*/
		 
		 	 
		  Student s1 = new Student(); //Kreiranje objekta
		  s1.setIndeksId(25);
		  s1.setIme("Ana");
		  
		//Serijalizacija: Koristi se kada se pojavi potreba za slanjem objekata preko mreže ili za njihovim skladištenjem u fajlovima. 
		  //objekat može biti serijalizovan na jednoj platformi i deserijalizovan na potpuno drugoj platformi.
		  //Serializacija je prevođenje vrednosti/stanja Java objekta u bajtove kako bi ih poslali preko mreže ili sačuvali. 
		  try
		  {
		   FileOutputStream fileOut = new FileOutputStream("C:\\Users\\pirko\\Desktop\\Studenti.txt"); // kreira se output stream
		   ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
		   outStream.writeObject(s1); // prosledjuje se objekat koji treba da se serijalizuje i upisuje se u fajl
		   outStream.close();
		   fileOut.close();
		  }catch(IOException i)
		  {
		   i.printStackTrace();
		  }
		 
		  //Deserijalizacija: konverzija bajtova u odgovarajući java objekat.
		  s1 = null;
		  try
		  {
		   FileInputStream fileIn =new FileInputStream("C:\\Users\\pirko\\Desktop\\Studenti.txt");
		   ObjectInputStream in = new ObjectInputStream(fileIn); // kreira se input stream
		   try {
			s1 = (Student) in.readObject(); // poziva se readObject metod za kreirani objekat klase Student
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		   in.close();
		   fileIn.close();
		  }catch(IOException i)
		  {
		   i.printStackTrace();
		   return;
		  }
		  System.out.println(" Student:");
		  System.out.println(" Broj indeksa: " + s1.getIndeksId());
		  System.out.println("Ime: " + s1.getIme());
		  
		 }
		}
//ObjectOutputStream upisuje svaki put objekat u izlazni tok, 
//a ObjectInputStream ga čita nazad i ako nema iste vrednosti SerialVersionId kao u trenutnoj verziji klase onda izbacuje InvalidClassException.
