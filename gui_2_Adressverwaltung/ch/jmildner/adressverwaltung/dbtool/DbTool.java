package ch.jmildner.adressverwaltung.dbtool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public final class DbTool
{

	private final static String LF = "\n";
	private final static DbTool instance = new DbTool();

	private Connection connection;

	private static final String DRV = "org.h2.Driver";
	private static final String URL = "jdbc:h2:tcp://localhost/~/test";
	private static final String USR = "sa";
	private static final String PWD = "sa";


	public static DbTool getInstance()
	{
		return instance;
	}


	private DbTool()
	{
	}


	public String closeDB() throws Exception
	{
		connection.close();
		connection = null;
		return "closeDB OK" + LF;

	}


	public String createAddress() throws Exception
	{
		Statement s = connection.createStatement();
		s.execute("create table address "
				+ "(id int, name varchar(20), addr varchar(20), "
				+ "primary key(id))");
		return "createAddress OK" + LF;
	}


	public String dropAddress() throws Exception
	{
		Statement s = connection.createStatement();
		s.execute("drop table address");
		return "dropAddress OK" + LF;

	}


	public String insertAddress(int id, String name, String addr)
	{
		try
		{
			String query = "insert into address values(?,?,?)";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, addr);
			ps.execute();
			return "insertAddress OK" + LF;
		}
		catch (Exception e)
		{
			return "insertAddress NOK " + LF + e;
		}
	}


	public String openDB() throws Exception
	{
		Class.forName(DRV);
		connection = DriverManager.getConnection(URL, USR, PWD);
		return "openDB OK" + LF;
	}


	public Vector<Vector<String>> selectAddress()
	{
		Vector<Vector<String>> sqlData = new Vector<Vector<String>>();
		Vector<String> row = null;

		try
		{
			Statement s = connection.createStatement();
			s.execute("select * from address");
			ResultSet r = s.getResultSet();

			while (r.next())
			{
				row = new Vector<String>();
				row.add(r.getString(1));
				row.add(r.getString(2));
				row.add(r.getString(3));
				sqlData.add(row);
			}
		}
		catch (Exception e)
		{

			return sqlData;
		}

		return sqlData;
	}
}
