import javax.swing.*;
import javax.swing.border.Border;

import com.sun.jdi.connect.spi.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class payment {

	private static Border brd;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		  frame.getContentPane();
		  frame.setSize(600,600);
	      frame.setVisible(true);
	    //icon
			Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
			frame.setIconImage(icon);
	      
		  JPanel panel1 = new JPanel();
		  panel1.setLayout(null);
		  panel1.setBounds(0,80,600,600);
		  frame.add(panel1);
		  
		  JPanel panel2= new JPanel(setLayout(null));
		  panel2.setBackground(new Color(0, 89, 100));
		  frame.add(panel2);
		  
	      final JLabel L = new JLabel("PAYMENT PORTAL");
		  L.setBounds(149,35,400,20);
		  L.setFont(new Font("Times New Roman",Font.BOLD,30));
		  L.setForeground(new Color(255,255,255));
		  panel2.add(L);
		  
		  JLabel pay= new JLabel();
	        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/pay.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	        pay.setBorder(brd);
	        pay.setIcon(imageIcon);
			pay.setBounds(10, 20, 70, 70);
			panel1.add(pay);
			
		  JLabel U= new JLabel("Card Type :");
		  U.setBounds(60,120,250,25);
		  U.setFont(new Font("Times New Roman",Font.BOLD,20));
	      panel1.add(U);
		  
		  final JTextField Ut = new JTextField("");
		  Ut.setEditable(true);
		  Ut.setBounds(270,120,230,28);
		  panel1.add(Ut);
		  
		  JLabel C= new JLabel("Card Number :");
		  C.setBounds(60,160,250,25);
		  C.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(C);
		  
		  final JTextField CN = new JTextField("");
		  CN.setEditable(true);
		  CN.setBounds(270,160,230,28);
		  panel1.add(CN);
		  
		  JLabel NC= new JLabel("Name on Card :");
		  NC.setBounds(60,200,250,25);
		  NC.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(NC);
		  
		  final JTextField N = new JTextField("");
		  N.setEditable(true);
		  N.setBounds(270,200,230,28);
		  panel1.add(N);
		  
		  
		  JLabel E= new JLabel("Expiry Date :");
		  E.setBounds(60,245,230,25);
		  E.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(E);
		  
		  final JTextField ED = new JTextField("");
		  ED.setEditable(true);
		  ED.setBounds(180,245,90,28);
		  panel1.add(ED);
		
		  JLabel CV= new JLabel("CVV Number :");
		  CV.setBounds(292,245,250,25);
		  CV.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(CV);
		  
		  final JTextField CVV = new JTextField("");
		  CVV.setEditable(true);
		  CVV.setBounds(424,245,75,28);
		  panel1.add(CVV);
		  
		  JButton B = new JButton("CONFIRM PAYMENT");
		  B.setBounds(148,340,230, 40);
		  B.setFont(new Font("Times New Roman",Font.BOLD,15));
		  B.setBackground(new Color(0, 89, 100));
		  B.setForeground(new Color(255,255,255));
		  panel1.add(B);
		
	      
		  
	     
	}

	private static LayoutManager setLayout(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
