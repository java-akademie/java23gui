package ch.jmildner.gui.personenverwaltung;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import ch.java_akademie.tools.MyTools;

/**
 * 
 * Die Klasse <code>MyDataSource</code>dient dazu, dass DB-Programme bezueglich des gewuenschten DBMS variabel bleiben
 * koennen.
 * 
 * Die Klasse <code>MyDataSource</code>hat eine <code>getConnection()</code> -Methode, die die passende Connection zu
 * einem gewuenschten DBMS liefert.
 * 
 * Die Informationen DRIVER,URL,USER,PW kommen aus einer Property-Datei <code>db.props</code>, die im Class-Path stehen
 * muss.
 * 
 * 
 * <pre>
 *   ---------------------------------------------------------------
 *   Anwendungsbeispiel:
 *   ---------------------------------------------------------------
 *   public static void main(String[] args) throws Exception
 *   {
 * 		Connection c = new MyDataSource().getConnection();
 * 		Statement s = c.createStatement();
 * 
 * 		//s.execute("drop table person");
 * 		s.execute("create table person (id int, name varchar(20))");
 * 		s.execute("insert into person values(123,'hugo')");
 * 		s.execute("insert into person values(124,'max')");
 * 		s.execute("select id,name from person");
 * 
 * 		ResultSet rs = s.getResultSet();
 * 		while (rs.next())
 * 		{
 * 			System.out.println(rs.getInt(1) + "   " + rs.getString(2));
 * 		}
 * 		rs.close();
 * 
 * 		s.close();
 * 		c.close();
 * 	 }
 *   ----------------------------------------------------------------
 * </pre>
 * 
 * 
 * <pre>
 *   ---------------------------------------------------------------
 *   die Property-Datei - db.props
 *   ---------------------------------------------------------------
 *   DEFAULT_DB=MYSQL
 * 
 *   H2.driver=org.h2.Driver
 *   H2.url=jdbc:h2:tcp://localhost/~/test
 *   H2.user=sa
 *   H2.pwd=
 * 
 *   MYSQL.driver=com.mysql.jdbc.Driver
 *   MYSQL.url=jdbc:mysql://localhost:3306/jees
 *   MYSQL.user=jees
 *   MYSQL.pwd=jees
 * 
 *   ORACLE.driver=oracle.jdbc.driver.OracleDriver
 *   ORACLE.url=jdbc:oracle:thin:@localhost:1521:xe
 *   ORACLE.user=jees
 *   ORACLE.pwd=jees
 * 
 *   POSTGRES.driver=org.postgresql.Driver
 *   POSTGRES.url=jdbc:postgresql://localhost:5432/jees
 *   POSTGRES.user=jees
 *   POSTGRES.pwd=jees
 *   ----------------------------------------------------------------
 * </pre>
 * 
 * @author Johann Mildner
 * 
 */
public class MyDataSource
{
	/**
	 * Properties
	 */
	private String databasePropertiesName = "/database.properties";
	private Properties props;
	private String database;

	/**
	 * Die Connection zur Datenbank
	 */
	private Connection connection;


	/**
	 * Setzt die Connection auf die Datenbank die in database.properties als DEFAULT_DB angegeben ist.
	 * 
	 * @throws Exception
	 */
	public MyDataSource() throws Exception
	{
		this((String) null);
	}


	/**
	 * Setzt die Connection auf die Datenbank die im Parameter 'database' uebergeben wird.
	 * 
	 * @throws Exception
	 */
	public MyDataSource(String database) throws Exception
	{
		propertiesFuellen(databasePropertiesName, database);
		setConnection();
	}


	/**
	 * Liefert die Connection zur Datenbank
	 * 
	 * @return Connection
	 */
	public Connection getConnection()
	{

		return connection;
	}


	private void propertiesFuellen(String dbProps, String database)
			throws IOException
	{
		props = new Properties();
		props.load(this.getClass().getResourceAsStream(dbProps));


		if (database == null)
			this.database = props.getProperty("DEFAULT_DB");
		else
			this.database = database;
	}


	private void setConnection() throws Exception
	{
		MyTools.uebOut("Database: " + database, 1);
		String DRIVER = props.getProperty(database + ".driver");
		String URL = props.getProperty(database + ".url");
		String USER = props.getProperty(database + ".user");
		String PWD = props.getProperty(database + ".pwd");

		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL, USER, PWD);
	//	connection.setAutoCommit(false);
	}
}
