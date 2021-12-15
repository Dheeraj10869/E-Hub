import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*; import javax.swing.*;
public class login_admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_admin frame = new login_admin();
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
	public login_admin() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(344, 247, 228, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(344, 337, 241, 31);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("admin ID:");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 245, 153, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(166, 335, 153, 31);
		contentPane.add(lblPassword);
		
		JButton loginbtn = new JButton("login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select admin_id,password from login where admin_id=? and password=? ";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.setString(1,textField.getText()); 
					stmt.setString(2,passwordField.getText()); 
					ResultSet rs=stmt.executeQuery();
					int count=0;
					while(rs.next())
					{
						count=count+1;
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null,"user_id and password correct");
						dispose();
						admin_home obj=new admin_home();
						obj.setVisible(true);
						
						
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null," duplicate user_id and password ");
					}
					else
					{
						JOptionPane.showMessageDialog(null," incorrect user_id and password!");
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
		loginbtn.setForeground(Color.BLACK);
		loginbtn.setBackground(new Color(60, 179, 113));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginbtn.setBounds(92, 425, 161, 40);
		contentPane.add(loginbtn);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(10, 10, 878, 93);
		contentPane.add(lblNewLabel_1);
	}
}
