package genericUtilities;

/**
 * 
 * @author abhishek
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DataBaseUtilities
{
	Connection con = null;
	ResultSet result = null;

	/**
	 * to connect to DataBase
	 * 
	 * 
	 */
	public  void connectToDB() throws Throwable 
	{
		
	com.mysql.jdbc.Driver driverRef=new com.mysql.jdbc.Driver();
	DriverManager.registerDriver(driverRef);
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
	}
	
	/**
	 * to close DataBase connection
	 * 
	 * 
	 */
	public  void closeDb() throws SQLException 
	{
	con.close();
	}
	

	/**
	 * to executive query to fetch data from DB
	 * 
	 * @param query
	 * 
	 */
	public ResultSet executeQuery(String query) throws Throwable 
	{
	
	result = con.createStatement().executeQuery(query);
	return result;
		
	}
}


