import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;


public class purschase extends JFrame {
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purschase frame = new purschase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
	public void fillcomboBox()
	{
		try {
			String  query="select * from software";
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				comboBoxname.addItem(rs.getString("s_id"));
			}
			rs.close();
			stmt.close();		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"show  problem!");
			e1.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	String order_id;
	Connection conn = null;
	private JTable table;
	private JTextField s_idfield;
	private JComboBox comboBoxname;

	public purschase() {
		conn=postconnection.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 704);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(501, 306, 517, 217);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton showproductsbtn = new JButton("Click for products list");
		showproductsbtn.setBackground(new Color(255, 182, 193));
		showproductsbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showproductsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select s_id,s_name,price from software";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					stmt.close();		}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		showproductsbtn.setBounds(643, 255, 171, 41);
		contentPane.add(showproductsbtn);
		
		s_idfield = new JTextField();
		s_idfield.setBackground(new Color(211, 211, 211));
		s_idfield.setBounds(69, 412, 222, 35);
		contentPane.add(s_idfield);
		s_idfield.setColumns(10);
		
		JButton buybtn = new JButton("BUY");
		buybtn.setBackground(new Color(50, 205, 50));
		buybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login_client obj=new login_client();
					String orde = null;
					
				     
					
					String  incr="SELECT * FROM increment ORDER BY increment DESC LIMIT 1";
					PreparedStatement stmt=conn.prepareStatement(incr);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						orde=rs.getString("increment");
					}
					String ord="o-"+orde;
					rs.close();
					stmt.close();
					int i=(Integer.parseInt(orde))+1;
					String  incre="insert into increment values(?)";
					PreparedStatement stmt1=conn.prepareStatement(incre);
					stmt1.setInt(1,i);
					stmt1.execute();
					stmt1.close();
					String  query="insert into order_details(order_id,client_id,s_id) values(?,?,?)";
					PreparedStatement stmt11=conn.prepareStatement(query);
					
					stmt11.setString(1,ord);
					stmt11.setString(2,obj.user_id);
					stmt11.setString(3,(String)comboBoxname.getSelectedItem());
					stmt11.execute();
					
					
					stmt11.close();	
					
					JOptionPane.showMessageDialog(null,"purchased");
					
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
				
			}
		});
		buybtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		buybtn.setBounds(105, 457, 130, 41);
		contentPane.add(buybtn);
		
		 comboBoxname = new JComboBox();
		 comboBoxname.setBackground(Color.PINK);
		 comboBoxname.setFont(new Font("Tahoma", Font.BOLD, 13));
		 comboBoxname.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			
					String  query="select * from software where s_id=?";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.setString(1,(String)comboBoxname.getSelectedItem());
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						s_idfield.setText(rs.getString("s_name"));
						
					}
					rs.close();
					stmt.close();		}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
		 	}
		 });
		comboBoxname.setBounds(78, 307, 186, 35);
		contentPane.add(comboBoxname);
		
		JLabel lblNewLabel = new JLabel("select id of software");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 262, 212, 35);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 1148, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("purchase_pg");
		ImageIcon image = new ImageIcon(new ImageIcon("/Users/dheer/eclipse-workspace/EHUB/src/buy.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel_1.setBounds(22, 10, 1096, 111);
		lblNewLabel_1.setIcon(image);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(147, 112, 219));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton backbtn = new JButton("BACK");
		backbtn.setBounds(37, 146, 158, 51);
		panel.add(backbtn);
		backbtn.setBackground(new Color(255, 255, 0));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					client_home obj=new client_home();
					obj.setVisible(true);
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton statusbtn = new JButton("STATUS");
		statusbtn.setBounds(950, 131, 171, 61);
		panel.add(statusbtn);
		statusbtn.setBackground(new Color(173, 216, 230));
		statusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					status_client obj=new status_client();
					obj.setVisible(true);
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		statusbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(10, 238, 322, 419);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		fillcomboBox();
	}
}
