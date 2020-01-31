
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class Cnct {
       
       
	public static void main (String[] args) throws SQLException{
		 try {print();} catch(Exception e) {e.printStackTrace();}
    	 // try{insert("A0008", "Ford", "Pinto", 1971, true, false, false, "August 16", "10:30");} catch (Exception e) {e.printStackTrace();}           	   
		//try{remove("A0009");} catch (Exception e) {e.printStackTrace();}           	   
    	 //try {print();} catch(Exception e) {e.printStackTrace();} 
    	 //System.out.println();
    	 //try {updateS("Model", "Fiesta", "A0003");} catch(Exception e) {e.printStackTrace();} // Column, with What, in Account Number
    	//try {updateI(2009, "A0003");} catch(Exception e) {e.printStackTrace();} // Value of the  new year, in Account Number
    	 //try {updateB("Oil_Change",true, "A0009");} catch(Exception e) {e.printStackTrace();} // Value of the  new year, in Account Number
    	 //System.out.println();
    	 //try {print();} catch(Exception e) {e.printStackTrace();} 
	}   
    
		public static void print() throws SQLException, Exception 
		{
			 String addr = "jdbc:mysql://Localhost:3386/custinfo?useSSL=false";
             Connection conn = DriverManager.getConnection(addr,"root","bobsautocare");
             String an = "AcctNum"; String mk = "Make"; String mo = "Model"; String ye = "Year"; String oc = "Oil_Change";
             String tr = "Tire_Rotation"; String al = "Alignment"; String dt = "Date"; String tm = "Time";
             Statement st = conn.createStatement();
             String sql = "select * from Customer;";
             ResultSet rs = st.executeQuery(sql);
             
             System.out.println();
             String item0 = String.format("%-8s %-11s %-10s %-5s %-14s %-14s %-14s %-7s %-6s", an , mk , mo, ye, oc, tr, al, dt, tm);
        	 System.out.printf(item0);
        	 System.out.println();
        	 for(int i = 0; i<96;i++) { 
        	 System.out.print("=");}
             System.out.println();
        	 while (rs.next())
             {
            	String item = String.format("%-8s %-11s %-10s %-5s %-14s %-14s %-14s %-7s %-6s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)+"\n");
            	System.out.printf(item);
             }
                    
             conn.close();
             System.out.println();
             System.out.println("Today's Complete Appointment List");
             
        }
       
     
       
       public static void insert(String a, String b, String c, int d, boolean e, boolean f, boolean g, String h, String i) throws SQLException, Exception
       {
    	   PreparedStatement preps = null;
    	   String addr = "jdbc:mysql://Localhost:3386/custinfo?useSSL=false";
           Connection conn = DriverManager.getConnection(addr,"root","bobsautocare");
           
    	   System.out.print("Adding.");
    	   	try {TimeUnit.NANOSECONDS.sleep(500000000);} catch (InterruptedException x){}
    	   	System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(300000000);} catch (InterruptedException x){}
			System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(300000000);} catch (InterruptedException y){}
			System.out.println(".");
			try {TimeUnit.NANOSECONDS.sleep(200000000);} catch (InterruptedException z){}
    	   String query = "INSERT INTO Customer (AcctNum, Make, Model, Year, Oil_Change, Tire_Rotation, Alignment, Date, Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	   preps = conn.prepareStatement(query);
    	   preps.setString(1, a); preps.setString(2, b); preps.setString(3, c);
    	   preps.setInt(4, d); preps.setBoolean(5, e); preps.setBoolean(6, f); preps.setBoolean(7, g);
    	   preps.setString(8, h); preps.setString(9, i);
    	   preps.execute();
    	   preps.close();
    	   conn.close();      
       }

       public static void remove(String a) throws SQLException, Exception
       {
    	   PreparedStatement preps = null;
    	   String addr = "jdbc:mysql://Localhost:3386/custinfo?useSSL=false";
           Connection conn = DriverManager.getConnection(addr,"root","bobsautocare");
           
           System.out.print("Removing.");
           	try {TimeUnit.NANOSECONDS.sleep(700000000);} catch (InterruptedException x){}
   	   	   	System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(500000000);} catch (InterruptedException x){}
			System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(400000000);} catch (InterruptedException y){}
			System.out.println(".");
			try {TimeUnit.NANOSECONDS.sleep(200000000);} catch (InterruptedException z){}
    	   String query = "DELETE FROM Customer WHERE AcctNum = ?";
    	   preps = conn.prepareStatement(query);
    	   preps.setString(1, a);
    	   preps.execute();
    	   preps.close();
    	   conn.close();
       }
       
       
       public static void updateS(String a, String b, String c)throws SQLException, Exception
       {
    	   PreparedStatement preps = null;
    	   String addr = "jdbc:mysql://Localhost:3386/custinfo?useSSL=false";
           Connection conn = DriverManager.getConnection(addr,"root","bobsautocare");
    	  
           System.out.print("Updating.");
          	try {TimeUnit.NANOSECONDS.sleep(700000000);} catch (InterruptedException x){}
  	   	   	System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(500000000);} catch (InterruptedException x){}
			System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(400000000);} catch (InterruptedException y){}
			System.out.println(".");
			try {TimeUnit.NANOSECONDS.sleep(200000000);} catch (InterruptedException z){}
           
           String query = "UPDATE Customer SET " +a+" = ? WHERE AcctNum = ?";
    	   preps = conn.prepareStatement(query);
    	   preps.setString(1, b); 
    	   preps.setString(2, c); //sets values in the "?" in the query line.
    	   preps.execute();
    	   preps.close();
    	   conn.close();
       }
       
       public static void updateI(int a, String b)throws SQLException, Exception
       {
    	   PreparedStatement preps = null;
    	   String addr = "jdbc:mysql://Localhost:3386/custinfo?useSSL=false";
           Connection conn = DriverManager.getConnection(addr,"root","bobsautocare");
    	  
           System.out.print("Updating.");
          	try {TimeUnit.NANOSECONDS.sleep(700000000);} catch (InterruptedException x){}
  	   	   	System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(500000000);} catch (InterruptedException x){}
			System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(400000000);} catch (InterruptedException y){}
			System.out.println(".");
			try {TimeUnit.NANOSECONDS.sleep(200000000);} catch (InterruptedException z){}
           
           String query = "UPDATE Customer SET Year = ? WHERE AcctNum = ?";
    	   preps = conn.prepareStatement(query);
    	   preps.setInt(1, a); 
    	   preps.setString(2, b); //sets values in the "?" in the query line.
    	   //preps.setString(3, c);
    	   preps.execute();
    	   preps.close();
    	   conn.close();
       }
       
       
       public static void updateB(String a, Boolean b, String c)throws SQLException, Exception 
       {
    	   PreparedStatement preps = null;
    	   String addr = "jdbc:mysql://Localhost:3386/custinfo?useSSL=false";
           Connection conn = DriverManager.getConnection(addr,"root","bobsautocare");
           
           System.out.print("Updating.");
         	try {TimeUnit.NANOSECONDS.sleep(700000000);} catch (InterruptedException x){}
 	   	   	System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(500000000);} catch (InterruptedException x){}
			System.out.print(".");
			try {TimeUnit.NANOSECONDS.sleep(400000000);} catch (InterruptedException y){}
			System.out.println(".");
			try {TimeUnit.NANOSECONDS.sleep(200000000);} catch (InterruptedException z){}
           
           String query = "UPDATE Customer SET " +a+" = ? WHERE AcctNum = ?";
    	   preps = conn.prepareStatement(query);
    	   preps.setBoolean(1, b);//// True or False for Services
    	   preps.setString(2, c); //sets values in the "?" in the query line.
    	   preps.execute();
    	   preps.close();
    	   conn.close();
           
    	   
       }
}

