import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddStudent extends JFrame{
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
	private JComboBox batchNameComboBox;
	private JPanel row2;
	private JLabel nicLbl;
	private JTextField nicTxt;
	private JPanel row3;
	private JLabel nameLbl;
	private JTextField nameTxt;
	private JPanel row4;
	private JLabel enrollmentTypeLbl;
	private JComboBox enrollmentTypesComboBox;
	private JPanel btnPanel;
	private JButton addBtn;
	private JButton cancelBtn;
	
	AddStudent(){
		setSize(900,600);
		setTitle("Add Student");
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
		
		topicLbl = new JLabel("Add Student");
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
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
		centerPanel.setBackground(new Color(244,245,254));
		
		//center panel --> form panel
		formPanel = new JPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		formPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,200));
		formPanel.setBackground(new Color(244,245,254));
		
		//row1
		row1 = new JPanel();
		row1.setLayout(new BorderLayout(10,0));
		row1.setBackground(new Color(244,245,254));
		row1.setBorder(BorderFactory.createEmptyBorder(0,0,0,200));
		
		batchNameLbl = new JLabel("Batch Name");
		batchNameLbl.setFont(new Font("",1,15));
		batchNameLbl.setPreferredSize(new Dimension(150, 25));
		
		String[] batchNameArray = {"---Select a batch---"};
		for(int i=0 ; i<Details.batchArray.length ; i++){
			if(Details.batchArray[i].getBatchStatus()==1){
				String[] temp=new String[batchNameArray.length+1];
				for(int j=0 ; j<batchNameArray.length ; j++){
					temp[j]=batchNameArray[j];
				}
				temp[batchNameArray.length] = Integer.toString(Details.batchArray[i].getBatchName());
				batchNameArray=temp;
			}
		}
		batchNameComboBox = new JComboBox(batchNameArray);
		batchNameComboBox.setFont(new Font("",1,12));
		batchNameComboBox.setBackground(new Color(244,245,254));
		
		row1.add(batchNameLbl, BorderLayout.WEST);
		row1.add(batchNameComboBox, BorderLayout.CENTER);
		
		//row2
		row2 = new JPanel();
		row2.setLayout(new BorderLayout(10,0));
		row2.setBackground(new Color(244,245,254));
		row2.setBorder(BorderFactory.createEmptyBorder(0,0,0,200));
		
		nicLbl = new JLabel("Student NIC No");
		nicLbl.setFont(new Font("",1,15));
		nicLbl.setPreferredSize(new Dimension(150, 25));
		
		nicTxt = new JTextField();
		nicTxt.setFont(new Font("",1,15));
		nicTxt.setBackground(new Color(244,245,254));
		
		row2.add(nicLbl, BorderLayout.WEST);
		row2.add(nicTxt, BorderLayout.CENTER);
		
		//row3
		row3 = new JPanel();
		row3.setLayout(new BorderLayout(10,0));
		row3.setBackground(new Color(244,245,254));
		
		nameLbl = new JLabel("Student Name");
		nameLbl.setFont(new Font("",1,15));
		nameLbl.setPreferredSize(new Dimension(150, 25));
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("",1,15));
		nameTxt.setBackground(new Color(244,245,254));
		
		row3.add(nameLbl, BorderLayout.WEST);
		row3.add(nameTxt, BorderLayout.CENTER);
		
		//row4
		row4 = new JPanel();
		row4.setLayout(new BorderLayout(10,0));
		row4.setBackground(new Color(244,245,254));
		row4.setBorder(BorderFactory.createEmptyBorder(0,0,0,200));
		
		JLabel enrollmentTypeLbl = new JLabel("Enrollment Type");
		enrollmentTypeLbl.setFont(new Font("",1,15));
		enrollmentTypeLbl.setPreferredSize(new Dimension(150, 25));
		
		String[] enrollmentTypesArray = {"---Select a lecture mode---","Physical","Online"};
		enrollmentTypesComboBox = new JComboBox(enrollmentTypesArray);
		enrollmentTypesComboBox.setFont(new Font("",1,12));
		enrollmentTypesComboBox.setBackground(new Color(244,245,254));
		
		row4.add(enrollmentTypeLbl, BorderLayout.WEST);
		row4.add(enrollmentTypesComboBox, BorderLayout.CENTER);
		
		formPanel.add(Box.createRigidArea(new Dimension(0,15)));
		formPanel.add(row1);
		formPanel.add(Box.createRigidArea(new Dimension(0,15)));
		formPanel.add(row2);
		formPanel.add(Box.createRigidArea(new Dimension(0,15)));
		formPanel.add(row3);
		formPanel.add(Box.createRigidArea(new Dimension(0,15)));
		formPanel.add(row4);
		formPanel.add(Box.createRigidArea(new Dimension(0,15)));
		
		//center panel --> button panel
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 0));
		btnPanel.setBackground(new Color(244,245,254));
		
		//add button
		addBtn = new JButton("Add Details");
		addBtn.setFont(new Font("",1,15));
		addBtn.setPreferredSize(new Dimension(250, 40));
		addBtn.setBackground(new Color(202, 210, 251));
		addBtn.setForeground(new Color(28, 34, 80));
		addBtn.setBorderPainted(false);
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				for(int i=0 ; i<Details.studentArray.length ; i++){
					if(Details.studentArray[i].getNic().equals(nicTxt.getText())){
						JOptionPane.showMessageDialog(null,"This NIC No already exists...");
						return;
					}
				}
				if(!nicTxt.getText().equals("") && !nameTxt.getText().equals("") && !batchNameComboBox.getSelectedItem().equals("---Select a batch---") && !enrollmentTypesComboBox.getSelectedItem().equals(enrollmentTypesArray[0])){
					nameTxt.setEditable(false);
					nicTxt.setEditable(false);
					enrollmentTypesComboBox.setEnabled(false);
					batchNameComboBox.setEnabled(false);
					
					int count = 0;
					for(int i=0 ; i<Details.studentArray.length ; i++){
						if((Details.studentArray[i].getRegNo().substring(4,7)).equals(batchNameComboBox.getSelectedItem())){
							count++;
						}
					}
					count++;
					String id = (enrollmentTypesComboBox.getSelectedItem().equals("Physical") ? "PR" : "OR") + 24 + batchNameComboBox.getSelectedItem() + String.format("%03d",count);
					Student[] tempStudentArray = new Student[Details.studentArray.length+1];
					for(int i=0 ; i<Details.studentArray.length ; i++){
						tempStudentArray[i]=Details.studentArray[i];
					}
					tempStudentArray[Details.studentArray.length]=new Student(id, nicTxt.getText(), nameTxt.getText(), -2, -2);
					Details.studentArray = tempStudentArray;
					JOptionPane.showMessageDialog(null,"Student successfully added to the system...");
					
					for(int i=0 ; i<Details.batchArray.length ; i++){
						if(batchNameComboBox.getSelectedItem().equals(Integer.toString(Details.batchArray[i].getBatchName()))){
							if(count==Details.batchArray[i].getBatchMaxCount()){
								Details.batchArray[i].setBatchStatus(0);
							}
						}
					}
				}
			}
		});
		btnPanel.add(addBtn);
		
		//cancel button
		cancelBtn = new JButton("Cancel");
		cancelBtn.setFont(new Font("",1,15));
		cancelBtn.setPreferredSize(new Dimension(250, 40));
		cancelBtn.setBackground(new Color(202, 210, 251));
		cancelBtn.setForeground(new Color(28, 34, 80));
		cancelBtn.setBorderPainted(false);
		cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				batchNameComboBox.setSelectedIndex(0);
				nicTxt.setText("");
				nameTxt.setText("");
				enrollmentTypesComboBox.setSelectedIndex(0);
			}
		});
		btnPanel.add(cancelBtn);
		
		
		centerPanel.add(formPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0,140)));
		centerPanel.add(btnPanel);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
}
