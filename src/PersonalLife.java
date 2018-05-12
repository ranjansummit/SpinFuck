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
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class PersonalLife {


	private JFrame frame;
	private JTextField exWife;
	private JTextField timeSpentEx;
	private JTextField name;
	private JTextField marriedDate;
	private JTextField kidsNoCurrentXamma;
	private JTextField playerHeight;
	private JTextField weightPlayer;
	private JTextField currentXammaLocation;
	private JTextField punchReach;
	private JTextField kickReach;
	ButtonGroup rdbtnNewRadioButton;
	ButtonGroup groupRadioButton;
	JRadioButton rdbtnGirlfriend;
	JRadioButton rdbtnWife;
	JTextArea xammaName;
	JButton btnOk;
	private JTextField petName;
	/**
	 * Create the application.
	 */
	public PersonalLife() {
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
		frame.setBounds(100, 100, 451, 490);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblSpin = new JLabel("Spin Fuck");
		lblSpin.setBounds(122, 0, 191, 42);
		lblSpin.setFont(new Font("Serif", Font.BOLD, 39));
		lblSpin.setForeground(Color.PINK);
		frame.getContentPane().add(lblSpin);
		
		JLabel lblFillInAnd = new JLabel("Personal Life");
		lblFillInAnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFillInAnd.setBounds(10, 114, 122, 20);
		frame.getContentPane().add(lblFillInAnd);
		
//		JLabel perFight = new JLabel("Ex Wife");
//		perFight.setBounds(0, 162, 73, 14);
//		frame.getContentPane().add(perFight);
//		
//		exWife = new JTextField();
//		exWife.setBounds(139, 162, 151, 20);
//		frame.getContentPane().add(exWife);
//		exWife.setColumns(10);
//		
//		JLabel lblAdressOfBirth = new JLabel("Time spent with ex wife");
//		lblAdressOfBirth.setBounds(0, 187, 139, 14);
//		frame.getContentPane().add(lblAdressOfBirth);
//		
//		timeSpentEx = new JTextField();
//		timeSpentEx.setColumns(10);
//		timeSpentEx.setBounds(149, 184, 86, 20);
//		frame.getContentPane().add(timeSpentEx);
		
//		JLabel mmaSalary = new JLabel("No. of Children with Ex");
//		mmaSalary.setBounds(0, 212, 132, 14);
//		frame.getContentPane().add(mmaSalary);
		
		JLabel lblPlaceOfBirth = new JLabel("Couples Home Location");
		lblPlaceOfBirth.setBounds(0, 192, 140, 14);
		frame.getContentPane().add(lblPlaceOfBirth);
		
	 btnOk = new JButton("Get PersonalLife");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
				Path path = Paths.get("D:/"+name.getText()+"Group"+groupRadioButton.getSelection().getActionCommand()+"personalLife.txt");

				if (Files.exists(path)) {
				  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
				}
				else{
				StringBuilder sentence=null;
				Connection connect;
				connect=DatabaseConnection.checkConnection();
				String sd = "SELECT * FROM personallife WHERE sample=?";
				
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
				
	String  sentence1 = makeMaritalStatusParagraph(rdbtnNewRadioButton.getSelection().getActionCommand());
	String sentence2=makeChildSentence(kidsNoCurrentXamma.getText());
	
//			makeClause(prevalue.get(0),name.getText(),postvalue.get(0) );
//				String sentence2 = makeClause(prevalue.get(1),exWife.getText(),postvalue.get(1) );
//				String sentence3 = makeClause(prevalue.get(2),timeSpentEx.getText(),postvalue.get(2) );
//				String sentence4 = makeClause(prevalue.get(3),exChildren.getText(),postvalue.get(3) );
//				String sentence5 = makeClause(prevalue.get(4),exKidName.getText(),postvalue.get(4) );
//				String sentence6 = makeClause(prevalue.get(5),currentXammaLocation.getText(),postvalue.get(5) );
//				String sentence7 = makeClause(prevalue.get(6),relationshipStatus.getText(),postvalue.get(6) );
//				String sentence8 = makeClause(prevalue.get(7), rdbtnNewRadioButton.getSelection().getActionCommand(),postvalue.get(7) );
//				String sentence9 = makeClause(prevalue.get(8),marriedDate.getText(),postvalue.get(8) );		
//			String	sentence10 = makeClause(prevalue.get(9),kidsNoCurrentXamma.getText(),postvalue.get(9) );
//			String	sentence11 = makeClause(prevalue.get(10),petName.getText(),postvalue.get(10) );
	String	sentence12 = makeClause(prevalue.get(11),playerHeight.getText(),postvalue.get(11) );
		String sentence13 = makeClause(prevalue.get(12),weightPlayer.getText(),postvalue.get(12) );
		String sentence14 = makeClause(prevalue.get(13),punchReach.getText(),postvalue.get(13) );
		String sentence15 = makeClause(prevalue.get(14),kickReach.getText(),postvalue.get(14) );
        String complete = sentence1+sentence2+sentence12+sentence13+sentence14+sentence15;
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
		btnOk.setBounds(0, 421, 132, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(3, 138, 73, 14);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(129, 135, 170, 20);
		frame.getContentPane().add(name);
		
//		JLabel lblHometown = new JLabel("Married Date");
//		lblHometown.setBounds(0, 331, 73, 14);
//		frame.getContentPane().add(lblHometown);
//		
//		marriedDate = new JTextField();
//		marriedDate.setColumns(10);
//		marriedDate.setBounds(122, 328, 201, 20);
//		frame.getContentPane().add(marriedDate);
		
//		JLabel homeWorth = new JLabel("Kids' No current wife");
//		homeWorth.setBounds(0, 356, 139, 14);
//		frame.getContentPane().add(homeWorth);
//		
		JLabel dateHomeWorth = new JLabel("Height of Player");
		dateHomeWorth.setBounds(0, 248, 122, 14);
		frame.getContentPane().add(dateHomeWorth);
		
		kidsNoCurrentXamma = new JTextField();
		kidsNoCurrentXamma.setColumns(10);
		kidsNoCurrentXamma.setBounds(149, 220, 86, 20);
		frame.getContentPane().add(kidsNoCurrentXamma);
		
		JLabel car = new JLabel("Weight Of the Player");
		car.setBounds(0, 273, 132, 14);
		frame.getContentPane().add(car);
		
		playerHeight = new JTextField();
		playerHeight.setColumns(10);
		playerHeight.setBounds(122, 245, 86, 20);
		frame.getContentPane().add(playerHeight);
		
		JLabel lblTotalWins = new JLabel("Punch Reach");
		lblTotalWins.setBounds(0, 298, 99, 14);
		frame.getContentPane().add(lblTotalWins);
		
		weightPlayer = new JTextField();
		weightPlayer.setColumns(10);
		weightPlayer.setBounds(149, 270, 86, 20);
		frame.getContentPane().add(weightPlayer);
		
		JLabel lblPressButtonTo = new JLabel("Press Button To Go to :-");
		lblPressButtonTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressButtonTo.setBounds(2, 357, 151, 20);
		frame.getContentPane().add(lblPressButtonTo);
		

		JButton btnPersonalLife = new JButton("NetWorth");
		btnPersonalLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetWorth cs=new NetWorth();
			}
		});
		btnPersonalLife.setBounds(0, 384, 99, 23);
		frame.getContentPane().add(btnPersonalLife);
		
		JButton btnEarlyLife = new JButton("Early Life");
		btnEarlyLife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EarlyLife es= new EarlyLife();
			}
		});
		btnEarlyLife.setBounds(109, 384, 89, 23);
		frame.getContentPane().add(btnEarlyLife);
		
		JButton btnMmaCarrer = new JButton("MMA Career");
		btnMmaCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Career career = new Career();
			}
		});
		btnMmaCarrer.setBounds(204, 384, 109, 23);
		frame.getContentPane().add(btnMmaCarrer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/3.png")));
		lblNewLabel.setBounds(159, 40, 140, 100);
		frame.getContentPane().add(lblNewLabel);
		
		currentXammaLocation = new JTextField();
		currentXammaLocation.setColumns(10);
		currentXammaLocation.setBounds(141, 189, 213, 20);
		frame.getContentPane().add(currentXammaLocation);
		
		JLabel lblMate = new JLabel("Marital Status:");
		lblMate.setBounds(3, 163, 86, 14);
	
		
		 rdbtnWife = new JRadioButton("Wife");
		 rdbtnWife.setActionCommand("Wife");
		rdbtnWife.setBounds(90, 162, 63, 23);
		frame.getContentPane().add(rdbtnWife);
		
		 rdbtnGirlfriend = new JRadioButton("Girlfriend");
		 rdbtnGirlfriend.setActionCommand("Girlfriend");
		rdbtnGirlfriend.setBounds(156, 162, 79, 23);
		frame.getContentPane().add(rdbtnGirlfriend);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setActionCommand("Single");
		rdbtnSingle.setBounds(231, 162, 68, 23);
		frame.getContentPane().add(rdbtnSingle);
		
		 rdbtnNewRadioButton = new ButtonGroup();
		rdbtnNewRadioButton.add(rdbtnWife);
		rdbtnNewRadioButton.add(rdbtnGirlfriend);
		rdbtnNewRadioButton.add(rdbtnSingle);
		frame.getContentPane().add(lblMate);
		
		punchReach = new JTextField();
		punchReach.setColumns(10);
		punchReach.setBounds(111, 295, 86, 20);
		frame.getContentPane().add(punchReach);
		
		JLabel label = new JLabel("Kick Reach");
		label.setBounds(0, 329, 73, 14);
		frame.getContentPane().add(label);
		
		kickReach = new JTextField();
		kickReach.setColumns(10);
		kickReach.setBounds(111, 326, 86, 20);
		frame.getContentPane().add(kickReach);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(271, 310, 42, 23);
		rdbtnA.setActionCommand("A");
		rdbtnA.setSelected(true);
		frame.getContentPane().add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(330, 310, 44, 23);
		rdbtnB.setActionCommand("B");
		frame.getContentPane().add(rdbtnB);
		
		JRadioButton rdbtnAb = new JRadioButton("AB");
		rdbtnAb.setBounds(376, 310, 55, 23);
		frame.getContentPane().add(rdbtnAb);
		groupRadioButton = new ButtonGroup();
		groupRadioButton.add(rdbtnA);
		groupRadioButton.add(rdbtnB);
		groupRadioButton.add(rdbtnAb);
		
		
		
		JLabel lblTotalNumberOf = new JLabel("Total Number of children");
		lblTotalNumberOf.setBounds(0, 223, 140, 14);
		frame.getContentPane().add(lblTotalNumberOf);
		
		 xammaName = new JTextArea();
		xammaName.setToolTipText("enter wife/name");
		xammaName.setBounds(305, 161, 122, 22);
		frame.getContentPane().add(xammaName);
		
//		JLabel lblPetName = new JLabel("Pet name");
//		lblPetName.setBounds(239, 359, 139, 14);
//		frame.getContentPane().add(lblPetName);
//		
//		petName = new JTextField();
//		petName.setColumns(10);
//		petName.setBounds(300, 353, 132, 20);
//		frame.getContentPane().add(petName);
//		
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
	
	public String makeMaritalStatusParagraph(String  xamma){
		String paragraph="";
		switch (xamma){
		case "Girlfriend": 
		paragraph="He is currently in a living in relationship with his girlfriend. "+ xammaName.getText()+ " The couple is in a living-in relationship from quite a few years but so far they have not outed any plan for marriage. The couple live in their "+ currentXammaLocation.getText()  +" based home. Though he is very shy about his personal life, he has spoken about his girlfriend in many interviews. ";
		break;
		case "Wife":
			paragraph="He is currently married to his former girlfriend turned wife "+xammaName.getText()+". The married couple is living together in their " + currentXammaLocation.getText()+ " based home. Though he is very shy about his personal life, he has spoken about his wife in many interviews. ";
			break;
		case "Single":
			paragraph="He is so far living a single life and no news regarding his relationship or affair has surfaced in the media. ";
			break;
		}
		return paragraph;
		
	}
	public String makeChildSentence(String children){
		String sentence="";
		if(children != null && !children.isEmpty()){
			if (!(children.equals("0"))){
				sentence="They have " +children+ " children together. ";
			}
			else{
				sentence="So far they don’t have any children together. ";

			}
			
		}
		return sentence;
		
		
	} 
	}
		

