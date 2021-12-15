import java.awt.BorderLayout;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.*; import javax.swing.*;
public class status_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					status_admin frame = new status_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//edit
	public void fillcomboBox()
	{
		try {
			String  query="select * from order_details";
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				comboBox.addItem(rs.getString("order_id"));
			}
			rs.close();
			stmt.close();		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"show  problem!");
			e1.printStackTrace();
		}
	}
	boolean x=false;
	private JTable table;
	private JComboBox comboBox;
	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTextField dateofc;
	private JTextField dateofr;
	private JTextField stat;
	
	//constructor
	public status_admin() {
		conn=postconnection.dbconnector();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton show_btn = new JButton("Show status");
		show_btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select * from order_details";
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
		show_btn.setBounds(508, 194, 137, 30);
		contentPane.add(show_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 234, 585, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		dateofc = new JTextField();
		dateofc.setBounds(37, 239, 131, 39);
		contentPane.add(dateofc);
		dateofc.setColumns(10);
		
		dateofr = new JTextField();
		dateofr.setBounds(37, 303, 131, 39);
		contentPane.add(dateofr);
		dateofr.setColumns(10);
		
		stat = new JTextField();
		stat.setBounds(37, 375, 137, 39);
		contentPane.add(stat);
		stat.setColumns(10);
		
		JLabel doc = new JLabel("DOC");
		doc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doc.setBounds(77, 222, 45, 13);
		contentPane.add(doc);
		
		JLabel dor = new JLabel("DOR");
		dor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dor.setBounds(92, 288, 45, 13);
		contentPane.add(dor);
		
		JLabel status = new JLabel("Status");
		status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		status.setBounds(77, 364, 45, 13);
		contentPane.add(status);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="UPDATE order_details SET  date_of_commencement='"+dateofc.getText()+"',date_of_release='"+dateofr.getText()+"',status='"+stat.getText()+"' where order_id='"+(String)comboBox.getSelectedItem()+"' ";
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
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		updatebtn.setBounds(37, 494, 131, 39);
		contentPane.add(updatebtn);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="DELETE FROM order_details  where order_id='"+(String)comboBox.getSelectedItem()+"' ";
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
		deletebtn.setBounds(37, 543, 131, 39);
		contentPane.add(deletebtn);
		
		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_home obj=new admin_home();
				obj.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		backbtn.setBounds(44, 69, 104, 39);
		contentPane.add(backbtn);
		
		comboBox = new JComboBox();
		comboBox.setBounds(37, 143, 158, 39);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 10, 984, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATUS");
		lblNewLabel.setBounds(360, 21, 213, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(127, 255, 212));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fillcomboBox();
		}
}
