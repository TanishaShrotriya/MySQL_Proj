package Project;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	JPanel main,insertion,newSign,Login;
	JButton login,signup,insert,upload1,upload2,done,pay,exit,okay,getChallan;
	//okay used with verification process operation
	JTextField roll,name,div,branch,year,phno,category,username,pass,verifypass;
	JLabel lRoll,lName,lDiv,lBranch,lYear,lPhno,lCat,lusername,lpass,lverifypass;
	
	JRadioButton cash,dd,full,half;
	ButtonGroup mode,type;
	
	View(){

	this.setSize(800,700); 
	this.setLocationRelativeTo(null);
	this.setLayout(null);
	
	main=new JPanel();
	main.setBounds(0,0,800,700);
	main.setLayout(null);

	//created button login 
    login = new JButton("Login");
    login.setBounds(400,50,100,100);
    //change color of the button
    login.setBackground(new Color(150,150,200));
    
    //created button sign up 
    signup = new JButton("SignUp");
    signup.setBounds(400,200,100,100);
    //change color of the button
    signup.setBackground(new Color(150,150,200));
      
    main.add(login);
    main.add(signup);
    main.setBackground(new Color(30,10,40));
    main.setVisible(true);
    this.add(main); //add panel to frame
    
   //=============================================================
    //Signup page
    
	Login=new JPanel();
	Login.setBounds(0,0,800,700);
	Login.setLayout(null);
	Login.setBackground(new Color(30,10,40));
    
    lusername=createLabel(lusername,"Username",30);
    username=createTextfield(username,30);
    
    lpass=createLabel(lpass,"Password",90);
    pass=createTextfield(pass,90);
    
    lverifypass=createLabel(lpass,"VerifyPwd",150);
    verifypass=createTextfield(pass,150);
    
    okay = new JButton("Verify");
    okay.setBounds(380,230,200,30);
    //change color of the JButton
    okay.setBackground(new Color(150,150,200));
    
    Login.add(lusername);
    Login.add(username);
    Login.add(lpass);
    Login.add(pass);
    Login.add(lverifypass);
    Login.add(verifypass);
    Login.add(okay);
    Login.setVisible(false);
    this.add(Login);
    //====================================================================

	 // insert page after login
    
	//created button insert 
    insert = new JButton("Insert");
    insert.setBounds(50,50,100,100);
    //change color of the button
    insert.setBackground(new Color(150,150,200));
   
    insertion=new JPanel();
	insertion.setBounds(0,0,800,700);
	insertion.setLayout(null);
    
    lRoll=createLabel(lRoll,"Roll number",30);
    roll=createTextfield(roll,30);
    
    lName=createLabel(lName,"Name",70);
    name=createTextfield(name,70);
    
    lDiv=createLabel(lDiv,"Division",110);
    div=createTextfield(div,110);
    
    lBranch=createLabel(lBranch,"Branch",150);
    branch=createTextfield(branch,150);
    
    lYear=createLabel(lYear,"Year",190);
    year=createTextfield(year,190);
    
    lPhno=createLabel(lPhno,"Phone number",230);
    phno=createTextfield(phno,230);
    
    lCat=createLabel(lCat,"Category",270);
    category=createTextfield(category,270);
    
    insertion.add(roll);
    insertion.add(lRoll);
    insertion.add(lName);
    insertion.add(name);
    insertion.add(lDiv);
    insertion.add(div);
    insertion.add(lBranch);
    insertion.add(branch);
    insertion.add(lYear);
    insertion.add(year);
    insertion.add(lPhno);
    insertion.add(phno);
    insertion.add(lCat);
    insertion.add(category);
    insertion.add(insert);
   
    
    insertion.setVisible(false);
     //change color of the JPanel insertion
    insertion.setBackground(new Color(30,10,40));
    this.add(insertion);
    
    //=======================================================================
     //Upload page
    upload1 = new JButton("Upload marksheet");
    upload1.setBounds(500,300,200,50);
    upload1.setBackground(new Color(150,150,200));
    
    lRoll = new JLabel("Upload Marksheet");
    lRoll.setBounds(100,300,200,200);
    lRoll.setOpaque(true);
    //change color of the JLabel
    lRoll.setBackground(Color.white);
    lRoll.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
    lRoll.setVisible(true);

    upload2 = new JButton("Upload aadhar");
    upload2.setBounds(500,50,200,50);
    upload2.setBackground(new Color(150,150,200));

    done=new JButton("Done");
	done.setBounds(500,400,200,50);
    done.setBackground(new Color(150,150,200));
    
    lName = new JLabel("Upload aadhar");
    lName.setBounds(100,50,200,200);
    lName.setOpaque(true);
    //change color of the JLabel
    lName.setBackground(Color.white);
    lName.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
    lName.setVisible(true);
    

    //======================================================================
    
    //pay interface 
    
     pay = new JButton("Search");
     pay.setBounds(30,290,100,100);
     pay.setBackground(new Color(150,150,200));
     
     cash=new JRadioButton("Cash");
     cash.setBounds(100, 200, 100, 50);
     
     dd=new JRadioButton("Demand Draft");
     dd.setBounds(200,200, 200, 50);
     
     mode=new ButtonGroup();
     mode.add(cash);
     mode.add(dd);
     
     full=new JRadioButton("Full");
     full.setBounds(100, 300, 100, 50);
     
     half=new JRadioButton("Half");
     half.setBounds(200,300, 200, 50);
     
     type=new ButtonGroup();
     type.add(full);
     type.add(half);
     
     getChallan = new JButton("Generate the Challan");
     getChallan.setBounds(200,400,200,50);
     getChallan.setBackground(new Color(150,150,200));
     
     lPhno=createLabel(lPhno,"Enter DD Number",230);
     phno=createTextfield(phno,230);
     
     lCat=createLabel(lCat,"Bank Address",270);
     category=createTextfield(category,270);
     //=========================================================================
     
    exit = new JButton("Exit");
    exit.setBounds(160,420,100,100);
    //change color of the button
    exit.setBackground(new Color(150,150,200));

    this.setVisible(true); //set visibility of frame to true
}
	
	public JLabel createLabel(JLabel l ,String name, int d) {

	    l = new JLabel(name);
	    l.setBounds(330,d,100,30);
	    l.setOpaque(true);
	    //change color of the JLabel
	    l.setBackground(Color.white);
	    l.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
	    l.setVisible(true);
	    return l;
	}
	public JTextField createTextfield(JTextField t,int d) {
		t = new JTextField();
	    t.setBounds(440,d,300,30);
	    t.setVisible(true);
        return t;
	}
	
}
