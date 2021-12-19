import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*; import javax.swing.*;
public class client_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_home frame = new client_home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	public client_home() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1291, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton orderbtn = new JButton("ORDER");
		orderbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					purschase obj=new purschase();
					obj.setVisible(true);
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		orderbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		orderbtn.setBounds(98, 529, 275, 86);
		contentPane.add(orderbtn);
		
		JButton statusbtn = new JButton("STATUS");
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
		statusbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		statusbtn.setBounds(521, 529, 287, 94);
		contentPane.add(statusbtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(968, 27, 287, 665);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton profilebtn = new JButton("profile");
		profilebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				client_profile obj=new client_profile();
				obj.setVisible(true);
			}
		});
		profilebtn.setBounds(79, 126, 135, 33);
		panel.add(profilebtn);
		
		JButton logoutbtn = new JButton("LOGOUT");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JOptionPane.showMessageDialog(null,"log outed!");
				login_client obj1=new login_client();
				obj1.setVisible(true);
			}
		});
		logoutbtn.setBounds(79, 261, 135, 33);
		panel.add(logoutbtn);
		
		JButton btnContactUs = new JButton("contact us");
		btnContactUs.setBounds(79, 389, 135, 33);
		panel.add(btnContactUs);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setBounds(79, 543, 135, 33);
		panel.add(btnHelp);
	}
}
