package java_project;

import java.util.*;
import java.sql.*;




class Bank{
	
	static Connection con =Connection_database.getConnection();
	
	
	public long  account_no;
	public String name;
	public String address;
	public char account_type;
	public long aadhar_no;
	public double balance;
	public String sql="";
	
	// Constructor
	
	Bank(){
		account_no=0;
		name="";
		address="";
		account_type=' ';
		balance=0;
		aadhar_no=0;
	}
	
	// Creating Customer Account
	
	void createAccount() throws SQLException {
		Random rand = new Random();
		   
        // Generate random integers in range 0 to 99999
		
        account_no = rand.nextInt(100000);
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Your Name : ");
		name=sc.nextLine();
		System.out.println("\nEnter Your Address : ");
		address=sc.nextLine();
		System.out.println("\nEnter Account Type : ");
		account_type=sc.next().charAt(0);
		System.out.println("\nEnter Your Aadhar No. : ");
		aadhar_no=sc.nextLong();
		//sc.close();
		
		
		// database
		try {
 
            // query
            Statement st = con.createStatement();
            sql = "INSERT INTO customer(c_accountNo,c_name,c_address,c_account_type,c_aadhar,balance) values("+account_no+","+"'"
                  + name + "'"+","+"'"+address+"'"+","+"'"+account_type+"'"+","+aadhar_no+","+balance+")";
 
            // Execution
            if (st.executeUpdate(sql) == 1) {
            	System.out.println("\n-----------Your Account Created Successfully-----------");  
            }
           
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Failed !"+e.toString());
        }
				
		
	}
	
	
	
	// Updating Customer Details
	
	void updateCustomer() throws SQLException {
		Scanner sc=new Scanner(System.in);
		int choice;
		long  account_no1;
		String name1;
		String address1;
		char account_type1;
		long aadhar_no1;
		System.out.println("\nEnter Your Account No. : ");
		account_no1=sc.nextLong();
		sc.nextLine();
		
		do {
			System.out.println("\n 1> Customer Name : ");
			System.out.println("\n 2> Customer Address ");
			System.out.println("\n 3> Customer Account Type ");
			System.out.println("\n 4> Customer Aadhar No. ");
			System.out.println("\n 5> Exit.. ");
			System.out.println("\n What do you want to update : ");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			      case 1:
			    	  System.out.println("\n Enter New Name ");
			    	  sc.nextLine();
			    	  name1=sc.nextLine();
			    	
			    	  Statement st = con.createStatement();
			            sql ="UPDATE customer SET c_name="+"'"+name1+"'"+"WHERE c_accountNo="+account_no1;
			 
			            // Execution
			            if (st.executeUpdate(sql) == 1) {
			            	System.out.println("\n-----------Details Updated Successfully-----------");  
			            }
			           break;
			      case 2:
			    	  System.out.println("\n Enter New Address ");
			    	  sc.nextLine();
			    	  address1=sc.nextLine();
			    	  Statement st2 = con.createStatement();
			            sql ="UPDATE customer SET c_address="+"'"+address1+"'"+"WHERE c_accountNo="+account_no1;
			 
			            // Execution
			            if (st2.executeUpdate(sql) == 1) {
			            	System.out.println("\n-----------Details Updated Successfully-----------");  
			            }
			           break;
			      case 3:
			    	  System.out.println("\n Enter New Account Type ");
			    	  sc.nextLine();
			    	  account_type1=sc.next().charAt(0);
			    	  Statement st3 = con.createStatement();
			            sql ="UPDATE customer SET c_account_type="+"'"+account_type1+"'"+"WHERE c_accountNo="+account_no1;
			 
			            // Execution
			            if (st3.executeUpdate(sql) == 1) {
			            	System.out.println("\n-----------Details Updated Successfully-----------");  
			            }
			           break;
			      case 4:
			    	  System.out.println("\n Enter New Aadhar ");
			    	  aadhar_no1=sc.nextLong();
			    	  Statement st4 = con.createStatement();
			            sql ="UPDATE customer SET c_aadhar="+"'"+aadhar_no1+"'"+"WHERE c_accountNo="+account_no1;
			 
			            // Execution
			            if (st4.executeUpdate(sql) == 1) {
			            	System.out.println("\n-----------Details Updated Successfully-----------");  
			            }
			           break; 
			      case 5:
			    	  break;
			}
		} while(choice!=5);
		//sc.close();
	}
	


    //  Deleting Customer Details
   
      void deleteCustomer() throws SQLException {
    	  Scanner sc=new Scanner(System.in);
    	  long account_no2;
    	  System.out.println("\nEnter Your Account No. : ");
  		  account_no2=sc.nextLong();
	  		 Statement st = con.createStatement();
	         sql ="DELETE FROM customer WHERE c_accountNo="+account_no2;
	
	         // Execution
	         if (st.executeUpdate(sql) == 1) {
	         	System.out.println("\n-----------Account Deleted Successfully-----------");  
	         }
	        // sc.close();
      }


      
      // Get any Customer Details
      
      void getCustomerDetails() throws SQLException {
    	  Scanner sc=new Scanner(System.in);
    	  long account_no4;
    	  System.out.println("\nEnter Your Account No. : ");
  		  account_no4=sc.nextLong();
  		  
  		    sql="select * from customer where c_accountNo="+account_no4;
	  		PreparedStatement st=con.prepareStatement(sql);
	  		 
	        ResultSet rs = st.executeQuery(sql);
	        System.out.println("----------------------------------------------------------------------");
	      
	        //System.out.println("Account_No"+"  "+"Name"+"  "+"Address"+"  "+"Account_Type"+"  "+"Aadhar"+"  "+"Balance");
	        
	        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%8s|%13s| %n","Account_No","Name","Address","Account_Type","Aadhar","Balance");
            System.out.println("----------------------------------------------------------------------");
	        
	        
	        // Execution
	        if (rs.next()) {
//	            
	            long acc=rs.getLong("c_accountNo");
	            String nam=rs.getString("c_name");
	            String add=rs.getString("c_address");
	            char type=rs.getString("c_account_type").charAt(0);
	            long adh=rs.getLong("c_aadhar");
	            double bal=rs.getDouble("balance");
	            
//	            
//	               System.out.println("----------------------------------------------------------------");  
//	 	           System.out.println("Account No : "+acc);
//	 	           System.out.println("Account Holder Name : "+nam);
//	 	           System.out.println("Address : "+add);
//		 	       System.out.println("Account Type : "+type);
//		 	       System.out.println("Aadhar : "+adh);
//		 	       System.out.println("Your Balance : "+bal);
//		 	       System.out.println("----------------------------------------------------------------");
	            
	            //System.out.println(acc+"|      |"+nam+"|  |"+add+"|    |"+type+"|             |"+adh+"|     |"+bal);
	            
		 	      
	               System.out.printf("|%-10d|%-10s|%-10s|%-12c|%8d|%13.2f| %n",acc,nam,add,type,adh,bal);
	               System.out.println("----------------------------------------------------------------------");
	            
	        }
	       // sc.close();
  		  //rs.close();
      }
      
      
      
      
      
    //  Display all Customers
      
      
      
      void displayAll() throws SQLException {
    	  
    	  
    	    sql="select * from customer";
            PreparedStatement st=con.prepareStatement(sql);
 
            ResultSet rs = st.executeQuery(sql);
            System.out.println("----------------------------------------------------------------------");
           
          //  System.out.println();
            System.out.printf("|%-10s|%-10s|%-10s|%-10s|%8s|%13s| %n","Account_No","Name","Address","Account_Type","Aadhar","Balance");
            System.out.println("----------------------------------------------------------------------");
            // Execution
            while (rs.next()) {
//                
            	long acc1=rs.getLong("c_accountNo");
 	            String nam1=rs.getString("c_name");
 	            String add1=rs.getString("c_address");
 	            char type1=rs.getString("c_account_type").charAt(0);
 	            long adh1=rs.getLong("c_aadhar");
 	            double bal1=rs.getDouble("balance");
 	            
// 	           System.out.println("----------------------------------------------------------------");  
// 	           System.out.println("Account No : "+acc1);
// 	           System.out.println("Account Holder Name : "+nam1);
// 	           System.out.println("Address : "+add1);
//	 	       System.out.println("Account Type : "+type1);
//	 	       System.out.println("Aadhar : "+adh1);
//	 	       System.out.println("Your Balance : "+bal1);
//	 	       System.out.println("----------------------------------------------------------------");
	 	            
 	           // System.out.println(acc1+"|      |"+nam1+"|  "+add1+"|    |"+type1+"|             |"+adh1+"|     |"+bal1);
 	            
 	            
 	          
 	            
               System.out.printf("|%-10d|%-10s|%-10s|%-12c|%8d|%13.2f| %n",acc1,nam1,add1,type1,adh1,bal1);
               System.out.println("----------------------------------------------------------------------");
               
            }
          
  		  
           
      }
         
      
      
     // Deposit
      
      void deposit() throws SQLException {
    	  Scanner sc=new Scanner(System.in);
    	  long account_no5;
    	  System.out.println("\nEnter Your Account No. : ");
  		  account_no5=sc.nextLong();
  		  int amount;
  		 System.out.println("\n Enter Amount : ");
  		 amount=sc.nextInt();
  		 		 
  		 
  		 Statement st = con.createStatement();
         sql ="UPDATE customer SET balance=balance+"+amount+" WHERE c_accountNo="+account_no5;

         // Execution
         if (st.executeUpdate(sql) == 1) {
         	System.out.println("\n-----------Amount Deposited Successfully-----------");  
         }
        // sc.close();
      }
      
      
      
      // Withdrawal
      
      void withdraw() throws SQLException {
    	  Scanner sc=new Scanner(System.in);
    	  long account_no6;
    	  System.out.println("\nEnter Your Account No. : ");
  		  account_no6=sc.nextLong();
  		  int amount;
  		 System.out.println("\n Enter Amount : ");
  		 amount=sc.nextInt();
  		 
  		sql = "select * from customer where c_accountNo="+account_no6;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

          if (rs.next()) {
              if (rs.getInt("balance") < amount) {
                  System.out.println("Insufficient Balance!!");
                  //sc.close();
                  return;
              }
          }
  		 
  		 
  		 Statement st = con.createStatement();
         sql ="UPDATE customer SET balance=balance-"+amount+" WHERE c_accountNo="+account_no6;

         // Execution
         if (st.executeUpdate(sql) == 1) {
         	System.out.println("\n-----------Amount withdrawn Successfully-----------");  
         }
         //sc.close();
      }
      
      
      
      
      // Transfer Money
      
      void transferMoney() throws SQLException {
    	  Scanner sc=new Scanner(System.in);
    	  long receiver_account_no;
    	  long sender_account_no;
    	  System.out.println("\nEnter Your Account No. : ");
    	  sender_account_no=sc.nextLong();
    	  System.out.println("\nEnter Receiver Account No. : ");
    	  receiver_account_no=sc.nextLong();
    	  int amount2;
    	  System.out.println("\n Enter Amount to Transfer : ");
    	  amount2=sc.nextInt();
    	  
    	  sql = "select * from customer where c_accountNo="+sender_account_no;
          PreparedStatement ps = con.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt("balance") < amount2) {
                    System.out.println("Insufficient Balance!!");
                    //sc.close();
                    return;
                }
            }
            
            Statement st = con.createStatement();
            con.setSavepoint();
            
            sql = "UPDATE customer SET balance=balance-"+amount2+ " WHERE c_accountNo=" +sender_account_no;
            if (st.executeUpdate(sql) == 1) {
                System.out.println("\n----------Amount Transfered Successfully------------");
            }
 
            // credit
            sql = "UPDATE customer SET balance=balance+" +amount2+ " WHERE c_accountNo=" +receiver_account_no;
            st.executeUpdate(sql);
 
            //con.commit();
            //sc.close();
      }
}
 
      
