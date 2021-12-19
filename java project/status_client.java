import java.awt.BorderLayout;
import java.sql.*;
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
public class status_client extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					status_client frame = new status_client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//edit
	
	boolean x=false;
	private JTable table;

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	
	//constructor
	public status_client() {
		conn=postconnection.dbconnector();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 779);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton show_btn = new JButton("Show status");
		show_btn.setBackground(new Color(144, 238, 144));
		show_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login_client obj=new login_client();
					
					String  query="select * from order_details where client_id='"+obj.user_id+"'";
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
		show_btn.setBounds(601, 294, 166, 56);
		contentPane.add(show_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 360, 815, 321);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton backbtn = new JButton("HOME");
		backbtn.setBackground(new Color(173, 216, 230));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					client_home obj1=new client_home();
					obj1.setVisible(true);
					
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(65, 235, 132, 56);
		contentPane.add(backbtn);
		
		JLabel lblNewLabel_1 = new JLabel("");		
		lblNewLabel_1.setBounds(0, 197, 1337, 551);
		ImageIcon image2 = new ImageIcon(new ImageIcon("C:\\\\Users\\\\dheer\\\\Downloads\\\\code.jpeg").getImage().getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_DEFAULT)); 
		  lblNewLabel_1 .setIcon(image2);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1337, 201);
		ImageIcon image21 = new ImageIcon(new ImageIcon("C:\\\\Users\\\\dheer\\\\Downloads\\\\status-2.png").getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT)); 
		  lblNewLabel.setIcon(image21);
		contentPane.add(lblNewLabel);
	}
}
