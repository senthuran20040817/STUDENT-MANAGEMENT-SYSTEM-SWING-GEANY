import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class UpdateBatch extends JFrame{
	private JPanel topPanel;
	private ImageIcon originalLogo;
	private Image tempLogo;
	private ImageIcon logo;
	private JLabel logoLbl;
	private JLabel topicLbl;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JPanel row1;
	private JPanel row2;
	private JPanel row3;
	private JPanel row4;
	private JTextField batchNameTxt;
	private JButton searchBtn;
	private JLabel studentCountLbl;
	private JTextField studentCountTxt;
	private JLabel statusLbl;
	private JPanel radioPanel;
	private JRadioButton enrolOpenRadioBtn;
	private JRadioButton enrolCloseRadioBtn;
	private ButtonGroup enrolGroup;
	private JButton updateBtn;

	UpdateBatch(){
		setSize(900,600);
		setTitle("Update Batch");
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
		
		topicLbl = new JLabel("Update Batch");
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
		
		//row1
		row1 = new JPanel();
		row1.setLayout(new FlowLayout(FlowLayout.CENTER));
		row1.setBackground(new Color(244,245,254));
		row1.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));
		
		batchNameTxt = new JTextField(20);
		batchNameTxt.setFont(new Font("",1,15));
		batchNameTxt.setBackground(new Color(244,245,254));
		batchNameTxt.setPreferredSize(new Dimension(200, 35));
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("",1,15));
		searchBtn.setPreferredSize(new Dimension(100, 35));
		searchBtn.setBackground(new Color(28, 34, 80));
		searchBtn.setForeground(new Color(255, 255, 255));
	
		row1.add(batchNameTxt);
		row1.add(searchBtn);
		
		centerPanel.add(row1);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				for(int i=0 ; i<Details.batchArray.length ; i++){
					if(batchNameTxt.getText().equals(Integer.toString(Details.batchArray[i].getBatchName()))){
						final int index = i;
						
						batchNameTxt.setEditable(false);
						searchBtn.setEnabled(false);
						
						//row2
						row2 = new JPanel();
						row2.setLayout(new BorderLayout());
						row2.setBorder(BorderFactory.createEmptyBorder(30,20,10,350));
						row2.setBackground(new Color(244,245,254));
						
						studentCountLbl = new JLabel("Student Count");
						studentCountLbl.setFont(new Font("",1,15));
						studentCountLbl.setPreferredSize(new Dimension(170, 50));
						
						int count=0;
						for(int j=0 ; j<Details.studentArray.length ; j++){
							if(Details.studentArray[j].getRegNo().substring(4,7).equals(batchNameTxt.getText())){
								count++;
							}
						}
						
						studentCountTxt = new JTextField();
						studentCountTxt.setFont(new Font("",1,15));
						studentCountTxt.setBackground(new Color(244,245,254));
						
						studentCountTxt.setText(Integer.toString(count));
						studentCountTxt.setEditable(false);
						row2.add(studentCountLbl, BorderLayout.WEST);
						row2.add(studentCountTxt, BorderLayout.CENTER);
						
						//row3
						row3 = new JPanel();
						row3.setLayout(new BorderLayout());
						row3.setBorder(BorderFactory.createEmptyBorder(0,20,70,350));
						row3.setBackground(new Color(244,245,254));
						
						statusLbl = new JLabel("Current Status");
						statusLbl.setFont(new Font("",1,15));
						statusLbl.setPreferredSize(new Dimension(170, 50));
						
						radioPanel = new JPanel();
						radioPanel.setLayout(new BorderLayout());
						radioPanel.setBackground(new Color(244,245,254));
						
						enrolOpenRadioBtn = new JRadioButton("Enrollment Open");
						enrolOpenRadioBtn.setFont(new Font("",1,15));
						enrolOpenRadioBtn.setBackground(new Color(244,245,254));
						
						enrolCloseRadioBtn = new JRadioButton("Enrollment Close");
						enrolCloseRadioBtn.setFont(new Font("",1,15));
						enrolCloseRadioBtn.setBackground(new Color(244,245,254));
						
						if(Details.batchArray[index].getBatchStatus()==1){
							enrolOpenRadioBtn.setSelected(true);
						}else if(Details.batchArray[index].getBatchStatus()==0){
							enrolCloseRadioBtn.setSelected(true);
						}
						
						enrolGroup = new ButtonGroup();
						enrolGroup.add(enrolOpenRadioBtn);
						enrolGroup.add(enrolCloseRadioBtn);
						
						radioPanel.add(enrolOpenRadioBtn, BorderLayout.WEST);
						radioPanel.add(enrolCloseRadioBtn, BorderLayout.EAST);
						
						row3.add(statusLbl, BorderLayout.WEST);
						row3.add(radioPanel, BorderLayout.CENTER);
						
						//row4
						row4 = new JPanel();
						row4.setLayout(new FlowLayout(FlowLayout.CENTER));
						row4.setBackground(new Color(244,245,254));
						
						updateBtn = new JButton("Update");
						updateBtn.setFont(new Font("",1,15));
						updateBtn.setBackground(new Color(28, 34, 80));
						updateBtn.setForeground(new Color(255, 255, 255));
						updateBtn.setPreferredSize(new Dimension(200, 40));
						updateBtn.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent evt){
								int enrollment=-1;
								if(enrolOpenRadioBtn.isSelected()){
									enrollment=1;
								}else if(enrolCloseRadioBtn.isSelected()){
									enrollment=0;
								}
								
								if(Details.batchArray[index].getBatchStatus()!=enrollment){
									Details.batchArray[index].setBatchStatus(enrollment);
									JOptionPane.showMessageDialog(null, "Batch Status Updated Successfully...");
								}
							}
						});
						row4.add(updateBtn);
						
						centerPanel.add(row2);
						centerPanel.add(Box.createRigidArea(new Dimension(0,10)));
						centerPanel.add(row3);
						centerPanel.add(Box.createRigidArea(new Dimension(0,70)));
						centerPanel.add(row4);
						centerPanel.add(Box.createRigidArea(new Dimension(0,50)));
						
						revalidate();
						repaint();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Invalid Batch Name...");
			}
		});
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
}
