import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUIKonekcijaNaBazu4 extends JFrame {

	private JPanel contentPane;
	private JTextField textImeKluba;
	private JTextField textAdresaKluba;
	private JTextField textBrojMacevaoca;
	private JButton btnDrugiProzor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKonekcijaNaBazu4 frame = new GUIKonekcijaNaBazu4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIKonekcijaNaBazu4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textImeKluba = new JTextField();
		textImeKluba.setBounds(10, 31, 195, 20);
		contentPane.add(textImeKluba);
		textImeKluba.setColumns(10);
		
		JLabel lblImeKluba = new JLabel("IME  KLUBA");
		lblImeKluba.setBounds(10, 11, 139, 14);
		contentPane.add(lblImeKluba);
		
		JLabel lblAdresaKluba = new JLabel("ADRESA  KLUBA");
		lblAdresaKluba.setBounds(10, 77, 195, 14);
		contentPane.add(lblAdresaKluba);
		
		textAdresaKluba = new JTextField();
		textAdresaKluba.setBounds(10, 102, 195, 20);
		contentPane.add(textAdresaKluba);
		textAdresaKluba.setColumns(10);
		
		JLabel lblBrojMacevaoca = new JLabel("BROJ  MACEVAOCA");
		lblBrojMacevaoca.setBounds(10, 150, 195, 14);
		contentPane.add(lblBrojMacevaoca);
		
		textBrojMacevaoca = new JTextField();
		textBrojMacevaoca.setBounds(10, 175, 195, 20);
		contentPane.add(textBrojMacevaoca);
		textBrojMacevaoca.setColumns(10);
		
		JButton btnDUGME = new JButton("UNOS  U  BAZU");
		btnDUGME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// odavde mi pišemo	
					Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa naša i mi dajemo Objekat (promenjiva)na klasu kon.
					Connection con=kon.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into klijent3(Ime_Kluba,Adresa_Kluba,Br_Mačevaoca) values(?,?,?)");
					ps.setString(1, textImeKluba.getText());
					ps.setString(2, textAdresaKluba.getText());
					ps.setString(3, textBrojMacevaoca.getText());
					
					
					ps.executeUpdate();//za уметање, ажурирање и брисање редова у тим табеламаi vraća ćelobrojnu vrednost tj. br redova 
					
					textImeKluba.setText("");
					textAdresaKluba.setText("");
					textBrojMacevaoca.setText("");
					
					
					JOptionPane.showMessageDialog(null, "uspesno dodato u bazu ");//dugme
					// dovde smo pisali
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								
						
			}
		});
		btnDUGME.setBounds(23, 227, 162, 23);
		contentPane.add(btnDUGME);
		
		btnDrugiProzor = new JButton("PREGLED POSTOJEĆIH");
		btnDrugiProzor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrugiProzor dd = null;
				try {
					dd = new DrugiProzor();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dd.setVisible(true);
						
			}
			
		});
		btnDrugiProzor.setBounds(252, 101, 162, 67);
		contentPane.add(btnDrugiProzor);
	}
}
