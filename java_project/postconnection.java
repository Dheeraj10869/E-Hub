
  import java.sql.*; import javax.swing.*;
  
  
  public class postconnection { 
static Connection conn = null; 
Statement stmt =null; 
public static Connection dbconnector() { 
try {
  Class.forName("org.postgresql.Driver");
  conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "9966036623"); 
 
  return conn;
  
  }
  
  catch (Exception e)
{       JOptionPane.showMessageDialog(null,e);
       return null;
  
 }
  
  } }
 