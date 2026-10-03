import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class StudentManagementSystem extends JFrame{
	private JPanel leftPanel;
	private JLabel logoLbl;
	private ImageIcon logo;
	private JPanel rightPanel;
	private JLabel topicLine1;
	private JLabel topicLine2;
	private JLabel topicSub;
	private JButton studentMngBtn;
	private JButton batchMngBtn;
	private JButton gradeMngBtn;
	private JButton reportMngBtn;
	
	StudentManagementSystem(){
		setSize(900,600);
		setTitle("Student Management System");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(new BorderLayout());
		
		//Left Panel
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBackground(new Color(255, 255, 255));
		logo = new ImageIcon("images.png");
		logoLbl = new JLabel(logo);
		
		leftPanel.add(logoLbl,BorderLayout.CENTER);
		
		//Right Panel
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBackground(new Color(28, 34, 80));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		topicLine1 = new JLabel("iCET");
		topicLine1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicLine1.setFont(new Font("",1,25));
		topicLine1.setForeground(new Color(255, 255, 255));
		
		topicLine2 = new JLabel("Learning Management System");
		topicLine2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicLine2.setFont(new Font("",1,25));
		topicLine2.setForeground(new Color(255, 255, 255));
		
		topicSub = new JLabel("Choose an option from the menu below to get started");
		topicSub.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicSub.setFont(new Font("",1,12));
		topicSub.setForeground(new Color(255, 255, 255));
		
		studentMngBtn = new JButton("Student Management");
		studentMngBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		studentMngBtn.setFont(new Font("",1,15));
		studentMngBtn.setBackground(new Color(202, 210, 251));
		studentMngBtn.setMaximumSize(new Dimension(300,50));
		studentMngBtn.setBorderPainted(false);
		
		batchMngBtn = new JButton("Batch Management");
		batchMngBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		batchMngBtn.setFont(new Font("",1,15));
		batchMngBtn.setBackground(new Color(202, 210, 251));
		batchMngBtn.setMaximumSize(new Dimension(300,50));
		batchMngBtn.setBorderPainted(false);
		
		gradeMngBtn = new JButton("Grade Management");
		gradeMngBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		gradeMngBtn.setFont(new Font("",1,15));
		gradeMngBtn.setBackground(new Color(202, 210, 251));
		gradeMngBtn.setMaximumSize(new Dimension(300,50));
		gradeMngBtn.setBorderPainted(false);
		
		reportMngBtn = new JButton("Report Management");
		reportMngBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		reportMngBtn.setFont(new Font("",1,15));
		reportMngBtn.setBackground(new Color(202, 210, 251));
		reportMngBtn.setMaximumSize(new Dimension(300,50));
		reportMngBtn.setBorderPainted(false);
		
		rightPanel.add(Box.createRigidArea(new Dimension(0,40)));
		rightPanel.add(topicLine1);
		rightPanel.add(topicLine2);
		rightPanel.add(topicSub);
		rightPanel.add(Box.createRigidArea(new Dimension(0,70)));
		rightPanel.add(studentMngBtn);
		rightPanel.add(Box.createRigidArea(new Dimension(0,20)));
		rightPanel.add(batchMngBtn);
		rightPanel.add(Box.createRigidArea(new Dimension(0,20)));
		rightPanel.add(gradeMngBtn);
		rightPanel.add(Box.createRigidArea(new Dimension(0,20)));
		rightPanel.add(reportMngBtn);
		
		studentMngBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				StudentManagement studentMng = StudentManagement.getInstance();
				studentMng.setVisible(true);
			}
		});
		
		batchMngBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				BatchManagement batchMng = new BatchManagement();
				batchMng.setVisible(true);
			}
		});
		
		gradeMngBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				GradeManagement gradeMng = new GradeManagement();
				gradeMng.setVisible(true);
			}
		});
		
		reportMngBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ReportManagement reportMng = new ReportManagement();
				reportMng.setVisible(true);
			}
		});
		
		add(leftPanel,BorderLayout.WEST);
		add(rightPanel,BorderLayout.CENTER);
	}
}
