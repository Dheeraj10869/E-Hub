import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*; import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee frame = new employee();
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
			String  query="select * from employee";
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				comboBox.addItem(rs.getString("e_id"));
			}
			rs.close();
			stmt.close();		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"show  problem!");
			e1.printStackTrace();
		}
	}
	public void fillcomboBox_1()
	{
		try {
			String  query="select * from software";
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				comboBox_1.addItem(rs.getString("s_id"));
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
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JDateChooser dateChooser;
	Connection conn = null;
	private JTable table;
	private JTextField fname;
	private JTextField lname;
	private JTextField qual;
	private JTextField spec;
	public employee() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1318, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 201, 1294, 536);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 124, 649, 277);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton getbtn = new JButton("GET DETAILS");
		getbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select * from employee";
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
		getbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		getbtn.setBounds(557, 68, 210, 42);
		panel.add(getbtn);
		
		fname = new JTextField();
		fname.setBounds(127, 10, 154, 32);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(127, 68, 154, 32);
		panel.add(lname);
		
		qual = new JTextField();
		qual.setColumns(10);
		qual.setBounds(127, 117, 154, 32);
		panel.add(qual);
		
		spec = new JTextField();
		spec.setColumns(10);
		spec.setBounds(127, 170, 154, 32);
		panel.add(spec);
		
		JLabel lblNewLabel_1 = new JLabel("FNAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 13, 81, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LNAME:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 68, 81, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Qualification");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(10, 126, 81, 22);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Speclization");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(10, 170, 81, 22);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date of join");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 234, 81, 22);
		panel.add(lblNewLabel_1_4);
		
		JButton hirebtn = new JButton("HIRE");
		hirebtn.setBackground(new Color(50, 205, 50));
		hirebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String orde = null;
					String  incr="SELECT * FROM empincrement ORDER BY increment DESC LIMIT 1";
					PreparedStatement stmt=conn.prepareStatement(incr);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						orde=rs.getString("increment");
					}
					String ord="E-"+orde;
					rs.close();
					stmt.close();
					
					
					
  String  query="insert into employee(e_id,fname,lname,qualification,specialization,doj) values(?,?,?,?,?,'"+dateChooser.getDate()+"')";
						PreparedStatement stmt11=conn.prepareStatement(query);
						 
						stmt11.setString(1,ord);
						stmt11.setString(2,fname.getText());
						stmt11.setString(3,lname.getText());
						stmt11.setString(4,qual.getText());
						stmt11.setString(5,spec.getText());
					
						
						
						stmt11.execute();
						stmt11.close();
						
						
						JOptionPane.showMessageDialog(null,"your e_id : "+ord);
						
						
								
					
				
						int i=(Integer.parseInt(orde))+1;
						String  incre="insert into empincrement values(?)";
						PreparedStatement stmt1=conn.prepareStatement(incre);
						stmt1.setInt(1,i);
						stmt1.execute();
						stmt1.close();
					
					
					
					
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();

				}
			}
		});
		hirebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		hirebtn.setBounds(10, 295, 119, 32);
		panel.add(hirebtn);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.setBackground(new Color(135, 206, 250));
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="UPDATE employee SET  fname='"+fname.getText()+"',lname='"+lname.getText()+"',qualification='"+qual.getText()+"',specialization='"+spec.getText()+"',doj='"+dateChooser.getDate()+"' where e_id='"+(String)comboBox.getSelectedItem()+"' ";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.execute();
					JOptionPane.showMessageDialog(null,"updated");
					stmt.close();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();

				}
			}
		});
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		updatebtn.setBounds(174, 295, 119, 32);
		panel.add(updatebtn);
		
		JButton firebtn = new JButton("FIRE");
		firebtn.setBackground(new Color(220, 20, 60));
		firebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="DELETE FROM employee  where e_id='"+(String)comboBox.getSelectedItem()+"' ";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.execute();
					JOptionPane.showMessageDialog(null,"Deleted");
					stmt.close();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"delete  problem");
					ex.printStackTrace();

				}
			}
		});
		firebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		firebtn.setBounds(10, 362, 119, 32);
		panel.add(firebtn);
		
		JButton setbtn = new JButton("ADD TO TEAM");
		setbtn.setBackground(new Color(250, 128, 114));
		setbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="UPDATE employee SET  s_id='"+(String)comboBox_1.getSelectedItem()+"' where e_id='"+(String)comboBox.getSelectedItem()+"' ";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.execute();
					JOptionPane.showMessageDialog(null,"updated");
					stmt.close();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();

				}
			}
		});
		setbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		setbtn.setBounds(175, 365, 118, 31);
		panel.add(setbtn);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 234, 150, 32);
		panel.add(dateChooser);
		
		JButton getempbtn = new JButton("GET");
		getempbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              try {
					String  query="select * from employee where e_id='"+(String)comboBox.getSelectedItem()+"'";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						dateChooser.setDate(rs.getDate("doj"));
						fname.setText(rs.getString("fname"));
						lname.setText(rs.getString("lname"));
						qual.setText(rs.getString("qualification"));
						spec.setText(rs.getString("specialization"));
						
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
		getempbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		getempbtn.setBounds(110, 424, 126, 32);
		panel.add(getempbtn);
		
		JLabel lblNewLabel = new JLabel("TECHOSS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(369, 10, 663, 50);
		contentPane.add(lblNewLabel);
		
		 comboBox = new JComboBox();
		 comboBox.setBackground(new Color(189, 183, 107));
		comboBox.setBounds(38, 102, 237, 50);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(222, 184, 135));
		comboBox_1.setBounds(318, 97, 223, 55);
		contentPane.add(comboBox_1);
		
		JButton homebtn = new JButton("HOME");
		homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_home obj=new admin_home();
				obj.setVisible(true);
			}
		});
		homebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		homebtn.setBounds(1130, 130, 136, 50);
		contentPane.add(homebtn);
		
		fillcomboBox();
		fillcomboBox_1();
	}
}
