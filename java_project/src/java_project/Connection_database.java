package java_project;


import java.sql.*;




public class Connection_database {
	
	static Connection con;
	
    public static Connection getConnection()
    {
        try {
            
            String url= "jdbc:mysql://localhost:3306/bank"; 
            String user = "root";        
            String pass = "tiger";  
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url, user, pass);
            
        }
        catch (Exception e) {
            System.out.println("Connection Failed!789");
        }
 
        return con;
    }
}
