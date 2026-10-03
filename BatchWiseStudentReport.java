import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
class BatchWiseStudentReport extends JFrame{
	private JPanel leftPanel; 
	private ImageIcon logo;
	private JLabel logoLbl;
	private JPanel rightPanel;
	private JPanel rightNorthPanel;
	private JLabel topicLine;
	private JLabel topicSub;
	private JButton studentTableBtn;
	private JPanel rightSouthPanel;
	private JButton prevBtn;
	
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
	
	BatchWiseStudentReport(){
		setSize(900,600);
		setTitle("Batch-wise Report Management");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setLayout(new BorderLayout());
		
		//left panel
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBackground(new Color(255, 255, 255));
		logo = new ImageIcon("images.png");
		logoLbl = new JLabel(logo);
		
		leftPanel.add(logoLbl, BorderLayout.CENTER);
		
		//right panel
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		
		rightNorthPanel = new JPanel();
		rightNorthPanel.setLayout(new BoxLayout(rightNorthPanel, BoxLayout.Y_AXIS));
		rightNorthPanel.setBackground(new Color(28, 34, 80));
		
		topicLine = new JLabel("Batch-wise Report Management");
		topicLine.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicLine.setFont(new Font("",1,25));
		topicLine.setForeground(new Color(255, 255, 255));
		
		topicSub = new JLabel("Choose an option from the menu below to get started");
		topicSub.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicSub.setFont(new Font("",1,12));
		topicSub.setForeground(new Color(255, 255, 255));
		
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		rightNorthPanel.add(topicLine);
		rightNorthPanel.add(topicSub);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		for(int i=0 ; i<Details.batchArray.length ; i++){
			String batchName = Integer.toString(Details.batchArray[i].getBatchName());
			
			studentTableBtn = new JButton(batchName);
			studentTableBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
			studentTableBtn.setFont(new Font("",1,15));
			studentTableBtn.setMaximumSize(new Dimension(300, 50));
			studentTableBtn.setBackground(new Color(202, 210, 251));
			studentTableBtn.setBorderPainted(false);
			
			rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			rightNorthPanel.add(studentTableBtn);
			
			studentTableBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					BatchWiseReportToAll batchWiseFrame = new BatchWiseReportToAll(batchName);
					batchWiseFrame.setVisible(true);
				}
			});
		}	
		
		rightPanel.add(rightNorthPanel, BorderLayout.CENTER);
		
		rightSouthPanel = new JPanel();
		rightSouthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		rightSouthPanel.setBackground(new Color(28, 34, 80));
		
		prevBtn = new JButton("\u2190 Back to Previous Page");
		prevBtn.setFont(new Font("",1,13));
		prevBtn.setPreferredSize(new Dimension(200, 40));
		prevBtn.setForeground(new Color(255, 255, 255));
		prevBtn.setContentAreaFilled(false);
		prevBtn.setBorderPainted(false);
		prevBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		
		rightSouthPanel.add(prevBtn);
		rightPanel.add(rightSouthPanel, BorderLayout.SOUTH);
		
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.CENTER);
	}
}
