package Project;

import java.util.Scanner;

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int choice=0 ;
		  do {
			  System.out.println("Choose : 1.Student Login \n2.Admin Login \n3.Bank Login\n4.Exit");
			  Scanner sc =new Scanner(System.in);
			  choice=sc.nextInt();
		      if(choice==1) {
				new Controller();
		      }
		      else if(choice==2) {
		    	  new AdminController();
		      }
		      else if(choice==3) {
		    	  
		      }
              else if(choice==4) {
		    	  System.exit(0);
		      }
		  }while(choice!=4);
	}
}
