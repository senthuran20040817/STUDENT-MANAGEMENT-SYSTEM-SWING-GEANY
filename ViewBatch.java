import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
class ViewBatch extends JFrame{
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
	
	ViewBatch(){
		setSize(900,600);
		setTitle("View Batch Details");
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
		
		topicLbl = new JLabel("View Batch Details");
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
		centerPanel.setBorder(BorderFactory.createEmptyBorder(30,20,0,20));
		
		//table
		String[] columnNames = {"No.", "Batch No.", "Student Count", "Max Student Count", "Status"};
		dtm = new DefaultTableModel(columnNames , 0);
		batchTable = new JTable(dtm);
		for(int i=0 ; i<Details.batchArray.length ; i++){
			int count=0;
			for(int j=0 ; j<Details.studentArray.length ; j++){
				if(Details.studentArray[j].getRegNo().substring(4,7).equals(Integer.toString(Details.batchArray[i].getBatchName()))){
					count++;
				}
			}
			Object[] rowData = {
								i+1,
								Details.batchArray[i].getBatchName(),
								count,
								Details.batchArray[i].getBatchMaxCount(),
								Details.batchArray[i].getBatchStatus()==1 ? "Enrollment Open" : Details.batchArray[i].getBatchStatus()==0 ? "Enrollment Closed" : "none"
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
