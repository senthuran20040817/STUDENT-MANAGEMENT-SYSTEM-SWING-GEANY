import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ReportManagement extends JFrame{
	private JPanel leftPanel; 
	private ImageIcon logo;
	private JLabel logoLbl;
	private JPanel rightPanel;
	private JPanel rightNorthPanel;
	private JLabel topicLine;
	private JLabel topicSub;
	private JButton studentTableBtn;
	private JButton batchWiseTableBtn;
	private JButton industryEliglibleBtn;
	private JPanel rightSouthPanel;
	private JButton homeBtn;
	
	ReportManagement(){
		setSize(900,600);
		setTitle("Report Management");
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
		
		topicLine = new JLabel("Report Management");
		topicLine.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicLine.setFont(new Font("",1,30));
		topicLine.setForeground(new Color(255, 255, 255));
		
		topicSub = new JLabel("Choose an option from the menu below to get started");
		topicSub.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicSub.setFont(new Font("",1,12));
		topicSub.setForeground(new Color(255, 255, 255));
		
		studentTableBtn = new JButton("Student Registration Report");
		studentTableBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		studentTableBtn.setFont(new Font("",1,15));
		studentTableBtn.setMaximumSize(new Dimension(300, 50));
		studentTableBtn.setBackground(new Color(202, 210, 251));
		studentTableBtn.setBorderPainted(false);
		
		batchWiseTableBtn = new JButton("Batch-wise Student Report");
		batchWiseTableBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		batchWiseTableBtn.setFont(new Font("",1,15));
		batchWiseTableBtn.setMaximumSize(new Dimension(300, 50));
		batchWiseTableBtn.setBackground(new Color(202, 210, 251));
		batchWiseTableBtn.setBorderPainted(false);
		
		industryEliglibleBtn = new JButton("Industry Training Eligibility Report");
		industryEliglibleBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		industryEliglibleBtn.setFont(new Font("",1,15));
		industryEliglibleBtn.setMaximumSize(new Dimension(300, 50));
		industryEliglibleBtn.setBackground(new Color(202, 210, 251));
		industryEliglibleBtn.setBorderPainted(false);
		
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		rightNorthPanel.add(topicLine);
		rightNorthPanel.add(topicSub);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 100)));
		rightNorthPanel.add(studentTableBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(batchWiseTableBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(industryEliglibleBtn);
		
		studentTableBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AllStudentReport allStudentReport = new AllStudentReport();
				allStudentReport.setVisible(true);
			}
		});
		
		batchWiseTableBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				BatchWiseStudentReport batchWiseStudentReport = new BatchWiseStudentReport();
				batchWiseStudentReport.setVisible(true);
			}
		});
		
		industryEliglibleBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				IndustryEligibleStudentReport industryEligibleStudentReport = new IndustryEligibleStudentReport();
				industryEligibleStudentReport.setVisible(true);
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

