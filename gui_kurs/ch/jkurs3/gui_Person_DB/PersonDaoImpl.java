package ch.jkurs3.gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.java_akademie.tools.MyDataSource;

public class PersonDaoImpl implements PersonDao
{
	private String DROP_PERSON = "drop table person3";
	private String CREATE_PERSON = "create table person3 (id int not null, name varchar(20),addr varchar(20), primary key(id))";
	private String PERSON_GET_BY_ID = "select id, name, addr from person3 where id=?";
	private String PERSON_GET_BY_NAME = "select id, name, addr from person3 where name like ?";
	private String PERSON_GET_ALL = "select id, name, addr from person3";
	private String PERSON_DELETE_BY_ID = "delete from person3 where id=?";
	private String PERSON_DELETE_BY_NAME = "delete from person3 where name like ?";
	private String PERSON_UPDATE = "update person3 set name=?, addr=? where id =?";
	private String PERSON_INSERT = "insert into person3 values(?,?,?)";

	private MyDataSource ds;


	public PersonDaoImpl() throws Exception
	{
		ds = new MyDataSource();
	}


	public PersonDaoImpl(String database) throws Exception
	{
		ds = new MyDataSource(database);
	}


	@Override
	public void create() throws SQLException
	{
		ds.getConnection().createStatement().execute(CREATE_PERSON);
	}


	@Override
	public int delete(Person p) throws SQLException
	{
		return deleteById(p.getId());
	}


	@Override
	public int deleteById(Integer id) throws SQLException
	{
		int deleted = 0;

		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement(PERSON_DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		deleted = preparedStatement.executeUpdate();

		return deleted;
	}


	@Override
	public int deleteByName(String name) throws SQLException
	{
		int deleted = 0;

		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement(PERSON_DELETE_BY_NAME);
		preparedStatement.setString(1, name);
		deleted = preparedStatement.executeUpdate();

		return deleted;
	}


	@Override
	public void drop() throws SQLException
	{
		try
		{
			ds.getConnection().createStatement().execute(DROP_PERSON);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	@Override
	public List<Person> getAll() throws SQLException
	{
		List<Person> personen = new ArrayList<Person>();
		Statement statement = ds.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(PERSON_GET_ALL);
		while (rs.next())
		{
			personen.add(new Person(rs.getInt(1), rs.getString(2), rs
					.getString(3)));
		}
		return personen;
	}


	@Override
	public Person getById(Integer id) throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement(PERSON_GET_BY_ID);
		preparedStatement.setInt(1, id);
		rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			return new Person(rs.getInt(1), rs.getString(2),
					rs.getString(3));
		}

		return null;
	}


	@Override
	public List<Person> getByName(String name) throws SQLException
	{
		List<Person> personen = new ArrayList<Person>();
		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement(PERSON_GET_BY_NAME);
		preparedStatement.setString(1, name);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			personen.add(new Person(rs.getInt(1), rs.getString(2), rs
					.getString(3)));
		}
		return personen;
	}


	@Override
	public void insert(Person p) throws SQLException
	{
		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement(PERSON_INSERT);
		preparedStatement.setInt(1, p.getId());
		preparedStatement.setString(2, p.getName());
		preparedStatement.setString(3, p.getAddr());
		preparedStatement.executeUpdate();
	}


	@Override
	public int update(Person p) throws SQLException
	{
		int updated = 0;

		PreparedStatement preparedStatement = ds.getConnection()
				.prepareStatement(PERSON_UPDATE);
		preparedStatement.setInt(3, p.getId());
		preparedStatement.setString(1, p.getName());
		preparedStatement.setString(2, p.getAddr());
		updated = preparedStatement.executeUpdate();

		return updated;
	}
}
