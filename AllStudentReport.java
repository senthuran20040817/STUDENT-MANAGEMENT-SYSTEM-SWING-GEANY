import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
class AllStudentReport extends JFrame{
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
	
	private static Student[] orderedNameArray(){
		Student[] tempStudentArray = new Student[Details.studentArray.length];
		for(int i=0 ; i<Details.studentArray.length ; i++){
			tempStudentArray[i] = Details.studentArray[i];
		}
		
		for(int j=0 ; j<tempStudentArray.length ; j++){
			L1:for(int i=0 ; i<tempStudentArray.length-1 ; i++){
				String lowerCasedNameCurrent = tempStudentArray[i].getName().toLowerCase();
				String lowerCasedNameNext = tempStudentArray[i+1].getName().toLowerCase();
				int minLength=tempStudentArray[i].getName().length()<tempStudentArray[i+1].getName().length() ? tempStudentArray[i].getName().length() : tempStudentArray[i+1].getName().length();
				L2:for(int k=0 ; k<minLength ; k++ ){					
					if((int)lowerCasedNameCurrent.charAt(k)==(int)lowerCasedNameNext.charAt(k)){
						continue L2;
					}else if((int)lowerCasedNameCurrent.charAt(k)>(int)lowerCasedNameNext.charAt(k)){
						Student temp = tempStudentArray[i];
						tempStudentArray[i]=tempStudentArray[i+1];
						tempStudentArray[i+1]=temp;
					}
					continue L1;
				}
				if(tempStudentArray[i].getName().length()>tempStudentArray[i+1].getName().length()){
					Student temp = tempStudentArray[i];
					tempStudentArray[i]=tempStudentArray[i+1];
					tempStudentArray[i+1]=temp;
				}
			}
		}
		return tempStudentArray;
	}
	
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
		int prfMark = orderedNameArray()[index].getPrfMark();
		int dbmsMark = orderedNameArray()[index].getDbmsMark();
		
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
	
	AllStudentReport(){
		setSize(900,600);
		setTitle("View All Students(Alphabatical order of  Name)");
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
		
		topicLbl = new JLabel("View All Student Details");
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
		
		Student[] tempStudentArray=orderedNameArray();
		
		for(int i=0 ; i<tempStudentArray.length ; i++){
			Object[] rowData = {
								i+1,
								tempStudentArray[i].getRegNo(),
								tempStudentArray[i].getName(),
								tempStudentArray[i].getPrfMark()==-1 ? "absent" : tempStudentArray[i].getPrfMark()==-2 ? "not conducted" : tempStudentArray[i].getPrfMark(),
								tempStudentArray[i].getDbmsMark()==-1 ? "absent" : tempStudentArray[i].getDbmsMark()==-2 ? "not conducted" : tempStudentArray[i].getDbmsMark(),
								String.format("%.3f",calculateGPA(i))
								};
			dtm.addRow(rowData);
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
