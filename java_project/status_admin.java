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
import java.awt.Image;
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
		show_btn.setBackground(new Color(135, 206, 250));
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
		show_btn.setBounds(567, 306, 174, 47);
		contentPane.add(show_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 363, 585, 213);
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
		updatebtn.setBackground(new Color(144, 238, 144));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 1043, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATUS");
		ImageIcon image = new ImageIcon(new ImageIcon("/Users/dheer/eclipse-workspace/EHUB/src/profile.jpeg").getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
		lblNewLabel.setBounds(94, 10, 895, 97);
		lblNewLabel.setIcon(image);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(127, 255, 212));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton backbtn = new JButton("BACK");
		backbtn.setBackground(new Color(255, 165, 0));
		backbtn.setBounds(884, 117, 104, 39);
		panel.add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_home obj=new admin_home();
				obj.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(60, 179, 113));
		comboBox.setBounds(73, 118, 158, 39);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(10, 214, 346, 428);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		stat = new JTextField();
		stat.setBounds(26, 169, 228, 39);
		panel_1.add(stat);
		stat.setColumns(10);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.setBackground(new Color(220, 20, 60));
		deletebtn.setBounds(189, 279, 131, 39);
		panel_1.add(deletebtn);
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
		fillcomboBox();
		}
}
