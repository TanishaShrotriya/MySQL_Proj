package Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Student {

	int verified =0;
	String user=null;// for database user name
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "proj";
	static String userName = "root";
	static String password = "12345";
	static Connection con = null;
	
	public void newEntry(Controller c) throws Exception {
		//TODO
		//getText and send to SQL
 
		String u=c.username.getText();
		String pass=c.pass.getText();
		String ver=c.verifypass.getText();

		if(!ver.equals(pass)) {
			JOptionPane.showMessageDialog(c,"Re-enter password");
		}
		else if(ver.equals("")==true) {
			JOptionPane.showMessageDialog(c,"Password cannot be empty string");
		}
		else {
		
			 Class.forName(driverName);
			 con = DriverManager.getConnection(url+dbName,userName,password);
			 try {
				 con.createStatement().executeUpdate("insert into cred(user,pass) values('"+u+"','"+pass+"');");
				 verified=1;
				// JOptionPane.showMessageDialog(c,"verified is 1");
				 Class.forName(driverName);
				 con = DriverManager.getConnection(url+dbName,userName,password);  
				 ResultSet rs=con.createStatement().executeQuery("Select * from cred where user ='"+this.user+"' and pass='"+pass+"';");
					
			 }
			 catch(Exception e) {
				JOptionPane.showMessageDialog(c,"Duplicate Entry try another username");
			 }

		}
	
		//if successful then change verified to 1
		// make sure to send new user info to table AND update table verified
		
	}

	public void vRecords(Controller c) {
		//TODO
		//getText and check with sql records

		this.user=c.username.getText();
		String pass=c.pass.getText();
		System.out.println("User is : "+this.user);
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url+dbName,userName,password);  
	
			ResultSet rs=con.createStatement().executeQuery("Select * from cred where user ='"+this.user+"' and pass='"+pass+"';");
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(c,"Success");
				verified=2;
			}
			else {
				JOptionPane.showMessageDialog(c,"No such user");
		    
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//if successful then change verified to 1
		
	}
	
	public String toMySQL(Controller c) {
		
		//TODO
		// send student data to sql
		
		
		int roll=Integer.parseInt(c.roll.getText());
		String name=c.name.getText();
		String div=c.div.getText();
		String branch=c.branch.getText();
		int phno=Integer.parseInt(c.phno.getText());
		String category=c.category.getText();
		int year=Integer.parseInt(c.year.getText());
		JOptionPane.showMessageDialog(c,""+this.user);
		 
		 try {	
			Class.forName(driverName);
		     con = DriverManager.getConnection(url+dbName,userName,password);  
			 con.createStatement().execute("insert into info values("+roll+",'"+name+"','"+div+"','"+branch+"',"+year+","+phno+",'"+category+"','"+this.user+"');");
			 con.close();
			 return "true";
			 
		 }
		 catch(Exception e) {
			JOptionPane.showMessageDialog(c,e.getMessage());
			return "false";
			
		 }
		
	}
	
	public void upload(Controller c,String column,JLabel l) {
		
		//using file chooser get image and show in labels
		// send to SQL table.
		// allowing user to pick image
		JFileChooser ch=new JFileChooser();
		//TODO handle onclose
		ch.showOpenDialog(null);
		
		File fi=ch.getSelectedFile();
		//in case you wish to display file path
		String fname=fi.getAbsolutePath();
		
		ImageIcon icon= new ImageIcon(fname);
		l.setIcon(icon);
		
		
		try{
			
			  Class.forName(driverName);
			  con = DriverManager.getConnection(url+dbName,userName,password);
			 
			  FileInputStream fin = new FileInputStream(fi);
			   System.out.println(user);
			  
			  PreparedStatement pre =
			  con.prepareStatement("update docs set "+column+"=? where user=? ");
			 
			  //sending image as a binary file format
			  pre.setBinaryStream(1,(InputStream)fin,(int)fi.length());
			  pre.setString(2, this.user);
			  pre.executeUpdate();
			  
			  System.out.println("Image says "+this.user);
			  System.out.println("Successfully inserted the file into the database!");

			  pre.close();
			  con.close(); 
			  
			}catch (Exception e1){
				System.out.println(e1.getMessage());
			}
		
	}
	
	public void sendImage(Controller c) throws Exception{
        
		 String s="";
		 Class.forName(driverName);
	     con = DriverManager.getConnection(url+dbName,userName,password);  
		 con.createStatement().execute("insert into docs values('','','','"+this.user+"');");
		 con.close();
	}
	public void createRecord() throws Exception {
		 String s="";
		 Class.forName(driverName);
	     con = DriverManager.getConnection(url+dbName,userName,password);  
		 con.createStatement().execute("insert into payments(user) values('"+this.user+"');");
		 con.close();
	}

	public void sendCash(Controller c) {
		// TODO Auto-generated method stub
		 try {
			 Class.forName(driverName);
		     con = DriverManager.getConnection(url+dbName,userName,password);  
			 con.createStatement().execute("update payments set type='Cash' where user='"+this.user+"';");
			 con.close();
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(c,e.getMessage());
		 }
	}

	public void sendDD(Controller c) {
		
		String DD=c.ddnum.getText();
		String bank=c.bank.getText();
		 try {
			 Class.forName(driverName);
		     con = DriverManager.getConnection(url+dbName,userName,password);  
			 con.createStatement().execute("update payments set type='DD',DDnum='"+DD+"',bank='"+bank+"' where user='"+this.user+"';");
			 con.close();
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(c,e.getMessage());
		 }
	}
	public void sendHalf(Controller c) {
		
		 try {
			 Class.forName(driverName);
		     con = DriverManager.getConnection(url+dbName,userName,password);  
			 con.createStatement().execute("update payments set install='Half' where user='"+this.user+"';");
			 con.close();
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(c,e.getMessage());
		 }
	}
	public void sendFull(Controller c) {
		// TODO Auto-generated method stub
		 try {
			 Class.forName(driverName);
		     con = DriverManager.getConnection(url+dbName,userName,password);  
			 con.createStatement().execute("update payments set type='Full' where user='"+this.user+"';");
			 con.close();
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(c,e.getMessage());
		 }
	}
	
}
