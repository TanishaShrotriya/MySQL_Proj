package Project;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Admin {

	int verified =0;
    
	LinkedList<String> aadhar = new LinkedList<String>();
	LinkedList<String> marksheet=new LinkedList<String>();
    LinkedList<String> challan=new LinkedList<String>();
    ResultSet rs=null;
    
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
	
	public void getInfo(AdminController c) throws HeadlessException, SQLException {
		
		
	    if(rs!=null) {
				
	    	// when result set still holds values it shows the next data on button click
	    	if (rs.next()) {
	    		//table set 
				int roll,year,ph;
				String name,cat,div,branch;
				
				roll=rs.getInt(1);
				name=rs.getString(2);
				div=rs.getString(3);
				branch=rs.getString(4);
				year=rs.getInt(5);
				ph=rs.getInt(6);
				cat=rs.getString(7);
				this.user=rs.getString(8);
				
				//JOptionPane.showMessageDialog(c,""+ this.user);
			   // sets the value from the result set to the table
				c.t1.setValueAt(""+roll,0,1);
			    c.t1.setValueAt(name,1,1);
			    c.t1.setValueAt(div,2,1);
			    c.t1.setValueAt(branch,3,1);
			    c.t1.setValueAt("" + year,4,1);
			    c.t1.setValueAt(" "+ ph,5,1);
	            c.t1.setValueAt(cat,6,1);
	           
				
			}
	    // once the last element has been retrieved it resets the object rs to null
	    // thus not allowing it to close
	     if(rs.isAfterLast()) {
	  	    	rs=null;
	  	 }
		
	    }
		if(rs==null) {
			//if the result set is empty then we first retrieve data into it
			
	 		try{
				Class.forName(driverName);
				con = DriverManager.getConnection(url+dbName,userName,password);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("select * from info;");
			
				if (rs.next()) {
					//table set 
					int roll,year,ph;
					String name,cat,div,branch;
					
					roll=rs.getInt(1);
					name=rs.getString(2);
					div=rs.getString(3);
					branch=rs.getString(4);
					year=rs.getInt(5);
					ph=rs.getInt(6);
					cat=rs.getString(7);
					this.user=rs.getString(8);

				//	JOptionPane.showMessageDialog(c,""+ this.user);
					
				   c.t1.setValueAt(""+roll,0,1);
				   c.t1.setValueAt(name,1,1);
				   c.t1.setValueAt(div,2,1);
				   c.t1.setValueAt(branch,3,1);
				   c.t1.setValueAt("" + year,4,1);
				   c.t1.setValueAt(" "+ ph,5,1);
		           c.t1.setValueAt(cat,6,1);
				}
			 }
	 		catch(Exception ex){
				System.out.println("On event get : "+ex.getMessage());
			}
		}
	  
	}
	public void prevInfo(AdminController c) throws HeadlessException, SQLException {
		
		    if(rs!=null) {
					
		    	if (rs.previous()) {
		    		//table set 
					int roll,year,ph;
					String name,cat,div,branch;
					
					roll=rs.getInt(1);
					name=rs.getString(2);
					div=rs.getString(3);
					branch=rs.getString(4);
					year=rs.getInt(5);
					ph=rs.getInt(6);
					cat=rs.getString(7);
					this.user=rs.getString(8);
					
					//JOptionPane.showMessageDialog(c,""+ this.user);
	     			
					c.t1.setValueAt(""+roll,0,1);
				    c.t1.setValueAt(name,1,1);
				    c.t1.setValueAt(div,2,1);
				    c.t1.setValueAt(branch,3,1);
				    c.t1.setValueAt("" + year,4,1);
				    c.t1.setValueAt(" "+ ph,5,1);
		            c.t1.setValueAt(cat,6,1);
					
				}
		    	
		    	//TODO
	    		if(rs.isAfterLast()) {
	    			rs=null;
	    			//JOptionPane.showMessageDialog(c, "AT NULL BEFORE FIRST");
	    		}
	    	
			}
			if(rs==null) {
				//if the lists are empty then we first retrieve data using a resultset.
				
		 		try{
					Class.forName(driverName);
					con = DriverManager.getConnection(url+dbName,userName,password);
					Statement stmt = con.createStatement();
					rs = stmt.executeQuery("select * from info;");
					rs.last();
					
					if (rs.previous()) {
						//table set 
						int roll,year,ph;
						String name,cat,div,branch;
						
						roll=rs.getInt(1);
						name=rs.getString(2);
						div=rs.getString(3);
						branch=rs.getString(4);
						year=rs.getInt(5);
						ph=rs.getInt(6);
						cat=rs.getString(7);
						this.user=rs.getString(8);

					    c.t1.setValueAt(""+roll,0,1);
					    c.t1.setValueAt(name,1,1);
					    c.t1.setValueAt(div,2,1);
					    c.t1.setValueAt(branch,3,1);
					    c.t1.setValueAt("" + year,4,1);
					    c.t1.setValueAt(" "+ ph,5,1);
			            c.t1.setValueAt(cat,6,1);
					}
				 }
		 		catch(Exception ex){
					System.out.println("On event get : "+ex.getMessage());
				}
			}
		}

	public void checkDocs(AdminController c) {
		
 		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = con.createStatement();
		    stmt.execute("update cred set verify=1000 where user='"+this.user+"'");
		    JOptionPane.showMessageDialog(c,"Verified");
						
		 }
 		catch(Exception ex){
			System.out.println("On event get : "+ex.getMessage());
		}
	}
	
	public void sendDD(AdminController c) {
		
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = con.createStatement();
			JOptionPane.showMessageDialog(c,this.user);
			ResultSet r = stmt.executeQuery("select DDNum,bank,user from payments;");
			
			while (r.next()) {
				//table set 
				if(r.getString(3)==this.user) {
					String DD,bank;
					DD=r.getString(1);
					bank=r.getString(2);
				    JOptionPane.showMessageDialog(c,"DD number= "+DD+"\nBank= "+bank);
				    break;
				}
				else {
					JOptionPane.showMessageDialog(c,"rs issue");
				}
		    }
		 }
 		catch(Exception ex){
			System.out.println("On event get : "+ex.getMessage());
		}

	}
	
	public void verifyDD(AdminController c) {
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url+dbName,userName,password);
			Statement stmt = con.createStatement();
		    stmt.execute("update cred set verify=1100 where user='"+this.user+"'");
		    stmt.execute("update payments set verified=1100 where user='"+this.user+"'");
		    JOptionPane.showMessageDialog(c,"Verified DD details");
						
		 }
 		catch(Exception ex){
			System.out.println("On event get : "+ex.getMessage());
		}
	}
	
}

