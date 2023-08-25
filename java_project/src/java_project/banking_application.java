package java_project;

import java.util.*;
import java.sql.*;     

public class banking_application {

	public static void main(String[] args) throws SQLException {
		
		
		
		Scanner sc=new Scanner(System.in);
		
		Bank bank=new Bank();
		int choice2;
		
		do {
			 System.out.println("\n-------------WELCOME TO INDIA FIRST BANK---------------");
			 System.out.println("1> Create Account ");
			 System.out.println("2> Update Account Details ");
			 System.out.println("3> Delete Account ");
			 System.out.println("4> Get Account Details ");
			 System.out.println("5> Get All Account Details ");
			 System.out.println("-------------------------------------");
			 System.out.println("6> More Options ");
			 System.out.println("7> Exit..");
			
			 System.out.print("Enter Your Choice : ");
			 
			 choice2=sc.nextInt();
			 
			 
			 switch(choice2) {
			         case 1:
			        	 bank.createAccount();
			        	 break;
			         case 2:
			        	 bank.updateCustomer();
			        	 break;
			         case 3:
			        	 bank.deleteCustomer();
			        	 break;
			         case 4:
			        	 bank.getCustomerDetails();
			        	 break;
			         case 5:
			        	 bank.displayAll();
			        	 break;
			         case 6:
			        	  int choice3;
			        	  
			        	  do {
			        		     System.out.println("1> Deposit Money ");
				     			 System.out.println("2> Withdraw Money ");
				     			 System.out.println("3> Transfer Money ");
				     			 System.out.println("4> Exit..");
				     			 System.out.println("Enter Your Choice : ");
				     			 choice3=sc.nextInt();
				     			 
				     			 switch(choice3) {
				     			     case 1:
						     			 bank.deposit();
							        	 break;
							         case 2:
							        	 bank.withdraw();
							        	 break;
							         case 3:
							        	 bank.transferMoney();
							        	 break;
							         case 4:
							        	 break;
				     			 }
				     			 
			        	  } while(choice3!=4);
			        	 
			        
			         case 7:
			        	 System.out.println("Thank You For Visiting.....");
			        	 break;
			 }
			 
		
		} while(choice2!=9);
		
		

	}

}
