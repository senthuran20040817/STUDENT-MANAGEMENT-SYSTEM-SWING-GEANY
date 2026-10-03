import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class PrfMarkUpdate extends JFrame{
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
	private JPanel row3;
	private JPanel row4;
	private JLabel nameLbl;
	private JTextField nameTxt;
	private JLabel nicLbl;
	private JTextField nicTxt;
	private JLabel prfLbl;
	private JTextField prfTxt;
	private JLabel newPrfLbl;
	private JTextField newPrfTxt;
	private JPanel updateBtnPanel;
	private JButton updateBtn;
	
	PrfMarkUpdate(){
		setSize(900,600);
		setTitle("PRF Mark Update");
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
		
		topicLbl = new JLabel("PRF Mark Update");
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
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 50));
		
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
		
		centerPanel.add(idPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				for(int i=0 ; i<Details.studentArray.length ; i++){
					if(Details.studentArray[i].getRegNo().equals(regNoTxt.getText())){
						
						regNoTxt.setEditable(false);
						searchBtn.setEnabled(false);
						
						//details panel
						detailsPanel = new JPanel();
						detailsPanel.setLayout(new BoxLayout(detailsPanel,BoxLayout.Y_AXIS));
						detailsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 250));
						detailsPanel.setBackground(new Color(244,245,254));
						
						//row1
						row1 = new JPanel();
						row1.setLayout(new BorderLayout());
						row1.setBackground(new Color(244,245,254));
						
						nameLbl = new JLabel("Student Name");
						nameLbl.setFont(new Font("",1,15));
						nameLbl.setPreferredSize(new Dimension(130, 25));
						
						nameTxt = new JTextField();
						nameTxt.setFont(new Font("",1,15));
						nameTxt.setPreferredSize(new Dimension(130, 25));
						nameTxt.setBackground(new Color(244,245,254));
						
						row1.add(nameLbl, BorderLayout.WEST);
						row1.add(nameTxt, BorderLayout.CENTER);
						
						//row2
						row2 = new JPanel();
						row2.setLayout(new BorderLayout());
						row2.setBackground(new Color(244,245,254));
						
						nicLbl = new JLabel("Student NIC No");
						nicLbl.setFont(new Font("",1,15));
						nicLbl.setPreferredSize(new Dimension(130, 25));
						
						nicTxt = new JTextField();
						nicTxt.setFont(new Font("",1,15));
						nicTxt.setBackground(new Color(244,245,254));
						
						row2.add(nicLbl, BorderLayout.WEST);
						row2.add(nicTxt, BorderLayout.CENTER);
						
						//row3
						row3 = new JPanel();
						row3.setLayout(new BorderLayout());
						row3.setBackground(new Color(244,245,254));
						
						prfLbl = new JLabel("PRF Marks");
						prfLbl.setFont(new Font("",1,15));
						prfLbl.setPreferredSize(new Dimension(130, 25));
						
						prfTxt = new JTextField();
						prfTxt.setFont(new Font("",1,15));
						prfTxt.setBackground(new Color(244,245,254));
						
						row3.add(prfLbl, BorderLayout.WEST);
						row3.add(prfTxt, BorderLayout.CENTER);
						
						//row4
						row4 = new JPanel();
						row4.setLayout(new BorderLayout());
						row4.setBackground(new Color(244,245,254));
						
						newPrfLbl = new JLabel("New PRF Marks");
						newPrfLbl.setFont(new Font("",1,15));
						newPrfLbl.setPreferredSize(new Dimension(130, 25));
						
						newPrfTxt = new JTextField();
						newPrfTxt.setFont(new Font("",1,15));
						newPrfTxt.setBackground(new Color(244,245,254));
						
						row4.add(newPrfLbl, BorderLayout.WEST);
						row4.add(newPrfTxt, BorderLayout.CENTER);
						
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 40)));
						detailsPanel.add(row1);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						detailsPanel.add(row2);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						detailsPanel.add(row3);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 30)));
						detailsPanel.add(row4);
						detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
						
						updateBtnPanel = new JPanel();
						updateBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
						updateBtnPanel.setBackground(new Color(244,245,254));
						
						updateBtn = new JButton("Update");
						updateBtn.setFont(new Font("",1,20));
						updateBtn.setBackground(new Color(28, 34, 80));
						updateBtn.setForeground(new Color(255, 255, 255));
						updateBtn.setPreferredSize(new Dimension(230, 40));
						updateBtn.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent evt){
								if(!newPrfTxt.getText().equals("")){
									for(int i=0 ; i<Details.studentArray.length ; i++){
										if(Details.studentArray[i].getRegNo().equals(regNoTxt.getText())){
											Details.studentArray[i].setPrfMark(Integer.parseInt(newPrfTxt.getText()));
											newPrfTxt.setEditable(false);
											JOptionPane.showMessageDialog(null, "PRF Marks updated Successfully...");
										}
									}
								}
							}
						});
						
						updateBtnPanel.add(updateBtn);
						centerPanel.add(detailsPanel);
						centerPanel.add(updateBtnPanel);
						
						nameTxt.setText(Details.studentArray[i].getName());
						nicTxt.setText(Details.studentArray[i].getNic());
						prfTxt.setText(Details.studentArray[i].getPrfMark()==-1 ? "absent" : Details.studentArray[i].getPrfMark()==-2 ? "not conducted" : Integer.toString(Details.studentArray[i].getPrfMark()));
						
						nameTxt.setEditable(false);
						nicTxt.setEditable(false);
						prfTxt.setEditable(false);
						
						revalidate();
						repaint();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Invalid Student ID");
			}
		});
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
}
