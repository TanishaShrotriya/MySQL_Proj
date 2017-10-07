package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class AdminController extends AdminView2 implements ActionListener {

	Admin a=null;
	AdminController() {
		super();
		login.addActionListener(this);
		verify.addActionListener(this);
		Docs.addActionListener(this);
		DdDetails.addActionListener(this);
		cashDetails.addActionListener(this);
		callBack.addActionListener(this);
		checkDocs.addActionListener(this);
		nextImg.addActionListener(this);
		prevImg.addActionListener(this);
		search.addActionListener(this);
		back.addActionListener(this);
		checkDD.addActionListener(this);;
		back2.addActionListener(this);;
		toBank.addActionListener(this);
		back3.addActionListener(this);;
		checkCash.addActionListener(this);
		exit.addActionListener(this);
		back4.addActionListener(this);;
		fromBank.addActionListener(this);
		install2.addActionListener(this);;
		unverified.addActionListener(this);
		a=new Admin();
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login) {
			main.setVisible(false);
		    Login.setVisible(true);
			
		}
		
		if(e.getSource()==verify) {
			//Login.setVisible(false);
			//insertion.setVisible(true);
		    a.Login(this);
		    
		}
		
		if(e.getSource()==Docs) {
			insertion.setVisible(false);
			main.setVisible(false);
			main.removeAll();
			String data[][]= {  {"Roll Number",""},
   				            	{"Name",""},
   				            	{"Division",""},
   				            	{"Branch",""},
   				            	{"Year",""},
					    	    {"Phone Number",""},
					    	    {"Category",""}
                     };
			String col[]= {"Content","Data"};
			t1=new JTable(data,col);
			t1.setBounds(50,50,300,115);
			t1.setEnabled(false);
			main.add(t1);
			
			//write function in Student to retrieve data into table
			main.add(lAadhar);
			main.add(lMark);
			main.add(lReceit);
			main.add(back);
			main.add(nextImg);
			main.add(prevImg);
			main.add(checkDocs);
			main.add(search);
			main.setVisible(true);
			
		}
		
		if(e.getSource()==DdDetails) {
		
			insertion.setVisible(false);
			main.setVisible(false);
			main.removeAll();
			main.add(DD);
			main.add(checkDD);
			main.add(back2);
			main.add(toBank);
			main.setVisible(true);
		}
		
		if(e.getSource()==cashDetails) {
			
			insertion.setVisible(false);
			main.setVisible(false);
			main.removeAll();
			main.add(Cash);
			main.add(cashD);
			main.add(checkCash);
			main.add(back3);
			main.setVisible(true);
		}
		
	    if(e.getSource()==callBack) {
	    	insertion.setVisible(false);
			main.setVisible(false);
			main.removeAll();
			main.add(cBack);
			main.add(unverified);
			main.add(install2);
			main.add(fromBank);
			main.add(back4);
			main.setVisible(true);
		
		}
	    
	    if(e.getSource()==back) {
		
	    	this.lAadhar.setIcon(null);
	    	this.lAadhar.setText("See Aadhar here");
	    	
	    	this.lMark.setIcon(null);
	    	this.lMark.setText("See marksheet here");
	    	
	    	this.lReceit.setIcon(null);
	    	this.lReceit.setText("See challan here");
	    	main.setVisible(false);
	    	insertion.setVisible(true);
		}
		
		if(e.getSource()==nextImg) {
		//TODO
			// code to move forward
			a.nextImg(this);
		}
		
	    if(e.getSource()==prevImg) {
	    	//TODO	
	    	// code to go back a value
	    	a.prevImg(this);
		}
		
		if(e.getSource()==checkDocs) {
			//TODO
			//code for marking verified column
			
		}
		
	    if(e.getSource()==search) {
	    	//TODO
		}
	    
	    
	    if(e.getSource()==back2) {
			
	    	main.setVisible(false);
	    	insertion.setVisible(true);
		}
	    
	    if(e.getSource()==toBank) {
	    	//TODO
	    	// code to send value to Bank interface
    	   // show message dialogue
		}
		
		if(e.getSource()==checkDD) {
			//TODO
			//code for marking verified column
			
		}
		
        if(e.getSource()==back3) {
          	main.setVisible(false);
	    	insertion.setVisible(true);
		}
		
		if(e.getSource()==checkCash) {
			//TODO
			//code for marking verified column
			
		}
       if(e.getSource()==fromBank) {
    	 //TODO
	    	// code to get values from Bank interface
    	   // show message dialogue client server
		}
		
		if(e.getSource()==install2) {
			//TODO
			//client server send notification to come in for second installation
			
		}
		
        if(e.getSource()==back4) {
          	main.setVisible(false);
	    	insertion.setVisible(true);
		}
		
		if(e.getSource()==unverified) {
			//TODO
			//code for retrieving unverified students and en notification to client UI
			
		}
		
		if(e.getSource()==exit) {
			JOptionPane.showMessageDialog(this, "Thank you for working with us!");
			this.setVisible(false);
		}
		
	}
	
}
