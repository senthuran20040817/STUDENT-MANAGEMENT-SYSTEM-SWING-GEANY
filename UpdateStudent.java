import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class UpdateStudent extends JFrame{
	private JPanel topPanel;
	private ImageIcon originalLogo;
	private Image tempLogo;
	private ImageIcon logo;
	private JLabel logoLbl;
	private JLabel topicLbl;
	private JPanel bottomPanel;
	private JPanel idPanel;
	private JPanel centerPanel;
	private JTextField regNoTxt;
	private JButton searchBtn;
	private JPanel detailsPanel;
	private JPanel row1;
	private JPanel row2;
	private JLabel nameLbl;
	private JLabel nicLbl;
	private JTextField nameTxt;
	private JTextField nicTxt;
	private JPanel updateBtnPanel;
	private JButton updateBtn;
	
	UpdateStudent(){
		setSize(900,600);
		setTitle("Update Student");
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
		
		topicLbl = new JLabel("Update Student");
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
		
		idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		idPanel.setBackground(new Color(244,245,254));
		
		regNoTxt = new JTextField("Enter the Student ID here");
		regNoTxt.setFont(new Font("",1,15));
		regNoTxt.setPreferredSize(new Dimension(250,40));
		regNoTxt.setBackground(new Color(244,245,254));
		
		searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("",1,15));
		searchBtn.setPreferredSize(new Dimension(100,40));
		searchBtn.setBackground(new Color(28, 34, 80));
		searchBtn.setForeground(new Color(255, 255, 255));
		
		idPanel.add(regNoTxt);
		idPanel.add(searchBtn);
		
		centerPanel.add(Box.createRigidArea(new Dimension(0,40)));
		centerPanel.add(idPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                for(int i=0 ; i<Details.studentArray.length ; i++){
					if(regNoTxt.getText().equals(Details.studentArray[i].getRegNo())){
						final int index = i;
						
						regNoTxt.setEditable(false);  //make a text field un editable
						searchBtn.setEnabled(false);  //make a button to not responding
						
						//details panel
						detailsPanel = new JPanel();
						detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
						detailsPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 120, 350));
						detailsPanel.setBackground(new Color(244,245,254));
						
						//row1
						row1 = new JPanel();
						row1.setLayout(new BorderLayout());
						row1.setBackground(new Color(244,245,254));
						
						nameLbl = new JLabel("Student Name");
						nameLbl.setFont(new Font("",1,15));
						nameLbl.setPreferredSize(new Dimension(120, 25));
						
						nameTxt = new JTextField();
						nameTxt.setFont(new Font("",1,15));
						nameTxt.setText(Details.studentArray[index].getName());
						nameTxt.setPreferredSize(new Dimension(120, 25));
						nameTxt.setBackground(new Color(244,245,254));
						
						row1.add(nameLbl,BorderLayout.WEST);
						row1.add(nameTxt, BorderLayout.CENTER);
						
						//row2
						row2 = new JPanel();
						row2.setLayout(new BorderLayout());
						row2.setBackground(new Color(244,245,254));
						
						nicLbl = new JLabel("NIC No");
						nicLbl.setFont(new Font("",1,15));
						nicLbl.setPreferredSize(new Dimension(120, 25));
						
						nicTxt = new JTextField();
						nicTxt.setFont(new Font("",1,15));
						nicTxt.setText(Details.studentArray[index].getNic());
						nicTxt.setBackground(new Color(244,245,254));
						
						row2.add(nicLbl, BorderLayout.WEST);
						row2.add(nicTxt, BorderLayout.CENTER);
						
						detailsPanel.add(row1);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
						detailsPanel.add(row2);
						
						//update button panel
						updateBtnPanel = new JPanel();
						updateBtnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
						updateBtnPanel.setBackground(new Color(244,245,254));
						
						updateBtn = new JButton("Update Details");
						updateBtn.setFont(new Font("",1,15));
						updateBtn.setPreferredSize(new Dimension(200,40));
						updateBtn.setBackground(new Color(28, 34, 80));
						updateBtn.setForeground(new Color(255, 255, 255));
						updateBtn.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent evt){
								if(!nameTxt.getText().equals(Details.studentArray[index].getName()) || !nicTxt.getText().equals(Details.studentArray[index].getNic())){
									Details.studentArray[index].setName(nameTxt.getText());
									Details.studentArray[index].setNic(nicTxt.getText());
									JOptionPane.showMessageDialog(null,"Student Details Updated Successfully...");
								}
							}
						});
						
						updateBtnPanel.add(updateBtn);
						
						centerPanel.add(Box.createRigidArea(new Dimension(0,30)));
						centerPanel.add(detailsPanel);
						centerPanel.add(updateBtnPanel);
						
						revalidate();
						repaint();
						return;
					}
				}
                JOptionPane.showMessageDialog(null,"This StudentId Does not exist in the system...");
			}
		});
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));
	}
}
