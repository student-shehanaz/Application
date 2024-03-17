package webApplication;

import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection
{
	private static Connection con=null;

	public DataBaseConnection() 
	{
	}
	static 
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","keerthi");
		System.out.println("db connection");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}
}
