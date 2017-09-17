import java.sql.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class AdminForm extends JFrame implements ActionListener {
	
	//default data members, shared within a package.
	JButton send,get,view;
	JLabel u;
	
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "proj";
	static String userName = "root";
	static String password = "ENTER YOUR SQL PASSWORD";
	static Connection con = null;
	

	private ArrayList<String> fileArray=new ArrayList<String>();
	
	AdminForm() {
		
		//setting parameters of JFrame
		this.setBounds(10, 10, 1000, 1000);
		
		send=new JButton("Upload");
		send.addActionListener(this);
		send.setBounds(410, 410, 100, 100);
		
		get=new JButton("GetAll");
		get.addActionListener(this);
		get.setBounds(410, 520, 100, 100);
		
		view=new JButton("ViewNext");
		view.addActionListener(this);
		view.setBounds(520, 520, 100, 100);
		
		
		u=new JLabel();
		u.setBounds(0, 0, 0,0);
		u.setVisible(true);
		
		this.add(send);
		this.add(get);
		this.add(view);
		this.add(u);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// When button send is pressed
		if(event.getSource()==send) {
		
			// allowing user to pick image
			JFileChooser ch=new JFileChooser();
			ch.showOpenDialog(null);
			File fi=ch.getSelectedFile();
			//in case you wish to display file path
			String fname=fi.getAbsolutePath();
		
			try{
				  Class.forName(driverName);
				  con = DriverManager.getConnection(url+dbName,userName,password);
				 
				  FileInputStream fin = new FileInputStream(fi);
				 
				  PreparedStatement pre =
				  con.prepareStatement("insert into image values(?,?)");
				 
				  pre.setInt(1,3);
				  
				  //sending image as a binary file format
				  pre.setBinaryStream(2,(InputStream)fin,(int)fi.length());
				  
				  pre.executeUpdate();
				  
				  System.out.println("Successfully inserted the file into the database!");

				  pre.close();
				  con.close(); 
				  
				}catch (Exception e1){
					System.out.println(e1.getMessage());
				}
			
		}
		
		if(event.getSource()==get) {	
			//retrieval to JTextfield

	 		try{
				Class.forName(driverName);
				con = DriverManager.getConnection(url+dbName,userName,password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select image from image ");
				int i = 0;
				File file =null;
				
				while (rs.next()) {
					
					    fileArray.add("src/test"+i+".jpg");
					    // this saves the paths to all the retrieved data.
					    // POINT TO NOTE!!
					    //can change to cached folder , which can be deleted later with every update.
					    
						InputStream in = rs.getBinaryStream(1);
						file= new File("src/test"+i+".jpg");
						 
						OutputStream f = new FileOutputStream(file);
						
						int c = 0;
						while ((c = in.read()) > -1) {
							f.write(c);
						}
						
					    
						i++;
						f.close();
						in.close();
					
					
				}
			 }
	 		catch(Exception ex){
				System.out.println("On event get : "+ex.getMessage());
			}
		}
	
	   // Allows user to scroll through retrieved images on button click
		if(event.getSource()==view) {
			
			if(fileArray.isEmpty()==false) {
				ImageIcon icon= new ImageIcon(fileArray.get(0));
				u.setIcon(icon);
				fileArray.remove(0);
			}
			else {
				JOptionPane.showMessageDialog(this, "Nothing to show");
			}
			
		}
	}
	
	// Main 
    public static void main(String[] args){
		
    	System.out.print("Hello");
		new AdminForm();
		
	}

}
