import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.sql.*; import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class client_profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_profile frame = new client_profile();
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
	private JTextField client_id;
	private JTextField fname;
	private JTextField lname;
	private JTextField email_id;
	private JTextField phn;
	public client_profile() {
		conn=postconnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 10, 982, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton homebtn = new JButton("HOME");
		homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				client_home obj=new client_home();
				obj.setVisible(true);
			}
		});
		homebtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		homebtn.setBounds(10, 26, 135, 34);
		panel.add(homebtn);
		
		JButton editbtn = new JButton("EDIT Profile");
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname.setEditable(true);
				lname.setEditable(true);
				email_id.setEditable(true);
				phn.setEditable(true);
			}
		});
		editbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		editbtn.setBounds(769, 25, 149, 40);
		panel.add(editbtn);
		
		JLabel lblNewLabel = new JLabel("CLIENT-ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(111, 160, 143, 28);
		contentPane.add(lblNewLabel);
		
		client_id = new JTextField();
		client_id.setEditable(false);
		client_id.setBounds(353, 160, 177, 28);
		contentPane.add(client_id);
		client_id.setColumns(10);
		
		fname = new JTextField();
		fname.setEditable(false);
		fname.setColumns(10);
		fname.setBounds(353, 214, 177, 28);
		contentPane.add(fname);
		
		lname = new JTextField();
		lname.setEditable(false);
		lname.setColumns(10);
		lname.setBounds(353, 269, 177, 28);
		contentPane.add(lname);
		
		email_id = new JTextField();
		email_id.setEditable(false);
		email_id.setColumns(10);
		email_id.setBounds(353, 326, 177, 28);
		contentPane.add(email_id);
		
		phn = new JTextField();
		phn.setEditable(false);
		phn.setColumns(10);
		phn.setBounds(353, 382, 177, 28);
		contentPane.add(phn);
		
		JLabel lblFirstname = new JLabel("First-Name");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstname.setBounds(111, 203, 143, 28);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Last-Name");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastname.setBounds(111, 268, 143, 28);
		contentPane.add(lblLastname);
		
		JLabel lblEmailid = new JLabel("EMAIL-ID");
		lblEmailid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailid.setBounds(111, 325, 143, 28);
		contentPane.add(lblEmailid);
		
		JLabel lblPhnno = new JLabel("PHN-NO");
		lblPhnno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhnno.setBounds(111, 389, 143, 28);
		contentPane.add(lblPhnno);
		
		JButton savebtn = new JButton("SAVE");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login_client obj=new login_client();
					
					String  query="UPDATE client SET  fname='"+fname.getText()+"',lname='"+lname.getText()+"',email_id='"+email_id.getText()+"',phn='"+phn.getText()+"' where client_id='"+obj.user_id+"'";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.execute();
					fname.setEditable(false);
					lname.setEditable(false);
					email_id.setEditable(false);
					phn.setEditable(false);
				
					stmt.close();		}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		savebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		savebtn.setBounds(493, 485, 156, 48);
		contentPane.add(savebtn);
		
		JButton getbtn = new JButton("GET DETAILS");
		getbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login_client obj=new login_client();
					
					String  query="select fname,lname,email_id,phn from client where client_id='"+obj.user_id+"'";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						client_id.setText(obj.user_id);
						fname.setText(rs.getString("fname"));
						lname.setText(rs.getString("lname"));
						email_id.setText(rs.getString("email_id"));
						phn.setText(rs.getString("phn"));
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
		getbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		getbtn.setBounds(175, 485, 156, 48);
		contentPane.add(getbtn);
	}
}
