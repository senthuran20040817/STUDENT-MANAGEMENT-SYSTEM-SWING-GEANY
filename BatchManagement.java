import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BatchManagement extends JFrame{
	private JPanel leftPanel; 
	private ImageIcon logo;
	private JLabel logoLbl;
	private JPanel rightPanel;
	private JPanel rightNorthPanel;
	private JLabel topicLine;
	private JLabel topicSub;
	private JButton addBatchBtn;
	private JButton updateBatchBtn;
	private JButton viewBatchBtn;
	private JPanel rightSouthPanel;
	private JButton homeBtn;
	
	BatchManagement(){
		setSize(900,600);
		setTitle("Batch Management");
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
		
		topicLine = new JLabel("Batch Management");
		topicLine.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicLine.setFont(new Font("",1,30));
		topicLine.setForeground(new Color(255, 255, 255));
		
		topicSub = new JLabel("Choose an option from the menu below to get started");
		topicSub.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topicSub.setFont(new Font("",1,12));
		topicSub.setForeground(new Color(255, 255, 255));
		
		addBatchBtn = new JButton("Add Batch");
		addBatchBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		addBatchBtn.setFont(new Font("",1,15));
		addBatchBtn.setMaximumSize(new Dimension(300, 50));
		addBatchBtn.setBackground(new Color(202, 210, 251));
		addBatchBtn.setBorderPainted(false);
		
		updateBatchBtn = new JButton("Update Batch");
		updateBatchBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		updateBatchBtn.setFont(new Font("",1,15));
		updateBatchBtn.setMaximumSize(new Dimension(300, 50));
		updateBatchBtn.setBackground(new Color(202, 210, 251));
		updateBatchBtn.setBorderPainted(false);
		
		viewBatchBtn = new JButton("View Batch Details");
		viewBatchBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);
		viewBatchBtn.setFont(new Font("",1,15));
		viewBatchBtn.setMaximumSize(new Dimension(300, 50));
		viewBatchBtn.setBackground(new Color(202, 210, 251));
		viewBatchBtn.setBorderPainted(false);
		
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		rightNorthPanel.add(topicLine);
		rightNorthPanel.add(topicSub);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 100)));
		rightNorthPanel.add(addBatchBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(updateBatchBtn);
		rightNorthPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		rightNorthPanel.add(viewBatchBtn);
		
		addBatchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddBatch addBatch = new AddBatch();
				addBatch.setVisible(true);
			}
		});
		
		updateBatchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				UpdateBatch updateBatch = new UpdateBatch();
				updateBatch.setVisible(true);
			}
		});
		
		viewBatchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewBatch viewBatch = new ViewBatch();
				viewBatch.setVisible(true);
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

