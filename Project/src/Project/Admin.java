package Project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.ImageIcon;

public class Admin {

	int verified =0;
    LinkedList<String> aadhar = new LinkedList<String>();
	LinkedList<String> marksheet=new LinkedList<String>();
    LinkedList<String> challan=new LinkedList<String>();
	
    String user=null;// for database user name
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "proj";
	static String userName = "root";
	static String password = "12345";
	static Connection con = null;
	
	public void Login(AdminController c) {
		
		user=c.username.getText();
		String pass=c.pass.getText();
		
	    if(user.equals("Admin") && pass.equals("Records")) {
	    	c.Login.setVisible(false);
			c.insertion.setVisible(true);
		}
	}
	
	public void nextImg(AdminController c) {
		
		c.lAadhar.setText(" ");
		c.lMark.setText(" ");
		c.lReceit.setText(" ");
		
		if(aadhar.isEmpty()==false || challan.isEmpty()==false || marksheet.isEmpty()==false ) {
			
			// when the array lists with file paths aren't empty we directly show the data
			// in a JLabel
			aadhar.addLast(aadhar.getFirst());
			aadhar.removeFirst();
			
			ImageIcon icon= new ImageIcon(aadhar.get(0));
			c.lAadhar.setIcon(icon);
			//aadhar.remove(0);
			
			marksheet.addLast(marksheet.getFirst());
			marksheet.removeFirst();
			
			icon=new ImageIcon(marksheet.get(0));
			c.lMark.setIcon(icon);
			//marksheet.remove(0);
			
			challan.addLast(challan.getFirst());
			challan.removeFirst();
			
			icon=new ImageIcon(challan.get(0));
			c.lReceit.setIcon(icon);
			//challan.remove(0);
		}
		else {
			//if the lists are empty then we first retrieve data using a resultset.
			
	 		try{
				Class.forName(driverName);
				con = DriverManager.getConnection(url+dbName,userName,password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from docs;");
				File file=null;
				InputStream in;
				
				while (rs.next()) {
					    // this saves the paths to all the retrieved data.
					   
					     user=rs.getString(4);
					     
					     // the long blob image is written as a .jpg file
					     in = rs.getBinaryStream(1);
						 file= new File("src/Cached/aadhar_"+user+".jpg");	   
						 this.write(in,file);
						//the path to retrieved file is saved to the arrayList
						 aadhar.add("src/Cached/aadhar_"+user+".jpg");

					     in = rs.getBinaryStream(2);
					     marksheet.add("src/Cached/marksheet_"+user+".jpg");
						 file= new File("src/Cached/marksheet_"+user+".jpg");	 
					     this.write(in,file);
					     
					     in = rs.getBinaryStream(3);
					     challan.add("src/Cached/challan_"+user+".jpg");
						 file= new File("src/Cached/challan_"+user+".jpg");	 
					     this.write(in,file);
					     
					    // TODO
				        //can change to cached folder , which can be deleted later with every update.
				    
					
					
				}
				// first image in the array list is displayed
				ImageIcon icon;
				
				icon= new ImageIcon(aadhar.get(0));
				c.lAadhar.setIcon(icon);
				//aadhar.remove(0);
				
			    icon= new ImageIcon(marksheet.get(0));
				c.lMark.setIcon(icon);
				//marksheet.remove(0);
				
				icon= new ImageIcon(challan.get(0));
				c.lReceit.setIcon(icon);
				//challan.remove(0);
				
			 }
	 		catch(Exception ex){
				System.out.println("On event get : "+ex.getMessage());
			}
		}
	}
	
	public void write(InputStream in,File file) throws Exception {

	   // writes the retrieved blob image to file.
		OutputStream f = new FileOutputStream(file);
		
		int k = 0;
		while ((k = in.read()) > -1) {
			f.write(k);
		}
		
		f.close();
		in.close();
	}
	
	public void prevImg(AdminController c) {
		
		c.lAadhar.setText(" ");
		c.lMark.setText(" ");
		c.lReceit.setText(" ");
		
		if(aadhar.isEmpty()==false || challan.isEmpty()==false || marksheet.isEmpty()==false ) {
			
			// when the array lists with file paths aren't empty we directly show the data
			// in a JLabel
			aadhar.addFirst(aadhar.getLast());
			aadhar.removeLast();
			
			ImageIcon icon= new ImageIcon(aadhar.get(0));
			c.lAadhar.setIcon(icon);
			//aadhar.remove(0);
			
			marksheet.addFirst(marksheet.getLast());
			marksheet.removeLast();
			
			icon=new ImageIcon(marksheet.get(0));
			c.lMark.setIcon(icon);
			//marksheet.remove(0);
			
			challan.addFirst(challan.getLast());
			challan.removeLast();
			
			icon=new ImageIcon(challan.get(0));
			c.lReceit.setIcon(icon);
			//challan.remove(0);
		}
		else {
			//if the lists are empty then we first retrieve data using a resultset.
			
	 		try{
				Class.forName(driverName);
				con = DriverManager.getConnection(url+dbName,userName,password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from docs;");
				File file=null;
				InputStream in;
				
				while (rs.next()) {
					    // this saves the paths to all the retrieved data.
					   
					     user=rs.getString(4);
					     
					     // the long blob image is written as a .jpg file
					     in = rs.getBinaryStream(1);
						 file= new File("src/Cached/aadhar_"+user+".jpg");	   
						 this.write(in,file);
						//the path to retrieved file is saved to the arrayList
						 aadhar.add("src/Cached/aadhar_"+user+".jpg");

					     in = rs.getBinaryStream(2);
					     marksheet.add("src/Cached/marksheet_"+user+".jpg");
						 file= new File("src/Cached/marksheet_"+user+".jpg");	 
					     this.write(in,file);
					     
					     in = rs.getBinaryStream(3);
					     challan.add("src/Cached/challan_"+user+".jpg");
						 file= new File("src/Cached/challan_"+user+".jpg");	 
					     this.write(in,file);
					     
					    // TODO
				        //can change to cached folder , which can be deleted later with every update.
				    
					
					
				}
				// first image in the array list is displayed
				ImageIcon icon;
				
				icon= new ImageIcon(aadhar.get(0));
				c.lAadhar.setIcon(icon);
				//aadhar.remove(0);
				
			    icon= new ImageIcon(marksheet.get(0));
				c.lMark.setIcon(icon);
				//marksheet.remove(0);
				
				icon= new ImageIcon(challan.get(0));
				c.lReceit.setIcon(icon);
				//challan.remove(0);
				
			 }
	 		catch(Exception ex){
				System.out.println("On event get : "+ex.getMessage());
			}
		}	
	}
	
	public void getInfo(AdminController c) {
		
	}
}
