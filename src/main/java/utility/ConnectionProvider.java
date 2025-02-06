package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection conn=null;

	
	public ConnectionProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection()
	{
		if(conn==null)
		{
			String url = "jdbc:mysql://localhost:3306/expensemgtsystem";
			try {
				conn=DriverManager.getConnection(url,"root","P@ssw0rd");
			} catch (SQLException e) {
			  	System.out.println("Something Went wrong while connecting with DB");
			}
		}
		return conn;
	}
	
	
	
	
}
