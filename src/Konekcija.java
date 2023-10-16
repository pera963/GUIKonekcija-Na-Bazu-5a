import java.sql.Connection;
import java.sql.DriverManager;



public class Konekcija {
	
		public static Connection otvoriKonekciju() {
			Connection con= null;
			try {
				//provera drivera da li postoji, tj. vezivanje
				Class.forName("com.mysql.jdbc.Driver");
				//promenjivu con vezujemo za bazu podataka, i otvaramo konekciju
				//to je adresa moje baze 
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/guibaza3", "root", "");
	                  // guibaza2 ,to se jedino menja kao naziv baze
			} catch (Exception e) {
				System.out.println("desila se greska");// desila se greška ako ne može da se poveže na bazu
			}

			return con;

		}

	}


