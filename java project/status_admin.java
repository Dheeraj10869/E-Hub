import java.awt.BorderLayout;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.sql.*; import javax.swing.*;
import com.toedter.calendar.JDateChooser;
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
	JDateChooser dateChooser;
	JDateChooser dateChooser_1;
	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTextField stat;
	
	//constructor
	public status_admin() {
		conn=postconnection.dbconnector();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 767);
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
		
		JLabel doc = new JLabel("DOC");
		doc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doc.setBounds(37, 280, 45, 13);
		contentPane.add(doc);
		
		JLabel dor = new JLabel("DOR");
		dor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dor.setBounds(37, 340, 45, 13);
		contentPane.add(dor);
		
		JLabel status = new JLabel("Status");
		status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		status.setBounds(37, 393, 45, 13);
		contentPane.add(status);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.setBackground(new Color(144, 238, 144));
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="UPDATE order_details SET  date_of_commencement='"+dateChooser.getDate()+"',date_of_release='"+dateChooser_1.getDate()+"',status='"+stat.getText()+"' where order_id='"+(String)comboBox.getSelectedItem()+"' ";
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
		updatebtn.setBounds(37, 514, 131, 39);
		contentPane.add(updatebtn);
		
		comboBox = new JComboBox();
		comboBox.setBounds(56, 144, 158, 39);
		contentPane.add(comboBox);
		
		comboBox.setBackground(new Color(60, 179, 113));
		
		JButton backbtn = new JButton("BACK");
		backbtn.setBounds(905, 143, 104, 39);
		contentPane.add(backbtn);
		backbtn.setBackground(new Color(255, 165, 0));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_home obj=new admin_home();
				obj.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		ImageIcon image = new ImageIcon(new ImageIcon("/Users/dheer/eclipse-workspace/EHUB/src/profile.jpeg").getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(88, 266, 126, 31);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(92, 334, 126, 31);
		contentPane.add(dateChooser_1);
		
		
		stat = new JTextField();
		stat.setBounds(92, 381, 228, 39);
		contentPane.add(stat);
		stat.setColumns(10);
		
		JButton getbtn = new JButton("GET DETAILS");
		getbtn.setBounds(89, 467, 125, 31);
		contentPane.add(getbtn);
		getbtn.setBackground(new Color(60, 179, 113));
		getbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.setBounds(202, 514, 131, 39);
		contentPane.add(deletebtn);
		deletebtn.setBackground(new Color(220, 20, 60));
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
		getbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					
					String  query="select date_of_commencement,date_of_release,status from order_details where order_id='"+(String)comboBox.getSelectedItem()+"'";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						
						dateChooser.setDate(rs.getDate("date_of_commencement"));
						dateChooser_1.setDate(rs.getDate("date_of_release"));
						 
						stat.setText(rs.getString("status"));
						
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
		
		
		
		  JLabel lblNewLabel_1 = new JLabel(""); 
		  lblNewLabel_1.setBounds(0,128, 1316, 602); 
		  ImageIcon image1 = new ImageIcon(new ImageIcon("C:\\\\Users\\\\dheer\\\\Downloads\\\\back.jpeg").getImage().getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_DEFAULT)); 
		  lblNewLabel_1.setIcon(image1);
		  contentPane.add(lblNewLabel_1);
		  
		  JLabel lblNewLabel_2 = new JLabel("");
		  lblNewLabel_2.setBounds(0, 0, 1316, 134);
		  ImageIcon image2 = new ImageIcon(new ImageIcon("C:\\\\Users\\\\dheer\\\\Downloads\\\\status-2.png").getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT)); 
		  lblNewLabel_2.setIcon(image2);
		  contentPane.add(lblNewLabel_2);
		 
		fillcomboBox();
		}
}
