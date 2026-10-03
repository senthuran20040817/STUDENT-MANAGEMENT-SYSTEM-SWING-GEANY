import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class StudentManagement extends JFrame{
	private static StudentManagement obj;
	
	private JPanel leftPanel; 
	private ImageIcon logo;
	private JLabel logoLbl;
	private JPanel rightPanel;
	private JPanel rightNorthPanel;
	private JLabel topicLine;
	private JLabel topicSub;
	private JButton addStudentBtn;
	private JButton updateStudentBtn;
	private JButton viewStudentBtn;
	private JButton deleteStudentBtn;
	private JPanel rightSouthPanel;
	private JButton homeBtn;
	
	public static StudentManagement getInstance(){
		if(obj == null){
			obj = new StudentManagement();
		}
		return obj;
	}
	
	
	private StudentManagement(){
		setSize(900,600);
		setTitle("Student Management");
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
		
		topicLine = new JLabel("Student Management");
		topicLine.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicLine.setFont(new Font("",1,30));
		topicLine.setForeground(new Color(255, 255, 255));
		
		topicSub = new JLabel("Choose an option from the menu below to get started");
		topicSub.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicSub.setFont(new Font("",1,12));
		topicSub.setForeground(new Color(255, 255, 255));
		
		addStudentBtn = new JButton("Add Student");
		addStudentBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		addStudentBtn.setFont(new Font("",1,15));
		addStudentBtn.setMaximumSize(new Dimension(300, 50));
		addStudentBtn.setBackground(new Color(202, 210, 251));
		addStudentBtn.setBorderPainted(false);
		
		updateStudentBtn = new JButton("Update Student");
		updateStudentBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		updateStudentBtn.setFont(new Font("",1,15));
		updateStudentBtn.setMaximumSize(new Dimension(300, 50));
		updateStudentBtn.setBackground(new Color(202, 210, 251));
		updateStudentBtn.setBorderPainted(false);
		
		viewStudentBtn = new JButton("View Student Profile");
		viewStudentBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		viewStudentBtn.setFont(new Font("",1,15));
		viewStudentBtn.setMaximumSize(new Dimension(300, 50));
		viewStudentBtn.setBackground(new Color(202, 210, 251));
		viewStudentBtn.setBorderPainted(false);
		
		deleteStudentBtn = new JButton("Delete Student Profile");
		deleteStudentBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		deleteStudentBtn.setFont(new Font("",1,15));
		deleteStudentBtn.setMaximumSize(new Dimension(300, 50));
		deleteStudentBtn.setBackground(new Color(202, 210, 251));
		deleteStudentBtn.setBorderPainted(false);
		
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		rightNorthPanel.add(topicLine);
		rightNorthPanel.add(topicSub);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 70)));
		rightNorthPanel.add(addStudentBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(updateStudentBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(viewStudentBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(deleteStudentBtn);
		
		addStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddStudent addStudent = new AddStudent();
				addStudent.setVisible(true);
			}
		});
		
		updateStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.setVisible(true);
			}
		});
		
		viewStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewStudentProfile viewStudent = new ViewStudentProfile(StudentManagement.this);
				viewStudent.setVisible(true);
			}
		});
		
		deleteStudentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				DeleteStudentProfile deleteStudent = new DeleteStudentProfile();
				deleteStudent.setVisible(true);
			}
		});
		
		rightPanel.add(rightNorthPanel, BorderLayout.CENTER);
		
		rightSouthPanel = new JPanel();
		rightSouthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		rightSouthPanel.setBackground(new Color(28, 34, 80));
		
		homeBtn = new JButton("\u2190 Back to Home Page");
		homeBtn.setFont(new Font("",1,13));
		homeBtn.setPreferredSize(new Dimension(175, 40));
		homeBtn.setForeground(new Color(255, 255, 255));
		homeBtn.setContentAreaFilled(false);
		homeBtn.setBorderPainted(false);
		homeBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		
		rightSouthPanel.add(homeBtn);
		rightPanel.add(rightSouthPanel, BorderLayout.SOUTH);
		
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.CENTER);
	}
}
