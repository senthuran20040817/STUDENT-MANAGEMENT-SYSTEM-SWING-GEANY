import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
class IndustryEligibleStudentReport extends JFrame{
	private JPanel topPanel;
	private ImageIcon originalLogo;
	private Image tempLogo;
	private ImageIcon logo;
	private JLabel logoLbl;
	private JLabel topicLbl;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JTable batchTable;
	private DefaultTableModel dtm;
	private JScrollPane tablePane;
	
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
	
	
	IndustryEligibleStudentReport(){
		setSize(900,600);
		setTitle("Industry Eligible Student Report");
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
		
		topicLbl = new JLabel("Industry Eligible Student Report");
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
		
		//table
		String[] columnNames = {"No.", "Registration No.", "Student Name", "PRF Mark", "DBMS Mark", "GPA"};
		dtm = new DefaultTableModel(columnNames , 0);
		batchTable = new JTable(dtm);
		
		int count = 1;
		for(int i=0 ; i<Details.studentArray.length ; i++){
			if(Details.studentArray[i].getPrfMark()>50 && Details.studentArray[i].getDbmsMark()>50 && calculateGPA(i)>3.25){
				Object[] rowData = {
								count++,
								Details.studentArray[i].getRegNo(),
								Details.studentArray[i].getName(),
								Details.studentArray[i].getPrfMark()==-1 ? "absent" : Details.studentArray[i].getPrfMark()==-2 ? "not conducted" : Details.studentArray[i].getPrfMark(),
								Details.studentArray[i].getDbmsMark()==-1 ? "absent" : Details.studentArray[i].getDbmsMark()==-2 ? "not conducted" : Details.studentArray[i].getDbmsMark(),
								String.format("%.3f",calculateGPA(i))
								};
				dtm.addRow(rowData);
			}
		}
		tablePane = new JScrollPane(batchTable);
		tablePane.getViewport().setBackground(new Color(244,245,254));
		tablePane.setBorder(BorderFactory.createEmptyBorder());
		
		centerPanel.add(tablePane);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	
}
