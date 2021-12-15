import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*; import javax.swing.*;
public class login_client extends JFrame {
	public static String user_id;
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
					login_client frame = new login_client();
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
	public login_client() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(344, 271, 228, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(344, 337, 241, 31);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("CLIENT ID:");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 269, 153, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(166, 335, 153, 31);
		contentPane.add(lblPassword);
		
		JButton loginbtn = new JButton("login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select client_id,password from login where client_id=? and password=? ";
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
						user_id=textField.getText();
						dispose();
						client_home obj1=new client_home();
						obj1.setVisible(true);
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
		loginbtn.setBounds(229, 425, 161, 40);
		contentPane.add(loginbtn);
		ImageIcon image = new ImageIcon(new ImageIcon("/Users/dheer/eclipse-workspace/EHUB/src/profile.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		JButton regbtn = new JButton("NEW USER?");
		regbtn.setBackground(new Color(255, 99, 71));
		regbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				register obj = new register();
				obj.setVisible(true);
			}
		});
		regbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		regbtn.setBounds(418, 425, 167, 40);
		contentPane.add(regbtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(0, 0, 938, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setBounds(27, 10, 878, 120);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(image);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(166, 204, 544, 303);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}
}
