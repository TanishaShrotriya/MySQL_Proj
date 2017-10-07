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
				 con.createStatement().execute("insert into cred values('"+u+"','"+pass+"','Nothing Sent');");
				 verified=1;
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
		System.out.println("User is : "+user);
		//if successful then change verified to 1
		verified=2;
	}
	
	public void toMySQL(Controller c) {
		
		//TODO
		// send student data to sql
		
		
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
			  
			  System.out.println("Successfully inserted the file into the database!");

			  pre.close();
			  con.close(); 
			  
			}catch (Exception e1){
				System.out.println(e1.getMessage());
			}
		
	}
	
	public void sendImage(Controller c) {
        
		
	}
}
