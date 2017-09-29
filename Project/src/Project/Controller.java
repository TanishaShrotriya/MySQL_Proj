package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

			//TODO YET
			s.newEntry(this);
		}
		if(e.getSource()==login) {
			main.setVisible(false);
			Login.setVisible(true);
			verifypass.setVisible(false);
			lverifypass.setVisible(false);
		
			// TODO YET 
			s.vRecords(this);
		}
		
		if(e.getSource()== okay) {
			//verified=1 then go to login page
			
			if(s.verified==1) {
				main.setVisible(false);
				Login.setVisible(true);
				verifypass.setVisible(false);
				lverifypass.setVisible(false);
				s.vRecords(this);
			}
			
			//if verified == 2 move to insertion 
			if(s.verified==2) {
				Login.setVisible(false);
				insertion.setVisible(true);
			}
			//error message
			else {
				
			}
			
		}
		if(e.getSource()==insert) {
			
			insertion.setVisible(false);
			insertion.removeAll();
			insertion.add(upload1);
			insertion.add(upload2);
			insertion.add(lRoll);
			insertion.add(lName);
			insertion.add(done);
			insertion.setVisible(true);
		
		//TODO 
			s.toMySQL(this);
			
		}
		
		if(e.getSource()==upload1) {
		//file chooser code
			s.upload(this);
			
		}
		
		if(e.getSource()==upload2) {
			//file chooser code
	        s.upload(this);
		}
		
		if(e.getSource()==done) {
			insertion.setVisible(false);
			insertion.removeAll();
			insertion.add(dd);
			insertion.add(cash);
			insertion.add(half);
			insertion.add(full);
			insertion.add(getChallan);
			insertion.setVisible(true);
			//TODO If possible last page
	    }
		
		//TODO
		if(cash.isSelected()) {
			// send to table and show message
		}
		
		if(dd.isSelected()==true) {
			// set visible textField to get bank info and dd number
			insertion.add(lPhno);
			insertion.add(phno);
			insertion.add(lCat);
			insertion.add(category);
			insertion.setVisible(true);
			//TODO
						
			
		}
		
		if(half.isSelected()) {
			//record to table
			//TODO

		}
		
		if(full.isSelected()) {
			//record to table
			//TODO

		}
		
		if(e.getSource()==getChallan) {
			//TODO
			
		}
	}

}
