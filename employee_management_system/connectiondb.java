package employee_management_system;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
public class connectiondb {
	static Connection con = null;
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","@Sidhu260");
			}	
	        catch(Exception c)
			{
	        	System.out.println(c);
			}
		    return con;
	}

}
