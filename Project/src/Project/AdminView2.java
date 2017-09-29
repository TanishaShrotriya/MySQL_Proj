package Project;
import javax.swing.*;

import java.awt.*;
@SuppressWarnings("serial")
public class AdminView2 extends JFrame{	
		
		JPanel main,insertion,Login;
		JButton login,callBack,Docs,DdDetails,cashDetails,toBank,
		        verify,nextImg,prevImg,back,back2,back3,back4,
		        install2,fromBank,unverified,search,checkDocs,checkDD,checkCash,exit;
		//okay used with verification process operation
		JTextField roll,name,div,branch,year,phno,category,username,pass;
		JLabel lMark,lAadhar,lReceit,lBranch,lYear,lPhno,lCat,lusername,lpass,DD,Cash,cBack;
		
		JRadioButton cash,dd,full,half;
		ButtonGroup mode,type;
		JTable t1,cashD;
		
		AdminView2(){

		this.setSize(1000,1000); 
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		main=new JPanel();
		main.setBounds(0,0,1000,1000);
		main.setLayout(null);

		//created button login 
	    login = new JButton("Login");
	    login.setBounds(350,350,100,100);
	    login.setBackground(new Color(150,150,200));
	
	    main.add(login);
	    main.setBackground(new Color(30,10,40));
	    main.setVisible(true);
	    this.add(main); //add panel to frame
	    
	   //=============================================================
	    //Login page
	    
		Login=new JPanel();
		Login.setBounds(0,0,1000,1000);
		Login.setLayout(null);
		Login.setBackground(new Color(30,10,40));
	    
	    lusername=createLabel(lusername,"Username",30);
	    username=createTextfield(username,30);
	    
	    lpass=createLabel(lpass,"Password",90);
	    pass=createTextfield(pass,90);
	    
	    verify = new JButton("Verify");
	    verify.setBounds(380,230,200,30);
	    verify.setBackground(new Color(150,150,200));
	    
	    Login.add(lusername);
	    Login.add(username);
	    Login.add(lpass);
	    Login.add(pass);
	    Login.add(verify);
	    Login.setVisible(false);
	    this.add(Login);
	    //====================================================================

		 // insert page after login
	  /*  
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
	  //  insertion.add(insert);
	   */
	   
	    //=======================================================================
	     //Main Page
	    
	    insertion=new JPanel();
		insertion.setBounds(0,0,1000,1000);
		insertion.setLayout(null);
		
	    Docs=new JButton("View Document Details");
	    Docs.setBounds(150,200,200,50);
	    Docs.setBackground(new Color(150,150,200));
      
	    DdDetails = new JButton("View DD Details");
	    DdDetails.setBounds(150,300,200,50);
	    DdDetails.setBackground(new Color(150,150,200));

	    cashDetails = new JButton("View Cash Details");
	    cashDetails.setBounds(150,400,200,50);
	    cashDetails.setBackground(new Color(150,150,200));
	    
	    callBack = new JButton("Call Back");
	    callBack.setBounds(150,500,200,50);
	    callBack.setBackground(new Color(150,150,200));
	   
	    exit = new JButton("Exit");
	    exit.setBounds(150,600,200,50);
	    exit.setBackground(new Color(150,150,200));
	    
	    insertion.add(Docs);
	    insertion.add(DdDetails);
	    insertion.add(cashDetails);
	    insertion.add(callBack);
	    insertion.add(exit);
	    insertion.setBackground(new Color(30,10,40));
	    insertion.setVisible(false);
	    this.add(insertion);
	    //======================================================================
	    
	    //View Documents 
	    lMark = new JLabel("Upload Marksheet");
	    lMark.setBounds(400,400,300,300);
	    lMark.setOpaque(true);
	    //change color of the JLabel
	    lMark.setBackground(Color.white);
	    lMark.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
	    lMark.setVisible(true);
	    
	    lAadhar = new JLabel("Upload aadhar");
	    lAadhar.setBounds(400,50,300,300);
	    lAadhar.setOpaque(true);
	    //change color of the JLabel
	    lAadhar.setBackground(Color.white);
	    lAadhar.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
	    lAadhar.setVisible(true);
	   
	    lReceit = new JLabel("Upload Receit");
	    lReceit.setBounds(50,400,300,300);
	    lReceit.setOpaque(true);
	    //change color of the JLabel
	    lReceit.setBackground(Color.white);
	    lReceit.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
	    lReceit.setVisible(true);
	    

	    checkDocs=new JButton("Mark as verified");
	    checkDocs.setBounds(750,50,200,50);
	    checkDocs.setBackground(new Color(150,150,200));
      
	    nextImg = new JButton("View next document");
	    nextImg.setBounds(750,150,200,50);
	    nextImg.setBackground(new Color(150,150,200));

	    prevImg = new JButton("View prev document");
	    prevImg.setBounds(750,250,200,50);
	    prevImg.setBackground(new Color(150,150,200));
	    
	    search = new JButton("Search by name");
	    search.setBounds(750,350,200,50);
	    search.setBackground(new Color(150,150,200));
	    
	    back = new JButton("Go to menu");
	    back.setBounds(750,450,200,50);
	    back.setBackground(new Color(150,150,200));
	     
	    //=====================================================================
	    
	    //DD Details
	    DD=new JLabel("Payment Mode DD ");
	    DD.setOpaque(true);
	    DD.setBackground(Color.WHITE);
	    DD.setBounds(250, 150, 400, 50);
	    
	    toBank = new JButton("Send DD details to Bank");
	    toBank.setBounds(250,250,400,50);
	    toBank.setBackground(new Color(150,150,200));
	    
	    checkDD = new JButton("Verify DD Payment for student");
	    checkDD.setBounds(250,350,400,50);
	    checkDD.setBackground(new Color(150,150,200));
	    
	    back2 = new JButton("Go to menu");
	    back2.setBounds(250,450,400,50);
	    back2.setBackground(new Color(150,150,200));

	   //=========================================================================
	     
	   // Cash Details
	    Cash=new JLabel("Enter denominations ");
	    Cash.setOpaque(true);
	    Cash.setBackground(Color.WHITE);
	    Cash.setBounds(200, 100, 400, 50);
	    
		String data[][]= {  {"2000","0"},
			            	{"500","0"},
			            	{"100","0"},
			            	{"50","0"},
			            	{"20","0"},
			    	        {"10","0"},
			    	        {"Total","0"}
			    	        
        };
		
        String col[]= {"Denomination","Quantity"};
        cashD=new JTable(data,col);
	    cashD.setBounds(200,200,300,115);
	    
	    checkCash= new JButton("Verify Payment");
	    checkCash.setBounds(200,400,200,50);
	    checkCash.setBackground(new Color(150,150,200));
	    
	    back3= new JButton("Go to Menu");
	    back3.setBounds(200,500,200,50);
	    back3.setBackground(new Color(150,150,200));
	    
	    //=======================================================================
        //call backs
	    cBack=new JLabel("List out Call Back Students for -");
	    cBack.setOpaque(true);
	    cBack.setBackground(Color.WHITE);
	    cBack.setBounds(250, 150, 400, 50);
	    
	    unverified = new JButton("Unverified Records");
	    unverified.setBounds(250,250,400,50);
	    unverified.setBackground(new Color(150,150,200));
	    
	    
	    fromBank = new JButton("DD Details incorrect sent back from Bank");
	    fromBank.setBounds(250,250,400,50);
	    fromBank.setBackground(new Color(150,150,200));
	    
	    install2 = new JButton("Installation 2 Due");
	    install2.setBounds(250,350,400,50);
	    install2.setBackground(new Color(150,150,200));
	    
	    back4 = new JButton("Go to menu");
	    back4.setBounds(250,450,400,50);
	    back4.setBackground(new Color(150,150,200));
	    
	    
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
