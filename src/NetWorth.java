import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NetWorth {

	private JFrame frame;
	private JTextField perFightField;
	private JTextField dateofLastfight;
	private JTextField name;
	private JTextField homeTown;
	private JTextField carField;
	private JTextField totalNetWorth;
	private JTextField opponentName;

	public NetWorth() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 469);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblSpin = new JLabel("Spin Fuck");
		lblSpin.setBounds(122, 0, 191, 42);
		lblSpin.setFont(new Font("Serif", Font.BOLD, 39));
		lblSpin.setForeground(Color.PINK);
		frame.getContentPane().add(lblSpin);
		
		JLabel lblFillInAnd = new JLabel("NetWorth");
		lblFillInAnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFillInAnd.setBounds(0, 179, 86, 20);
		frame.getContentPane().add(lblFillInAnd);
		
		JLabel perFight = new JLabel("Last Fight Collection");
		perFight.setBounds(0, 233, 118, 14);
		frame.getContentPane().add(perFight);
		
		perFightField = new JTextField();
		perFightField.setBounds(131, 230, 86, 20);
		frame.getContentPane().add(perFightField);
		perFightField.setColumns(10);
		
		JLabel lblAdressOfBirth = new JLabel("Total NetWorth");
		lblAdressOfBirth.setBounds(0, 294, 96, 14);
		frame.getContentPane().add(lblAdressOfBirth);
		
		dateofLastfight = new JTextField();
		dateofLastfight.setColumns(10);
		dateofLastfight.setBounds(310, 255, 86, 20);
		frame.getContentPane().add(dateofLastfight);
		
		JButton btnOk = new JButton("Get NetWorth");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Path path = Paths.get("D:/"+name.getText()+"netWorth.txt");

				if (Files.exists(path)) {
				  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
				}
				else{
				StringBuilder sentence=null;
//				OutputTab bio=new OutputTab();
				Connection connect;
				connect=DatabaseConnection.checkConnection();
				String sd = "SELECT * FROM networth";
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
				String sentence2 = makeClause(prevalue.get(1),perFightField.getText(),postvalue.get(1) );
				String sentence3 = makeClause(prevalue.get(2),dateofLastfight.getText(),postvalue.get(2) );
				String	sentence4 = makeClause(prevalue.get(3),opponentName.getText(),postvalue.get(3));
				String sentence5 = makeClause(prevalue.get(4),totalNetWorth.getText(),postvalue.get(4) );
				String sentence6 = makeClause(prevalue.get(7),homeTown.getText(),postvalue.get(7) );
//				String sentence7 = makeClause(prevalue.get(6),homeWorthField.getText(),postvalue.get(6) );
//				String sentence8 = makeClause(prevalue.get(7),homeWorthdateField.getText(),postvalue.get(7) );
				String	sentence9 = makeClause(prevalue.get(10),carField.getText(),postvalue.get(10) );
//				String sentence10 = makeClause(prevalue.get(9),carWorthField.getText(),postvalue.get(9) );
             	String complete = sentence1+sentence2+sentence3+sentence4+sentence5+sentence6+sentence9;/*+sentence8+sentence9+sentence10;*/
				
			   try {

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
		btnOk.setBounds(238, 367, 122, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(3, 206, 73, 14);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(131, 203, 170, 20);
		frame.getContentPane().add(name);
		
		JLabel lblHometown = new JLabel("HomeTown");
		lblHometown.setBounds(3, 319, 73, 14);
		frame.getContentPane().add(lblHometown);
		
		homeTown = new JTextField();
		homeTown.setColumns(10);
		homeTown.setBounds(129, 316, 201, 20);
		frame.getContentPane().add(homeTown);
		
		JLabel car = new JLabel("Car");
		car.setBounds(3, 343, 73, 14);
		frame.getContentPane().add(car);
		
		carField = new JTextField();
		carField.setColumns(10);
		carField.setBounds(131, 340, 86, 20);
		frame.getContentPane().add(carField);
		
		JLabel lblPressButtonTo = new JLabel("Press Button To Go to :-");
		lblPressButtonTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressButtonTo.setBounds(10, 368, 151, 20);
		frame.getContentPane().add(lblPressButtonTo);
		
		JButton btnPersonalLife = new JButton("Personal Life");
		btnPersonalLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalLife chikaichadai = new PersonalLife();
			}
		});
		btnPersonalLife.setBounds(13, 399, 122, 23);
		frame.getContentPane().add(btnPersonalLife);
		
		JButton btnEarlyLife = new JButton("Early Life");
		btnEarlyLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EarlyLife es= new EarlyLife();
			}
		});
		btnEarlyLife.setBounds(160, 399, 89, 23);
		frame.getContentPane().add(btnEarlyLife);
		
		JButton btnMmaCarrer = new JButton("MMA Carrer");
		btnMmaCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Career cs=new Career();
			}
		});
		btnMmaCarrer.setBounds(259, 399, 109, 23);
		frame.getContentPane().add(btnMmaCarrer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/3.png")));
		lblNewLabel.setBounds(173, 40, 140, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(0, 258, 73, 14);
		frame.getContentPane().add(lblDate);
		
		totalNetWorth = new JTextField();
		totalNetWorth.setColumns(10);
		totalNetWorth.setBounds(131, 288, 86, 20);
		frame.getContentPane().add(totalNetWorth);
		
		JLabel lblOpponentName = new JLabel("Opponent Name");
		lblOpponentName.setBounds(218, 263, 95, 14);
		frame.getContentPane().add(lblOpponentName);
		
		opponentName = new JTextField();
		opponentName.setColumns(10);
		opponentName.setBounds(108, 255, 109, 20);
		frame.getContentPane().add(opponentName);
	}
	public  String makeClause(String first,String middle,String last){
		
		
		String combined;
		combined= first+middle+last;
		return combined;

	}
	
	
}
