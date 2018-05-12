import java.awt.EventQueue;
import javax.swing.JFrame;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
	import java.io.OutputStreamWriter;
	import java.io.Writer;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

	public class Career {
		ButtonGroup event ;
		
		private JTextField txtDate;
		private JTextField txtEventId;
		private JTextField  txtOpponentName;
		private JTextField txtMove;
		
		private JFrame frame;
		private JTextField name;
		int count=0;
		static int  countCSV =0;
		JRadioButton rdbtnWin;
		JRadioButton rdbtnKo;
		JRadioButton rdbtnTko ;
		JRadioButton rdbtnSubmission ;
		JRadioButton rdbtnSplitDecision ;
		JRadioButton rdbtnUnanimousDecision ;
		ButtonGroup winMethod;
		JRadioButton rdbtnLoss ;
		JRadioButton rdbtnDraw ;
		ButtonGroup results;
		Path pathcsv;
		static List <CsvDataModel> careerdata;
		StringBuilder career;
		int	couner=0;
		String[] clauses ={"Subsequently,","Correspondingly,","Additionally,", "In another equally important match,","Later in his next match,","In the following event,","In one of the most remembered bouts,","Consequently,","In addition to that,","Henceforth,","In fact,","All things considered,","Moreover,","Added the fact,","Further more,","Respectively,"};

		ArrayList <String> sentenceArraylist = new  ArrayList <>();
		private JTextField txtRound;
		private JLabel lblNewLabel_1;
		private JButton btnNewButton;

		public Career () {
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
			frame.setBounds(100, 100, 787, 445);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			JLabel lblSpin = new JLabel("Spin Fuck");
			lblSpin.setBounds(122, 0, 191, 42);
			lblSpin.setFont(new Font("Serif", Font.BOLD, 39));
			lblSpin.setForeground(Color.PINK);
			frame.getContentPane().add(lblSpin);
		
			txtDate = new JTextField();
			txtDate.setText("date");
			txtDate.setBounds(10, 182, 122, 20);
			frame.getContentPane().add(txtDate);
			txtDate.setColumns(10);
			
			txtEventId = new JTextField();
			txtEventId.setText("event id");
			txtEventId.setColumns(10);
			txtEventId.setBounds(132, 182, 52, 20);
			frame.getContentPane().add(txtEventId);
			
			event= new ButtonGroup();
			
			
			 rdbtnWin = new JRadioButton("Win");
			 rdbtnWin.setActionCommand("won ");
			rdbtnWin.setBounds(416, 179, 73, 23);
			frame.getContentPane().add(rdbtnWin);
			
			 rdbtnLoss = new JRadioButton("Loss");
			 rdbtnLoss.setActionCommand("lost ");
			rdbtnLoss.setBounds(416, 196, 73, 23);
			frame.getContentPane().add(rdbtnLoss);
			
			 rdbtnDraw = new JRadioButton("Draw");
			 rdbtnDraw.setActionCommand("drew with");
			rdbtnDraw.setBounds(416, 212, 73, 23);
			frame.getContentPane().add(rdbtnDraw);
			
			results= new ButtonGroup();
			results.add(rdbtnWin);
			results.add(rdbtnLoss);
			results.add(rdbtnDraw);
			
			
			txtOpponentName = new JTextField();
			txtOpponentName.setText("Opponent Name");
			txtOpponentName.setColumns(10);
			txtOpponentName.setBounds(206, 182, 146, 20);
			frame.getContentPane().add(txtOpponentName);
			
			 rdbtnKo = new JRadioButton("KO");
			rdbtnKo.setActionCommand("KO");
			rdbtnKo.setBounds(491, 179, 73, 23);
			frame.getContentPane().add(rdbtnKo);
			
			 rdbtnTko = new JRadioButton("TKO");
			 rdbtnTko.setActionCommand("TKO");
			rdbtnTko.setBounds(491, 196, 73, 23);
			frame.getContentPane().add(rdbtnTko);
			
			 rdbtnSubmission = new JRadioButton("Submission");
			 rdbtnSubmission.setActionCommand("Submission");
			rdbtnSubmission.setBounds(491, 212, 109, 23);
			frame.getContentPane().add(rdbtnSubmission);
			
			 rdbtnSplitDecision = new JRadioButton("Split Decision");
			 rdbtnSplitDecision.setActionCommand("Split Decision");
			rdbtnSplitDecision.setBounds(491, 228, 109, 23);
			frame.getContentPane().add(rdbtnSplitDecision);
			
			 rdbtnUnanimousDecision = new JRadioButton("Unanimous Decision");
			 rdbtnUnanimousDecision.setActionCommand("Unanimous Decision");
			rdbtnUnanimousDecision.setBounds(491, 246, 146, 23);
			frame.getContentPane().add(rdbtnUnanimousDecision);
			winMethod = new ButtonGroup();
			winMethod.add(rdbtnKo);
			winMethod.add(rdbtnTko);
			winMethod.add(rdbtnSubmission);
			winMethod.add(rdbtnSplitDecision);
			winMethod.add(rdbtnUnanimousDecision);
			
			txtMove = new JTextField();
			txtMove.setText("Move");
			txtMove.setColumns(10);
			txtMove.setBounds(564, 179, 128, 20);
			frame.getContentPane().add(txtMove);
			
			JLabel lblPressButtonTo = new JLabel("Press Button To Go to :-");
			lblPressButtonTo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPressButtonTo.setBounds(10, 342, 151, 20);
			frame.getContentPane().add(lblPressButtonTo);
			
			JButton btnPersonalLife = new JButton("Personal Life");
			btnPersonalLife.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PersonalLife chikaichadai = new PersonalLife();
				}
			});
			btnPersonalLife.setBounds(107, 373, 122, 23);
			frame.getContentPane().add(btnPersonalLife);
			
			JButton btnEarlyLife = new JButton("Early Life");
			btnEarlyLife.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EarlyLife fs = new EarlyLife();
				}
			});
			btnEarlyLife.setBounds(239, 373, 89, 23);
			frame.getContentPane().add(btnEarlyLife);
			
			JButton btnMmaCarrer = new JButton("NetWorth");
			btnMmaCarrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NetWorth ty = new NetWorth();
				}
			});
			btnMmaCarrer.setBounds(342, 373, 109, 23);
			frame.getContentPane().add(btnMmaCarrer);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/3.png")));
			lblNewLabel.setBounds(100, 40, 213, 92);
			frame.getContentPane().add(lblNewLabel);
			
			JButton btnAppend = new JButton("Append Career");
			btnAppend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Path path = Paths.get("D:/"+name.getText()+"career.txt");

					if (!Files.exists(path)) {
					  JOptionPane.showMessageDialog(frame,"You must Have your spinfucked file to append");
					}
					else{
						
						
						count++;
						if(count<clauses.length)
						{
							if((count%2)==0)
							makeSentenceEven(clauses[count],"D:/"+name.getText()+"career.txt");
							
							else
							makeSentenceOdd(clauses[count],"D:/"+name.getText()+"career.txt");
							
						}
						else
						{
						
							if((count%2)==0)
								makeSentenceEven(clauses[count-1],"D:/"+name.getText()+"career.txt");
								else
								makeSentenceOdd(clauses[count-1],"D:/"+name.getText()+"career.txt");
							
							count =0;
						
						
							
						}
					
					
						}	
					}
			});
			btnAppend.setBounds(10, 246, 174, 23);
			frame.getContentPane().add(btnAppend);
			
			JButton btnCreate = new JButton("Create Career");
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
						Path path = Paths.get("D:/"+name.getText()+"career.txt");
						if (Files.exists(path)) {
						  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
						}
						else{
						
						
							String s="He at "+txtEventId.getText()+" fought against "+txtOpponentName.getText()+" and "+results.getSelection().getActionCommand()+" the match "+"held on  "+txtDate.getText()+" via " + winMethod.getSelection().getActionCommand()+ " " +txtMove.getText()+" in round "+txtRound.getText()+".";
			
					   try {
				            File statText = new File(path.toString());
				            FileOutputStream is = new FileOutputStream(statText);
				            OutputStreamWriter osw = new OutputStreamWriter(is);    
				            Writer w = new BufferedWriter(osw);
				            w.write(s);
				            w.close();
				            JOptionPane.showMessageDialog(frame, "Fucking Great Man! You Have succesfuly created SpinFucked File");
				        } catch (IOException ioe) {
				            System.err.println("Problem writing to the file statsTest.txt");
				        }
						
					
						}
					
					}
				
				
			});
			btnCreate.setBounds(564, 289, 128, 23);
			frame.getContentPane().add(btnCreate);
			
			name = new JTextField();
			name.setBounds(76, 151, 228, 20);
			frame.getContentPane().add(name);
			name.setColumns(10);
			
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(20, 154, 46, 14);
			frame.getContentPane().add(lblName);
			
			txtRound = new JTextField();
			txtRound.setText("round");
			txtRound.setColumns(10);
			txtRound.setBounds(709, 180, 52, 20);
			frame.getContentPane().add(txtRound);
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(199, 298, 167, 14);
			frame.getContentPane().add(lblNewLabel_1);
			
			btnNewButton = new JButton("Get Career From CSV Wikipedia");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Path path = Paths.get("D:/"+name.getText()+"career.txt");
					if (Files.exists(path)) {
					  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
					}
					else{
					pathcsv = Paths.get("D:/"+name.getText()+".csv");
					if (!Files.exists(pathcsv)) {
						  JOptionPane.showMessageDialog(frame,"You are trying to spinfuckCSV without csv file, so, first create spinfucked csv and try spinfucking again");
						}
					else{
						StringBuilder career= new StringBuilder(); 
						careerdata = new ArrayList<>();
					    readCsvWiki(pathcsv.toString());
					    for(int i =1;i<careerdata.size();i++){
					    	
					    	if (i==1){
					    		String s="He at "+careerdata.get(i).eventid+" fought against "+careerdata.get(i).opponentName+" and "+careerdata.get(i).result+" the match "+"held on  "+careerdata.get(i).date+" via " + careerdata.get(i).move+ " " +"in round "+careerdata.get(i).round+".";
					    	   career.append(s);
					    	}
					    	else{
					    		
					    		countCSV++;
								if(countCSV<clauses.length)
								{
									if((countCSV%2)==0)
									career.append(makeSentenceEvenCsv(clauses[countCSV],careerdata.get(i)));
									
									else
									career.append(makeSentenceOddCSV(clauses[countCSV],careerdata.get(i)));
									
								}
								else
								{
								
									if((countCSV%2)==0)
										
									career.append(makeSentenceEvenCsv(clauses[countCSV-1],careerdata.get(i)));	
									
									
									else
										career.append(makeSentenceOddCSV(clauses[countCSV-1],careerdata.get(i)));
										
									
									countCSV =0;
								
								
									
								}
							
					    		
					    	}	
					    	
					    }

						
						   try {
					            File statText = new File(path.toString());
					            FileOutputStream is = new FileOutputStream(statText);
					            OutputStreamWriter osw = new OutputStreamWriter(is);    
					            Writer w = new BufferedWriter(osw);
					            w.write(career.toString());
					            w.close();
					            JOptionPane.showMessageDialog(frame, "Fucking Great Man! You Have succesfuly created SpinFucked File From SpinFuckedCSV");
					        } catch (IOException ioe) {
					            System.err.println("Problem writing to the file statsTest.txt");
					        }		
						
					}
						
					
						
		
			
					
				
					}
				
				
				}
			});
			btnNewButton.setBounds(156, 322, 228, 23);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnGetCareerFrom = new JButton("Get Career From CSV UFC Official");
			btnGetCareerFrom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Path path = Paths.get("D:/"+name.getText()+"career.txt");
					if (Files.exists(path)) {
					  JOptionPane.showMessageDialog(frame,"Your File already exist Please Delete it and Try Spinfucking Again");
					}
					else{
					pathcsv = Paths.get("D:/"+name.getText()+".csv");
					if (!Files.exists(pathcsv)) {
						  JOptionPane.showMessageDialog(frame,"You are trying to spinfuckCSV without csv file, so, first create spinfucked csv and try spinfucking again");
						}
					else{
						StringBuilder career= new StringBuilder(); 
						careerdata = new ArrayList<>();
					    readCsvWiki(pathcsv.toString());
					    for(int i =1;i<careerdata.size();i++){
					    	
					    	if (i==1){
					    		String s="He at "+careerdata.get(i).eventid+" fought against "+careerdata.get(i).opponentName+" and "+careerdata.get(i).result+" the match "+"held on  "+careerdata.get(i).date+" via " + careerdata.get(i).move+ " " +"in round "+careerdata.get(i).round+".";
					    	   career.append(s);
					    	}
					    	else{
					    		
					    		countCSV++;
								if(countCSV<clauses.length)
								{
									if((countCSV%2)==0)
									career.append(makeSentenceEvenCsv(clauses[countCSV],careerdata.get(i)));
									
									else
									career.append(makeSentenceOddCSV(clauses[countCSV],careerdata.get(i)));
									
								}
								else
								{
								
									if((countCSV%2)==0)
										
									career.append(makeSentenceEvenCsv(clauses[countCSV-1],careerdata.get(i)));	
									
									
									else
										career.append(makeSentenceOddCSV(clauses[countCSV-1],careerdata.get(i)));
										
									
									countCSV =0;
								
								
									
								}
							
					    		
					    	}	
					    	
					    }

						
						   try {
					            File statText = new File(path.toString());
					            FileOutputStream is = new FileOutputStream(statText);
					            OutputStreamWriter osw = new OutputStreamWriter(is);    
					            Writer w = new BufferedWriter(osw);
					            w.write(career.toString());
					            w.close();
					            JOptionPane.showMessageDialog(frame, "Fucking Great Man! You Have succesfuly created SpinFucked File From SpinFuckedCSV");
					        } catch (IOException ioe) {
					            System.err.println("Problem writing to the file statsTest.txt");
					        }		
						
					}
						
					
						
		
			
					
				
					}
				
				
				
				}
			});
			btnGetCareerFrom.setBounds(398, 322, 228, 23);
			frame.getContentPane().add(btnGetCareerFrom);
		}
		public  void makeSentenceEven(String adverbs,String url){
			
	String newSentence = adverbs+" on "+txtDate.getText()+ ", he "+" fought against "+txtOpponentName.getText()+" at "+txtEventId.getText()+" and "+results.getSelection().getActionCommand()+" the match "+" held on  "+txtDate.getText()+" via " + winMethod.getSelection().getActionCommand()+ " (" +txtMove.getText()+")"+" in round "+txtRound.getText()+". ";		
		
try {
			    Files.write(Paths.get(url), newSentence.getBytes(), StandardOpenOption.APPEND);
			    couner++;
			    lblNewLabel_1.setText("line "+couner+" is added");
			    
			}catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Error In Appending");
			}
			
		}
		 public void  makeSentenceOdd(String clause,String url)
		 { 
			 String combined=clause+ " he "+" at "+txtEventId.getText()+" fought against "+txtOpponentName.getText()+", " +results.getSelection().getActionCommand()+" the match "+" held on  "+txtDate.getText()+" via " + winMethod.getSelection().getActionCommand()+" " +txtMove.getText()+" in round "+txtRound.getText()+". ";
//			Subsequently, he at ufc 202 fought against XYZ as undercard, winning the match held on date  via tko delevering in the third round. 
			 try {
				    Files.write(Paths.get(url), combined.getBytes(), StandardOpenOption.APPEND);
				    couner++;
				    lblNewLabel_1.setText("line "+couner+" is added");
				}catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "Error In Appending");
				}
			 
	 }
		 
		public void readCsvWiki(String csvFile){
			    
		        String line = "";
		        String cvsSplitBy = ",";

		        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

		            while ((line = br.readLine()) != null) {

		                // use comma as separator
		                String[] country = line.split(cvsSplitBy);
		                CsvDataModel csv= new CsvDataModel();
		                csv.date=country[5];
		                csv.eventid=country[4];
		                csv.opponentName=country[2];
		                csv.move=country[3];
		                csv.result=country[0];
		                csv.round=country[6];
		                careerdata.add(csv);



		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		    }
		public void readCsvUFC(String csvFile){
		    
	        String line = "";
	        String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] country = line.split(cvsSplitBy);
	                CsvDataModel csv= new CsvDataModel();
	                csv.date=country[5];
	                csv.eventid=country[2];
	                csv.opponentName=country[1];
	                csv.move=country[3];
	                csv.result=country[0];
	                csv.round=country[6];
	                careerdata.add(csv);



	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

		public  String makeSentenceEvenCsv(String adverbs, CsvDataModel csv){
			String conclu;
			
			switch(csv.result){
			case "Win":
				conclu="won";
				break;
			case "Loss":
			      conclu="lost";
			      break;
			 
			case "Draw":
				  conclu="drew";
				  break;
		   
			default: conclu = "no result";
          
			      
			      
				
			}
			
			String newSentence = adverbs+" on "+csv.date+ ", he "+" fought against "+csv.opponentName+" at "+csv.eventid+" and "+conclu+" the match "+ " via " + csv.move +" in round "+csv.round+". ";		
				
	
					    couner++;
					    return newSentence; 
					    
					
					
				}
				 public String  makeSentenceOddCSV(String clause,CsvDataModel csv)
				 { 
						String conclu;
						
						switch(csv.result){
						case "Win":
							conclu="won";
							break;
						case "Loss":
						      conclu="lost";
						      break;
						 
						case "Draw":
							  conclu="drew";
							  break;
					   
						default: conclu = "no result";
						      
						      
							
						}
					 String combined=clause+ " he "+" at "+csv.eventid+" fought against "+csv.opponentName+", " +conclu+" the match "+" held on  "+csv.date+" via " + csv.move+" " +" in round "+csv.round+". ";
//					Subsequently, he at ufc 202 fought against XYZ as undercard, winning the match held on date  via tko delevering in the third round. 
					
						   
						    couner++;
						    return combined;
						  
						
					 
			 }
	 }
			
			
		
	


