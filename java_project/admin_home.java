import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_home frame = new admin_home();
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
	public admin_home() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 299, 1061, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton employeebtn = new JButton("EMPLOYEE");
		employeebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				employee obj=new employee();
				obj.setVisible(true);
			}
		});
		employeebtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		employeebtn.setBounds(83, 114, 231, 89);
		panel.add(employeebtn);
		
		JButton projectsbtn = new JButton("PROJECTS");
		projectsbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		projectsbtn.setBounds(805, 114, 231, 89);
		panel.add(projectsbtn);
		
		JButton statusbtn = new JButton("STATUS");
		statusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				status_admin obj=new status_admin();
				obj.setVisible(true);
			}
		});
		statusbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		statusbtn.setBounds(431, 116, 253, 89);
		panel.add(statusbtn);
		
		JLabel lblNewLabel = new JLabel("TECHOSS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(237, 10, 663, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome admin,select your option");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(34, 215, 559, 64);
		contentPane.add(lblNewLabel_1);
	}
}
