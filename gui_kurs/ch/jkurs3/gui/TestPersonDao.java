package ch.jkurs3.gui;

import java.util.List;

import ch.java_akademie.tools.MyTools;

public class TestPersonDao
{
	public static void main(String[] args) throws Exception
	{
		MyTools.uebOut("ch.jkurs3.gui.TestPersonDao.main()");
		
		PersonDao dao = new PersonDaoImpl("POSTGRES");

		dao.drop();
		dao.create();
		dao.insert(new Person(1, "huber", "basel"));
		dao.insert(new Person(2, "meier", "bern"));
		dao.insert(new Person(3, "gruber", "zuerich"));
		dao.insert(new Person(4, "schuster", "basel"));
		dao.insert(new Person(5, "gerber", "basel"));
		dao.insert(new Person(6, "schmied", "genf"));
		dao.insert(new Person(7, "schreiner", "bern"));
		dao.insert(new Person(8, "baecker", "bern"));
		dao.insert(new Person(9, "mueller", "zuerich"));
		dao.insert(new Person(10, "graf", "genf"));

		Person p = dao.getById(2);
		p.setName("KARL MAY");
		dao.update(p);

		Person p2 = dao.getById(11);
		if (p2 != null)
		{
			p.setName("KARL MAY");
			dao.update(p2);
		}

		dao.deleteByName("fritz");
		dao.deleteByName("graf%");
		dao.deleteById(7);

		showPersonen(dao.getAll());

	}


	private static void showPersonen(List<Person> personen)
	{
		MyTools.uebOut("   Personen           ", 2);

		for (Person p : personen)
		{
			System.out.println(p);
		}
	}
}
