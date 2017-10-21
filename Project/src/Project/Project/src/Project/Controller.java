package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Controller extends View implements ActionListener  {
	
	Student s =null;
	
	Controller() {
		super();
		signup.addActionListener(this);
		okay.addActionListener(this);
		login.addActionListener(this);
		insert.addActionListener(this);
		upload1.addActionListener(this);
		upload2.addActionListener(this);
		done.addActionListener(this);
		cash.addActionListener(this);
		dd.addActionListener(this);
		full.addActionListener(this);
		half.addActionListener(this);
		s=new Student();
	}
	@Override
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==signup) {
			main.setVisible(false);
			Login.setVisible(true);
			
		}
		if(e.getSource()==login) {
			main.setVisible(false);
			Login.setVisible(true);
			verifypass.setVisible(false);
			lverifypass.setVisible(false);
			s.verified=3;
		}
		
		if(e.getSource()== okay) {
			//verified=1 then go to login page
			
			if(s.verified==3) {
			    s.vRecords(this);
			    
			}
			if(s.verified==0) { 
				try {
					s.newEntry(this);
					pass.setText(" ");
					verifypass.setText(" ");
					new Controller();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			//if verified == 2 move to insertion 
			if(s.verified==2) {
				Login.setVisible(false);
				insertion.setVisible(true);
			}
			
			if(s.verified==1) {
			    //JOptionPane.showMessageDialog(this,"here in 1");
				main.setVisible(false);
				Login.setVisible(true);
				username.setText(" ");
				pass.setText(" ");
				verifypass.setVisible(false);
				lverifypass.setVisible(false);
			    s.verified=3;
			}
			
			
		}
		if(e.getSource()==insert) {
			
			try {
					String str=null;
					
					str=s.toMySQL(this);
					
					if(str=="true"){
						insertion.setVisible(false);
						insertion.removeAll();
						insertion.add(upload1);
						insertion.add(upload2);
						insertion.add(lRoll);
						insertion.add(lName);
						insertion.add(done);
						insertion.setVisible(true);
					}
				} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==upload2) {
			//file chooser code and send to docs table of sql
			try {
				s.sendImage(this);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	        s.upload(this,"aadhar",this.lName);
	        //pass the controller object and the column name in sql table.
		}
		
		if(e.getSource()==upload1) {
			s.upload(this,"marksheet",this.lRoll);
           //pass the controller object and the column name in sql table.
			
		}
		
		if(e.getSource()==done) {
			JOptionPane.showMessageDialog(this, "Upload successful!");
			insertion.setVisible(false);
			insertion.removeAll();
			insertion.add(dd);
			insertion.add(cash);
			insertion.add(half);
			insertion.add(full);
			insertion.add(getChallan);
			insertion.setVisible(true);
			try {
				s.createRecord();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			//will create an empty record for this.user in payments
			
	    }
		
		//TODO
		if(cash.isSelected()==true) {
			// send to table and show message
			insertion.setVisible(false);
			insertion.remove(lddnum);
			insertion.remove(ddnum);
			insertion.remove(lbank);
			insertion.remove(bank);
			insertion.setVisible(true);
			s.sendCash(this);
		}
		
		if(dd.isSelected()==true) {
			// set visible textField to get bank info and dd number
			insertion.setVisible(false);
			insertion.add(lddnum);
			insertion.add(ddnum);
			insertion.add(lbank);
			insertion.add(bank);
			insertion.setVisible(true);
			s.sendDD(this);
			
		}
		
		if(half.isSelected()==true) {
			//record to table
			s.sendHalf(this);

		}
		
		if(full.isSelected()==true) {
			//record to table
			s.sendFull(this);

		}
		
		if(e.getSource()==getChallan) {
			//TODO
			
		}
	}

}
