import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField phn_num;
	private JTextField email_id;
	private JPasswordField password;
	private JPasswordField confirm_password;
	private JLabel PHN_NUM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	private JPanel panel;
	public register() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 702);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fname = new JTextField();
		fname.setBounds(305, 112, 139, 33);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(305, 167, 139, 33);
		contentPane.add(lname);
		
		phn_num = new JTextField();
		phn_num.setColumns(10);
		phn_num.setBounds(305, 231, 139, 33);
		contentPane.add(phn_num);
		
		email_id = new JTextField();
		email_id.setColumns(10);
		email_id.setBounds(305, 284, 139, 33);
		contentPane.add(email_id);
		
		password = new JPasswordField();
		password.setBounds(294, 346, 150, 33);
		contentPane.add(password);
		
		confirm_password = new JPasswordField();
		confirm_password.setBounds(294, 389, 150, 33);
		contentPane.add(confirm_password);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(112, 112, 118, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(112, 177, 118, 33);
		contentPane.add(lblLastName);
		
		PHN_NUM = new JLabel("PHN_NUM");
		PHN_NUM.setFont(new Font("Tahoma", Font.BOLD, 13));
		PHN_NUM.setBounds(112, 230, 118, 33);
		contentPane.add(PHN_NUM);
		
		JLabel EMAIL_ID = new JLabel("EMAIL_ID");
		EMAIL_ID.setFont(new Font("Tahoma", Font.BOLD, 13));
		EMAIL_ID.setBounds(112, 283, 118, 33);
		contentPane.add(EMAIL_ID);
		
		JLabel PASSWORD = new JLabel("PASSWORD");
		PASSWORD.setFont(new Font("Tahoma", Font.BOLD, 13));
		PASSWORD.setBounds(112, 345, 118, 33);
		contentPane.add(PASSWORD);
		
		JLabel lblRenterPassword = new JLabel("RENTER PASSWORD");
		lblRenterPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRenterPassword.setBounds(112, 388, 162, 33);
		contentPane.add(lblRenterPassword);
		
		JButton registerbtn = new JButton("REGISTER");
		registerbtn.setBackground(new Color(50, 205, 50));
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                     String orde = null;
					String  incr="SELECT * FROM increment ORDER BY increment DESC LIMIT 1";
					PreparedStatement stmt=conn.prepareStatement(incr);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						orde=rs.getString("increment");
					}
					String ord="c-"+orde;
					rs.close();
					stmt.close();
					
					
						
					
						String  query="insert into client values(?,?,?,?,?)";
						PreparedStatement stmt11=conn.prepareStatement(query);
						
						stmt11.setString(1,ord);
						stmt11.setString(2,fname.getText());
						stmt11.setString(3,lname.getText());
						stmt11.setString(4,email_id.getText());
						stmt11.setString(5,phn_num.getText());
						stmt11.execute();
						stmt11.close();
						
						String  pass="insert into login(client_id,password) values(?,?)";
						PreparedStatement stmt111=conn.prepareStatement(pass);
						
						stmt111.setString(1,ord);
						stmt111.setString(2,password.getText());
						JOptionPane.showMessageDialog(null,"registerd");
						JOptionPane.showMessageDialog(null,"your login_id : "+ord);
						stmt111.execute();
						
						
						stmt111.close();		
					
				
						int i=(Integer.parseInt(orde))+1;
						String  incre="insert into increment values(?)";
						PreparedStatement stmt1=conn.prepareStatement(incre);
						stmt1.setInt(1,i);
						stmt1.execute();
						stmt1.close();
					
					
					dispose();
					login_client obj=new login_client();
					obj.setVisible(true);
					
					
						
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();

				}
			}
		});
		registerbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		registerbtn.setBounds(198, 493, 219, 45);
		contentPane.add(registerbtn);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(132, 10, 841, 61);
		contentPane.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(67, 78, 453, 496);
		contentPane.add(panel);
		panel.setLayout(null);
	 ImageIcon image = new ImageIcon(new ImageIcon("/Users/dheer/eclipse-workspace/EHUB/src/profile.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	}
}
