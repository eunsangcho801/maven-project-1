import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMariaDB
{
	public static void main(String[] args)
	{		
		String dbUrl = "jdbc:mysql://10.240.49.248/tizendb";
		String dbUser = "tizen";
		String dbPswd = "1q2w3e4r";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Loading OK. *^^*");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver Loading Error. ^^;");
			System.out.println(e.toString());
			return;
		}
		
		try
		{
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPswd);
			System.out.println("Driver Connection OK. *^^*");
		}
		catch (SQLException e)
		{
			System.out.println("Driver Connection Error. ^^;");
			System.out.println(e.toString());
			return; 
		}
		
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM TB_TIZEN_USER");
			while (rs.next())
			{
				System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
			}
		}
		catch (SQLException e)
		{
			System.out.println("executeQuery() Error. ^^;");
			System.out.println(e.toString());
		}
		
		try
		{
			if (rs != null)
			{
				rs.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.toString());
		}
	}
}
