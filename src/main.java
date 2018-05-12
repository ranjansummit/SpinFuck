import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class main {

	private JFrame frame;
	private JTextField country;
	private JTextField division;
	private JTextField dob;
	private JTextField pob;
	private JTextField name;
	private JTextField homeTown;
	private JTextField practice;
	private JTextField dateOfFirstFight;
	private JTextField totalEvents;
	private JTextField wins;
	private JTextField losses;
	private JTextField ufcJoined;
	private JTextField rank;
	private JTextField rankP2P;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 483, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSpin = new JLabel("Spin Fuck");
		lblSpin.setBounds(122, 0, 191, 42);
		lblSpin.setFont(new Font("Serif", Font.BOLD, 39));
		lblSpin.setForeground(Color.PINK);
		frame.getContentPane().add(lblSpin);
	
		
		JLabel label = new JLabel("");
		label.setBounds(0, 188, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblFillInAnd = new JLabel("Synopsis");
		lblFillInAnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFillInAnd.setBounds(0, 179, 86, 20);
		frame.getContentPane().add(lblFillInAnd);
		
		JLabel lblDateOfBirth = new JLabel("Nationality");
		lblDateOfBirth.setBounds(3, 237, 73, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		country = new JTextField();
		country.setBounds(131, 234, 86, 20);
		frame.getContentPane().add(country);
		country.setColumns(10);
		
		JLabel lblAdressOfBirth = new JLabel("Division");
		lblAdressOfBirth.setBounds(3, 282, 96, 14);
		frame.getContentPane().add(lblAdressOfBirth);
		
		division = new JTextField();
		division.setColumns(10);
		division.setBounds(131, 279, 86, 20);
		frame.getContentPane().add(division);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth");
		lblDateOfBirth_1.setBounds(3, 322, 118, 14);
		frame.getContentPane().add(lblDateOfBirth_1);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(131, 319, 86, 20);
		frame.getContentPane().add(dob);
		
		JLabel lblPlaceOfBirth = new JLabel("Place of Birth");
		lblPlaceOfBirth.setBounds(3, 351, 96, 14);
		frame.getContentPane().add(lblPlaceOfBirth);
		
		pob = new JTextField();
		pob.setColumns(10);
		pob.setBounds(131, 348, 201, 20);
		frame.getContentPane().add(pob);
		
		JButton btnOk = new JButton("Get Synopsis");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Path path = Paths.get("D:/"+name.getText()+"bio.txt");

				if (Files.exists(path)) {
				  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
				}
				else{
				StringBuilder sentence=null;
//				OutputTab bio=new OutputTab();
				Connection connect;
				connect=DatabaseConnection.checkConnection();
				String sd = "SELECT * FROM data";
				ResultSet rst=null;
				ArrayList<String> prevalue = new ArrayList<String>();
				ArrayList<String> postvalue = new ArrayList<String>();
				
				try{
					Statement st = connect.createStatement();
					
				rst=st.executeQuery(sd);
				
				while(rst.next()){
				
				prevalue.add(rst.getString("PreText"));
				postvalue.add(rst.getString("PostText"));
				}
				connect.close();
				}
					catch(Exception ex){
						ex.printStackTrace();
					}
				
	String  sentence1 = makeClause(prevalue.get(0),name.getText(),postvalue.get(0) );
				String sentence2 = makeClause(prevalue.get(1),country.getText(),postvalue.get(1) );
				String sentence3 = makeClause(prevalue.get(2),division.getText(),postvalue.get(2) );
				String	sentence4 ="Mr. "+name.getText()+ makeClause(prevalue.get(3),dob.getText(),postvalue.get(3)+pob.getText() );
				String sentence5 = makeClause(prevalue.get(4),homeTown.getText(),postvalue.get(4) );
				String sentence6 = makeClause(prevalue.get(5),practice.getText(),postvalue.get(5) );
				String sentence7 = makeClause(prevalue.get(6),dateOfFirstFight.getText(),postvalue.get(6) );
				String sentence8 = makeClause(prevalue.get(7),totalEvents.getText(),postvalue.get(7) );
				String	sentence9 = makeClause(prevalue.get(8),wins.getText(),postvalue.get(8) );
				String sentence10 = makeClause(prevalue.get(9),losses.getText(),postvalue.get(9) );
				String	sentence11 = makeClause(prevalue.get(10),division.getText(),postvalue.get(10) );
				String	sentence12 = makeClause(prevalue.get(11),ufcJoined.getText(),postvalue.get(11) );
				String	sentence13 = makeClause(prevalue.get(12),division.getText(),postvalue.get(12) );
				String sentence14 = makeClause(prevalue.get(13),rank.getText(),postvalue.get(13) );
				String sentence15 = makeClause(prevalue.get(14),rankP2P.getText(),postvalue.get(14) );
			String complete = sentence1+sentence2+sentence3+sentence4+sentence5+sentence6+sentence7+sentence8+sentence9+sentence10+sentence11+sentence12+sentence13+sentence14+sentence15;
				
			   try {
		            //Whatever the file path is.
		            File statText = new File(path.toString());
		            FileOutputStream is = new FileOutputStream(statText);
		            OutputStreamWriter osw = new OutputStreamWriter(is);    
		            Writer w = new BufferedWriter(osw);
		            w.write(complete);
		            w.close();
		            JOptionPane.showMessageDialog(frame, "Fucking Great Man! You Have succesfuly created SpinFucked File");
		        } catch (IOException ioe) {
		            System.err.println("Problem writing to the file statsTest.txt");
		        }
				
			
				}
			
			}
		});
			
	
		btnOk.setBounds(335, 597, 122, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(3, 206, 83, 14);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(131, 203, 170, 20);
		frame.getContentPane().add(name);
		
		JLabel lblHometown = new JLabel("HomeTown");
		lblHometown.setBounds(3, 376, 73, 14);
		frame.getContentPane().add(lblHometown);
		
		homeTown = new JTextField();
		homeTown.setColumns(10);
		homeTown.setBounds(131, 373, 201, 20);
		frame.getContentPane().add(homeTown);
		
		JLabel lblPractise = new JLabel("Practice");
		lblPractise.setBounds(3, 401, 73, 14);
		frame.getContentPane().add(lblPractise);
		
		practice = new JTextField();
		practice.setColumns(10);
		practice.setBounds(121, 398, 336, 20);
		frame.getContentPane().add(practice);
		
		JLabel lblDateOfCarrer = new JLabel("Date of 1st fight");
		lblDateOfCarrer.setBounds(0, 426, 122, 14);
		frame.getContentPane().add(lblDateOfCarrer);
		
		dateOfFirstFight = new JTextField();
		dateOfFirstFight.setColumns(10);
		dateOfFirstFight.setBounds(127, 423, 86, 20);
		frame.getContentPane().add(dateOfFirstFight);
		
		JLabel lblTotalEvents = new JLabel("Total Events");
		lblTotalEvents.setBounds(0, 451, 73, 14);
		frame.getContentPane().add(lblTotalEvents);
		
		totalEvents = new JTextField();
		totalEvents.setColumns(10);
		totalEvents.setBounds(127, 445, 86, 20);
		frame.getContentPane().add(totalEvents);
		
		JLabel lblTotalWins = new JLabel("Total Wins");
		lblTotalWins.setBounds(3, 476, 73, 14);
		frame.getContentPane().add(lblTotalWins);
		
		wins = new JTextField();
		wins.setColumns(10);
		wins.setBounds(127, 470, 86, 20);
		frame.getContentPane().add(wins);
		
		JLabel lblTotalLosses = new JLabel("Total Losses");
		lblTotalLosses.setBounds(3, 492, 73, 14);
		frame.getContentPane().add(lblTotalLosses);
		
		losses = new JTextField();
		losses.setColumns(10);
		losses.setBounds(127, 489, 86, 20);
		frame.getContentPane().add(losses);
		
		JLabel lblUfcJoined = new JLabel("UFC Joined");
		lblUfcJoined.setBounds(3, 517, 73, 14);
		frame.getContentPane().add(lblUfcJoined);
		
		ufcJoined = new JTextField();
		ufcJoined.setColumns(10);
		ufcJoined.setBounds(127, 511, 86, 20);
		frame.getContentPane().add(ufcJoined);
		
		JLabel lblRank = new JLabel("Rank in Division");
		lblRank.setBounds(3, 533, 114, 14);
		frame.getContentPane().add(lblRank);
		
		rank = new JTextField();
		rank.setColumns(10);
		rank.setBounds(127, 530, 86, 20);
		frame.getContentPane().add(rank);
		
		JLabel lblRankInPp = new JLabel("Rank in P2P");
		lblRankInPp.setBounds(3, 558, 114, 14);
		frame.getContentPane().add(lblRankInPp);
		
		rankP2P = new JTextField();
		rankP2P.setColumns(10);
		rankP2P.setBounds(127, 555, 86, 20);
		frame.getContentPane().add(rankP2P);
		
		JLabel lblPressButtonTo = new JLabel("Press Button To Go to :-");
		lblPressButtonTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressButtonTo.setBounds(10, 600, 151, 20);
		frame.getContentPane().add(lblPressButtonTo);
		
		JButton btnNewButton = new JButton("Net Worth");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			NetWorth Ns=new NetWorth();
			}
		});
		btnNewButton.setBounds(3, 624, 99, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPersonalLife = new JButton("Personal Life");
		btnPersonalLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PersonalLife ps=new PersonalLife();
			}
		});
		btnPersonalLife.setBounds(109, 624, 122, 23);
		frame.getContentPane().add(btnPersonalLife);
		
		JButton btnEarlyLife = new JButton("Early Life");
		btnEarlyLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			EarlyLife earlife=new EarlyLife();
			}
		});
		btnEarlyLife.setBounds(241, 624, 89, 23);
		
		
		frame.getContentPane().add(btnEarlyLife);
		
		JButton btnMmaCarrer = new JButton("MMA Career");
		btnMmaCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Career cr = new Career();
			}
		});
		btnMmaCarrer.setBounds(345, 624, 109, 23);
		frame.getContentPane().add(btnMmaCarrer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/3.png")));
		lblNewLabel.setBounds(173, 40, 140, 100);
		frame.getContentPane().add(lblNewLabel);
	}
public  String makeClause(String first,String middle,String last){
	
	
	if (middle.equals(null)|| middle.equals(""))
	{
		return "*******#######";
	}		
	else{
		String combined;
		combined= first+middle+last;
		return combined;}
	}
}
