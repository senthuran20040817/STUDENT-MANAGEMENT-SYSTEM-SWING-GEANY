import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddBatch extends JFrame{
	private JPanel topPanel;
	private ImageIcon originalLogo;
	private Image tempLogo;
	private ImageIcon logo;
	private JLabel logoLbl;
	private JLabel topicLbl;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JPanel formPanel;
	private JPanel row1;
	private JLabel batchNameLbl;
	private JTextField batchNameTxt;
	private JPanel row2;
	private JLabel batchMaxLbl;
	private JTextField batchMaxTxt;
	private JPanel btnPanel;
	private JButton addBatchBtn;
	
	AddBatch(){
		setSize(900,600);
		setTitle("Add Batch");
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
		
		topicLbl = new JLabel("Add Batch");
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
		
		//center panel --> form panel
		formPanel = new JPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		formPanel.setBorder(BorderFactory.createEmptyBorder(25,20,25,300));
		formPanel.setBackground(new Color(244,245,254));
		
		//row1
		row1 = new JPanel();
		row1.setLayout(new BorderLayout(10,0));
		row1.setBackground(new Color(244,245,254));
		
		batchNameLbl = new JLabel("Batch Name");
		batchNameLbl.setFont(new Font("",1,15));
		batchNameLbl.setPreferredSize(new Dimension(200, 25));
		
		batchNameTxt = new JTextField();
		batchNameTxt.setFont(new Font("",1,15));
		batchNameTxt.setBackground(new Color(244,245,254));
		
		row1.add(batchNameLbl, BorderLayout.WEST);
		row1.add(batchNameTxt, BorderLayout.CENTER);
		
		//row2
		row2 = new JPanel();
		row2.setLayout(new BorderLayout(10,0));
		row2.setBackground(new Color(244,245,254));
		
		batchMaxLbl = new JLabel("Allowed Student Count");
		batchMaxLbl.setFont(new Font("",1,15));
		batchMaxLbl.setPreferredSize(new Dimension(200, 25));
		
		batchMaxTxt = new JTextField();
		batchMaxTxt.setFont(new Font("",1,15));
		batchMaxTxt.setBackground(new Color(244,245,254));
		
		row2.add(batchMaxLbl, BorderLayout.WEST);
		row2.add(batchMaxTxt, BorderLayout.CENTER);
		
		formPanel.add(row1);
		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		formPanel.add(row2);
		
		//center panel --> button panel
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnPanel.setBackground(new Color(244,245,254));
		
		addBatchBtn = new JButton("Add Batch");
		addBatchBtn.setFont(new Font("",1,15));
		addBatchBtn.setPreferredSize(new Dimension(220, 40));
		addBatchBtn.setBackground(new Color(28, 34, 80));
		addBatchBtn.setForeground(new Color(255, 255, 255));
		addBatchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(!batchNameTxt.getText().equals("") && !batchMaxTxt.getText().equals("")){
					for(int i=0 ; i<Details.batchArray.length ; i++){
						if(batchNameTxt.getText().equals(Integer.toString(Details.batchArray[i].getBatchName()))){
							JOptionPane.showMessageDialog(null, "This Batch Already Exists in the system...");
							return;
						}
					}
					batchNameTxt.setEditable(false);
					batchMaxTxt.setEditable(false);
					//addBatchBtn.setEnabled(false);
					Batch[] tempBatchArray = new Batch[Details.batchArray.length+1];
					for(int i=0 ; i<Details.batchArray.length ; i++){
						tempBatchArray[i]=Details.batchArray[i];
					}
					tempBatchArray[Details.batchArray.length] = new Batch(Integer.parseInt(batchNameTxt.getText()), 1, Integer.parseInt(batchMaxTxt.getText()));
					Details.batchArray=tempBatchArray;
					JOptionPane.showMessageDialog(null, "Batch successfully added to the system...");
				}
			}
		});
		
		btnPanel.add("Center",addBatchBtn);
		
		centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		centerPanel.add(formPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 200)));
		centerPanel.add(btnPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
		
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	
}
