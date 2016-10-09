package ch.jkurs3.gui;

import java.sql.SQLException;
import java.util.List;

import ch.java_akademie.tools.MyTools;
import junit.framework.TestCase;

public class UnitTestPersonDao extends TestCase
{
	private PersonDao dao;


	private void insert(String name, int min, int max)
			throws SQLException
	{
		for (int i = min; i <= max; i++)
		{
			dao.insert(new Person(i, name + i, "addr" + i));
		}
	}


	@Override
	protected void setUp() throws Exception
	{
		MyTools.uebOut("     SETUP            ", 5);

		dao = null;
		dao = new PersonDaoImpl("POSTGRES");

		try
		{
			dao.drop();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		dao.create();

		insert("hugo", 1, 5);
		insert("fritz", 6, 10);
		insert("max", 20, 20);
		insert("franz", 101, 110);
		
		System.out.println("end of setup");
	}


	private void showPersonen(List<Person> personen)
	{
		MyTools.uebOut("     Personen            ", 2);
		for (Person p : personen)
		{
			System.out.println(p);
		}
	}


	public void test1() throws SQLException
	{
		showPersonen(dao.getAll());
		System.out.println("del:" + dao.deleteByName("hugo%"));
		System.out.println("del:" + dao.deleteByName("fritz%"));
		System.out.println("del:" + dao.deleteByName("franz%"));
		System.out.println("del:" + dao.deleteById(20));
		showPersonen(dao.getAll());
		System.out.println("xxxxxxxxxxxxxxxx");
	}


	public void test2() throws SQLException
	{
		showPersonen(dao.getByName("hugo" + "%"));
		showPersonen(dao.getByName("fritz" + "%"));
		showPersonen(dao.getAll());
	}


	public void test3() throws SQLException
	{
		Person p = dao.getById(110);
		p.setName("KARL MAY");
		dao.update(p);
		showPersonen(dao.getAll());
	}
}
