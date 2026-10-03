import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DeleteStudentProfile extends JFrame{
	private JPanel topPanel;
	private ImageIcon originalLogo;
	private Image tempLogo;
	private ImageIcon logo;
	private JLabel logoLbl;
	private JLabel topicLbl;
	private JPanel bottomPanel;
	private JPanel idPanel;
	private JPanel centerPanel;
	private JTextField regNoTxt;
	private JButton searchBtn;
	private JPanel detailsPanel;
	private JPanel row1;
	private JPanel row2;
	private JPanel row3;
	private JPanel row4;
	private JPanel row5;
	private JLabel nameLbl;
	private JTextField nameTxt;
	private JLabel nicLbl;
	private JTextField nicTxt;
	private JLabel prfLbl;
	private JTextField prfTxt;
	private JLabel dbmsLbl;
	private JTextField dbmsTxt;
	private JLabel gpaLbl;
	private JTextField gpaTxt;
	private JPanel btnPanel;
	private JButton deleteBtn;
	
	//finding GPA number
	private static double findGpaValuesFromMarks(int marks){
		if(marks>=90)      return 4.25;
		else if(marks>=80) return 4.00;
		else if(marks>=75) return 3.70;
		else if(marks>=70) return 3.30;
		else if(marks>=65) return 3.00;
		else if(marks>=60) return 2.70;
		else if(marks>=55) return 2.30;
		else if(marks>=50) return 2.00;
		else if(marks>=45) return 1.70;
		else if(marks>=40) return 1.30;
		else if(marks>=30) return 1.00;
		else if(marks>=20) return 0.70;
		else               return 0.25;
	}
	
	//finding GPA value
	private static double calculateGPA(int index){
		int prfMark = Details.studentArray[index].getPrfMark();
		int dbmsMark = Details.studentArray[index].getDbmsMark();
		
		if(prfMark<0 && dbmsMark<0){
			return 0.0;
		}
		if(prfMark>=0 && dbmsMark>=0){
			 return ((double)(findGpaValuesFromMarks(prfMark) + findGpaValuesFromMarks(dbmsMark))/2);
		}
		if(prfMark<0 && dbmsMark>=0){
			 return ((double)(findGpaValuesFromMarks(dbmsMark))/2);
		}
		if(prfMark>=0 && dbmsMark<0){
			 return ((double)(findGpaValuesFromMarks(prfMark))/2);
		}
		return 0.0;
	}
	
	DeleteStudentProfile(){
		setSize(900,600);
		setTitle("Delete Student Profile");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setLayout(new BorderLayout());
		
		//top panel
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(new Color(28, 34, 80));
		
		originalLogo = new ImageIcon("newLogo.png");
		tempLogo = originalLogo.getImage().getScaledInstance(140,50, Image.SCALE_SMOOTH);
		logo = new ImageIcon(tempLogo);
		logoLbl = new JLabel(logo);
		
		topicLbl = new JLabel("Delete Student Profile");
		topicLbl.setFont(new Font("", 1, 25));
		topicLbl.setForeground(new Color(255, 255, 255));
		
		topPanel.add(logoLbl, BorderLayout.WEST);
		topPanel.add(topicLbl, BorderLayout.EAST);
		
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		
		//bottom panel
		bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(28, 34, 80));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,20, 10,20));
		
		//center panel
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBackground(new Color(244,245,254));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
		
		idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		idPanel.setBackground(new Color(244,245,254));
		
		regNoTxt = new JTextField("Enter the Student ID here");
		regNoTxt.setFont(new Font("",1,15));
		regNoTxt.setPreferredSize(new Dimension(250,40));
		regNoTxt.setBackground(new Color(244,245,254));
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("",1,15));
		searchBtn.setPreferredSize(new Dimension(100,40));
		searchBtn.setBackground(new Color(28, 34, 80));
		searchBtn.setForeground(new Color(255, 255, 255));
		
		idPanel.add(regNoTxt);
		idPanel.add(searchBtn);
		
		centerPanel.add(idPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				for(int i=0 ; i<Details.studentArray.length ; i++){
					if(Details.studentArray[i].getRegNo().equals(regNoTxt.getText())){
						final int index = i;
						
						regNoTxt.setEditable(false);
						searchBtn.setEnabled(false);
						
						//details panel
						detailsPanel = new JPanel();
						detailsPanel.setLayout(new BoxLayout(detailsPanel,BoxLayout.Y_AXIS));
						detailsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 250));
						detailsPanel.setBackground(new Color(244,245,254));
						
						//row1
						row1 = new JPanel();
						row1.setLayout(new BorderLayout());
						row1.setBackground(new Color(244,245,254));
						
						nameLbl = new JLabel("Student Name");
						nameLbl.setFont(new Font("",1,15));
						nameLbl.setPreferredSize(new Dimension(130, 25));
						
						nameTxt = new JTextField();
						nameTxt.setFont(new Font("",1,15));
						nameTxt.setPreferredSize(new Dimension(130, 25));
						nameTxt.setBackground(new Color(244,245,254));
						
						row1.add(nameLbl, BorderLayout.WEST);
						row1.add(nameTxt, BorderLayout.CENTER);
						
						//row2
						row2 = new JPanel();
						row2.setLayout(new BorderLayout());
						row2.setBackground(new Color(244,245,254));
						
						nicLbl = new JLabel("Student NIC No");
						nicLbl.setFont(new Font("",1,15));
						nicLbl.setPreferredSize(new Dimension(130, 25));
						
						nicTxt = new JTextField();
						nicTxt.setFont(new Font("",1,15));
						nicTxt.setBackground(new Color(244,245,254));
						
						row2.add(nicLbl, BorderLayout.WEST);
						row2.add(nicTxt, BorderLayout.CENTER);
						
						//row3
						row3 = new JPanel();
						row3.setLayout(new BorderLayout());
						row3.setBackground(new Color(244,245,254));
						
						prfLbl = new JLabel("PRF Marks");
						prfLbl.setFont(new Font("",1,15));
						prfLbl.setPreferredSize(new Dimension(130, 25));
						
						prfTxt = new JTextField();
						prfTxt.setFont(new Font("",1,15));
						prfTxt.setBackground(new Color(244,245,254));
						
						row3.add(prfLbl, BorderLayout.WEST);
						row3.add(prfTxt, BorderLayout.CENTER);
						
						//row4
						row4 = new JPanel();
						row4.setLayout(new BorderLayout());
						row4.setBackground(new Color(244,245,254));
						
						dbmsLbl = new JLabel("DBMS Marks");
						dbmsLbl.setFont(new Font("",1,15));
						dbmsLbl.setPreferredSize(new Dimension(130, 25));
						
						dbmsTxt = new JTextField();
						dbmsTxt.setFont(new Font("",1,15));
						dbmsTxt.setBackground(new Color(244,245,254));
						
						row4.add(dbmsLbl, BorderLayout.WEST);
						row4.add(dbmsTxt, BorderLayout.CENTER);
						
						//row5
						row5 = new JPanel();
						row5.setLayout(new BorderLayout());
						row5.setBackground(new Color(244,245,254));
						
						gpaLbl = new JLabel("GPA");
						gpaLbl.setFont(new Font("",1,15));
						gpaLbl.setPreferredSize(new Dimension(130, 25));
						
						gpaTxt = new JTextField();
						gpaTxt.setFont(new Font("",1,15));
						gpaTxt.setBackground(new Color(244,245,254));
						
						row5.add(gpaLbl, BorderLayout.WEST);
						row5.add(gpaTxt, BorderLayout.CENTER);
						
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 40)));
						detailsPanel.add(row1);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						detailsPanel.add(row2);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						detailsPanel.add(row3);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						detailsPanel.add(row4);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						detailsPanel.add(row5);
						
						btnPanel = new JPanel();
						btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
						btnPanel.setBackground(new Color(244,245,254));
						
						deleteBtn = new JButton("Delete");
						deleteBtn.setFont(new Font("",1,20));
						deleteBtn.setBackground(new Color(28, 34, 80));
						deleteBtn.setForeground(new Color(255, 255, 255));
						deleteBtn.setPreferredSize(new Dimension(230, 40));
						deleteBtn.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent evt){
								Student[] tempStudentArray = new Student[Details.studentArray.length-1];
								for(int j=0 ; j<Details.studentArray.length ; j++){
									if(j<index){
										tempStudentArray[j]=Details.studentArray[j];
									}else if(j>index){
										tempStudentArray[j-1]=Details.studentArray[j];
									}else if(j==index){
										continue;
									}
								}
								Details.studentArray = tempStudentArray;
								JOptionPane.showMessageDialog(null, "Student Successfully Deleted...");
							}
						});
						
						btnPanel.add(deleteBtn);
						centerPanel.add(detailsPanel);
						centerPanel.add(btnPanel);
						
						nameTxt.setText(Details.studentArray[i].getName());
						nicTxt.setText(Details.studentArray[i].getNic());
						prfTxt.setText(Details.studentArray[i].getPrfMark()==-1 ? "absent" : Details.studentArray[i].getPrfMark()==-2 ? "not conducted" : Integer.toString(Details.studentArray[i].getPrfMark()));
						dbmsTxt.setText(Details.studentArray[i].getDbmsMark()==-1 ? "absent" : Details.studentArray[i].getDbmsMark()==-2 ? "not conducted" : Integer.toString(Details.studentArray[i].getDbmsMark()));
						gpaTxt.setText(Double.toString(calculateGPA(i)));
						
						nameTxt.setEditable(false);
						nicTxt.setEditable(false);
						prfTxt.setEditable(false);
						dbmsTxt.setEditable(false);
						gpaTxt.setEditable(false);
						
						revalidate();
						repaint();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Invalid Student ID");
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	
	
}
