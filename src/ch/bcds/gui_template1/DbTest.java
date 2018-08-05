package ch.bcds.gui_template1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbTest
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/test", "sa", "");

		Statement s = c.createStatement();

		s.execute("drop table person");
		s.execute("create table person(id int primary key, name varchar(100))");
		s.execute("insert into person values(11111,'hugo')");

		for (int i = 1; i <= 10; i++)
		{
			s.execute("insert into person values(" + i + ",'" + i
					+ "-name')");
		}

		String sql = "insert into person values(?,?)";
		PreparedStatement ps = c.prepareStatement(sql);

		for (int i = 20; i <= 30; i++)
		{
			ps.setInt(1, i);
			ps.setString(2, i + "-name");
			ps.execute();
		}

		s.execute("select * from person");

		ResultSet rs = s.getResultSet();

		while (rs.next())
		{
			System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		}

		c.close();
	}

}
