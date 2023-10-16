import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JList;

public class DrugiProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JList <MKKlub> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugiProzor frame = new DrugiProzor();
					frame.setVisible(true);				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DrugiProzor() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list =new JList(); //ovde pravimo novu listu ali praznu
		list.setBounds(10, 0, 414, 250);
		contentPane.add(list);
		
		popuniPodatkeIzBaze();
	}
public void popuniPodatkeIzBaze() throws SQLException {
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from klijent3");
		
		//uzimamo podatke iz baze i punimo promenjivu tipa ResultSet koja sluzi za cuvanje podataka iz baze
		ResultSet rs=ps.executeQuery();//rs je objekat tipa ResultSet,ili promenjiva,objekat je u stvari promenjiva.
		//executeQuery()to je metoda zaèi:  izvrsi tu komandu
			
		//ovo se koristi kada zelimo da napunimo Jlistu, punimo prvo ovaj model pa iz ovog modela punimo listu
		DefaultListModel<MKKlub> listModel1 = new DefaultListModel<MKKlub>();
		//DefaultListModel to je Javina  clasa koja služi da napunimo JListu sa podacima
		
		//iz result seta vadimo jedan podataka po jedan, dok ih ima u bazi
		while (rs.next()) {			
			//uzimamo podatke, 1 kolona je id, 2 kolona je ime....
		int id=rs.getInt(1);
		String imeKluba=rs.getString(2);
		String adresaKluba=rs.getString(3);
		int brMacevaoca=rs.getInt(4);
		
		
		//od tih podataka pravimo objekat klijent KL, i njega dodajemo na onaj default model gore
		MKKlub kl=new MKKlub(id, imeKluba, adresaKluba, brMacevaoca);
		listModel1.addElement(kl);//addElement() to je metoda koja dodaje klijenta u DefaultListModel Listu
						
		}
		
		
		
		//Na kraju postavljamo podatke iz Default list modela u JLISTU koja te podatke prikazuje
		list.setModel(listModel1);
	}



}
