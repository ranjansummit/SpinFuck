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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EarlyLife {


	private JFrame frame;
	private JTextField homeTown;
	private JTextField name;
	private JTextField tf_education;
	private JTextField desent;
	private JTextField nationality;
	private JTextField tf_institute;
	private JTextField twitterFollowers;
	private JTextField instraGram;
	ButtonGroup rdbtnNewRadioButton;
	ButtonGroup groupRadioButton;
	JButton btnOk;
	private JTextField tf_reason;
	/**
	 * Create the application.
	 */
	public EarlyLife() {
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
		frame.setBounds(100, 100, 418, 507);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblSpin = new JLabel("Spin Fuck");
		lblSpin.setBounds(122, 0, 191, 42);
		lblSpin.setFont(new Font("Serif", Font.BOLD, 39));
		lblSpin.setForeground(Color.PINK);
		frame.getContentPane().add(lblSpin);
		
		JLabel lblFillInAnd = new JLabel("EarlyLife");
		lblFillInAnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFillInAnd.setBounds(10, 114, 122, 20);
		frame.getContentPane().add(lblFillInAnd);
		
		JLabel perFight = new JLabel("HomeTown");
		perFight.setBounds(0, 162, 73, 14);
		frame.getContentPane().add(perFight);
		
		homeTown = new JTextField();
		homeTown.setBounds(139, 159, 151, 20);
		frame.getContentPane().add(homeTown);
		homeTown.setColumns(10);
		
	 btnOk = new JButton("Get Early Life");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
				Path path = Paths.get("D:/"+name.getText()+"Group"+groupRadioButton.getSelection().getActionCommand()+"earlyLife.txt");

				if (Files.exists(path)) {
				  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
				}
				else{
				StringBuilder sentence=null;
				Connection connect;
				connect=DatabaseConnection.checkConnection();
				String sd = "SELECT * FROM earlylife WHERE sample=?";
				
				ResultSet rst=null;
				ArrayList<String> prevalue = new ArrayList<String>();
				ArrayList<String> postvalue = new ArrayList<String>();
				
				try{
					
				PreparedStatement preparedstatement = connect.prepareStatement(sd);
				preparedstatement.setString(1, groupRadioButton.getSelection().getActionCommand());
     rst=preparedstatement.executeQuery();
				
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
				String sentence2 = makeClause(prevalue.get(1),homeTown.getText(),postvalue.get(1) );
		         String sentence3=makeClause(prevalue.get(2),tf_reason.getText(),postvalue.get(2));
		         String sentence4=makeClauseEducation(prevalue.get(7),postvalue.get(7),prevalue.get(8),tf_education.getText(),tf_institute.getText());
//				String sentence3 = makeClause(prevalue.get(2),sonRank.getText(),postvalue.get(2) );
//				String sentence4 = makeClause(prevalue.get(3),fatherName.getText(),postvalue.get(3) );
//				String sentence5 = makeClause(prevalue.get(4),MotherName.getText(),postvalue.get(4) );
//				String sentence6 = makeClause(prevalue.get(5),events.getText(),postvalue.get(5) );
//				String sentence7 = makeClause(prevalue.get(6),siblingNo.getText(),postvalue.get(6) );
//				String sentence5 = makeClause(prevalue.get(7),tf_institute.getText(),postvalue.get(7) );
				String sentence6 = makeClause(prevalue.get(12),nationality.getText(),postvalue.get(12) );
				String sentence7 = makeClause(prevalue.get(13),desent.getText(),postvalue.get(13) );		

//				String sentence9 = makeClause(prevalue.get(8),tf_education.getText(),postvalue.get(8) );		
//			String	sentence10 = makeClause(prevalue.get(9),degreeYear.getText(),postvalue.get(9) );
//			String sentence11= makeClause(prevalue.get(10),events.getText(),postvalue.get(10));
//	String	sentence12 = makeClause(prevalue.get(11),desent.getText(),postvalue.get(11) );
		
		String sentence14 = makeClause(prevalue.get(14),twitterFollowers.getText(),postvalue.get(14) );
		String sentence15 = makeClause(prevalue.get(15),instraGram.getText(),postvalue.get(15) );
        String complete = sentence1+sentence2+sentence3+sentence4+sentence6+sentence7+sentence14+sentence15;
//  String complete=sentence1;
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
		btnOk.setBounds(0, 389, 122, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(3, 138, 73, 14);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(139, 135, 170, 20);
		frame.getContentPane().add(name);
		
		JLabel lblHometown = new JLabel("Academic Qualification");
		lblHometown.setBounds(0, 232, 123, 14);
		frame.getContentPane().add(lblHometown);
		
		tf_education = new JTextField();
		tf_education.setColumns(10);
		tf_education.setBounds(139, 226, 201, 20);
		frame.getContentPane().add(tf_education);
		
		JLabel dateHomeWorth = new JLabel("Descent");
		dateHomeWorth.setBounds(0, 312, 122, 14);
		frame.getContentPane().add(dateHomeWorth);
		
		JLabel car = new JLabel("Nationality");
		car.setBounds(0, 285, 132, 14);
		frame.getContentPane().add(car);
		
		desent = new JTextField();
		desent.setColumns(10);
		desent.setBounds(139, 309, 86, 20);
		frame.getContentPane().add(desent);
		
		JLabel lblTotalWins = new JLabel("Twitter Followers");
		lblTotalWins.setBounds(0, 350, 122, 14);
		frame.getContentPane().add(lblTotalWins);
		
		nationality = new JTextField();
		nationality.setColumns(10);
		nationality.setBounds(139, 282, 86, 20);
		frame.getContentPane().add(nationality);
		
		JLabel lblPressButtonTo = new JLabel("Press Button To Go to :-");
		lblPressButtonTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressButtonTo.setBounds(10, 415, 151, 20);
		frame.getContentPane().add(lblPressButtonTo);
		
		JButton btnPersonalLife = new JButton("NetWorth");
		btnPersonalLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetWorth networth = new NetWorth();
			}
		});
		btnPersonalLife.setBounds(-3, 446, 122, 23);
		frame.getContentPane().add(btnPersonalLife);
		
		JButton btnEarlyLife = new JButton("Personal Life");
		btnEarlyLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalLife personallife = new PersonalLife();
			}
		});
		btnEarlyLife.setBounds(137, 446, 109, 23);
		frame.getContentPane().add(btnEarlyLife);
		
		JButton btnMmaCarrer = new JButton("MMA Carrer");
		btnMmaCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Career career = new Career();
			}
		});
		btnMmaCarrer.setBounds(283, 446, 109, 23);
		frame.getContentPane().add(btnMmaCarrer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/3.png")));
		lblNewLabel.setBounds(159, 40, 140, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRelationshipStatus = new JLabel("Institute");
		lblRelationshipStatus.setBounds(3, 260, 93, 14);
		frame.getContentPane().add(lblRelationshipStatus);
		
		tf_institute = new JTextField();
		tf_institute.setColumns(10);
		tf_institute.setBounds(139, 257, 201, 20);
		frame.getContentPane().add(tf_institute);
		
		 rdbtnNewRadioButton = new ButtonGroup();
		
		twitterFollowers = new JTextField();
		twitterFollowers.setColumns(10);
		twitterFollowers.setBounds(139, 347, 86, 20);
		frame.getContentPane().add(twitterFollowers);
		
		JLabel lblInstagramFollower = new JLabel("InstaGram Followers");
		lblInstagramFollower.setBounds(0, 375, 132, 14);
		frame.getContentPane().add(lblInstagramFollower);
		
		instraGram = new JTextField();
		instraGram.setColumns(10);
		instraGram.setBounds(139, 369, 86, 20);
		frame.getContentPane().add(instraGram);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(251, 413, 42, 23);
		rdbtnA.setActionCommand("A");
		rdbtnA.setSelected(true);
		frame.getContentPane().add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(290, 413, 44, 23);
		rdbtnB.setActionCommand("B");
		frame.getContentPane().add(rdbtnB);
		
		JRadioButton rdbtnAb = new JRadioButton("AB");
		rdbtnAb.setBounds(337, 413, 55, 23);
		frame.getContentPane().add(rdbtnAb);
		groupRadioButton = new ButtonGroup();
		groupRadioButton.add(rdbtnA);
		groupRadioButton.add(rdbtnB);
		groupRadioButton.add(rdbtnAb);
		
		JLabel lblReasonForJoining = new JLabel("Reason For Joining");
		lblReasonForJoining.setBounds(0, 201, 119, 14);
		frame.getContentPane().add(lblReasonForJoining);
		
		tf_reason = new JTextField();
		tf_reason.setColumns(10);
		tf_reason.setBounds(139, 195, 253, 20);
		frame.getContentPane().add(tf_reason);
		
	}
	public  String makeClause(String first,String middle,String last){
	
		
		if (middle.equals(null)|| middle.equals(""))
		{
			return "";
		}		
		else{
			String combined;
			combined= first+middle+last;
			return combined;}
		}
	public String makeClauseEducation(String preUniversity,String postUniversity,String preEducation,String valueEducation,String valueUniversity)
	{ 
		String sentence="";
	 if(!(valueEducation.isEmpty()&&valueUniversity.isEmpty()))
	 {
		 if((!valueEducation.isEmpty())&&valueUniversity.isEmpty())
		 {
			 sentence= preUniversity+preEducation+valueEducation+". ";
			 
		 }
		 else if((valueEducation.isEmpty())&&(!valueUniversity.isEmpty()))
		 {
			 sentence=preUniversity+valueUniversity+" "+postUniversity+". ";
			 
		 }
		 
		 else{
			 sentence=preUniversity+valueUniversity+postUniversity+preEducation+valueEducation+". ";
			 
		 }
		 
		 
	 }
	 else{
		  sentence="Till date, Ufcninja has not found any strong details regarding his educational background. ";
	 }
	return sentence;	
	}	
}
