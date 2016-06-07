package ch.jmildner.gui.personenverwaltung;

import ch.java_akademie.tools.MyTools;

public class Person
{
	private int id;
	private String name;
	private String addr;


	public Person()
	{
		id = MyTools.getInteger("     ID      > ");
		name = MyTools.getString("     Name    > ");
		addr = MyTools.getString("     Adresse > ");
	}


	public Person(int id, String name, String addr)
	{
		this.id = id;
		this.name = name;
		this.addr = addr;
	}


	public Person(String str)
	{
		String[] arr = str.split("::");

		id = Integer.parseInt(arr[0]);
		name = arr[1];
		addr = arr[2];
	}


	@Override
	public boolean equals(Object that)
	{
		if (!(that instanceof Person))
		{
			return false;
		}

		if (this.id == ((Person) that).id)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public int getId()
	{
		return id;
	}


	public String show()
	{
		System.out.println("     ID     : " + id);
		System.out.println("     Name   : " + name);
		System.out.println("     Adresse: " + addr);
		System.out.println();

		StringBuffer sb = new StringBuffer();

		sb.append("     ID     : " + id + "\n");
		sb.append("     Name   : " + name + "\n");
		sb.append("     Adresse: " + addr + "\n");
		sb.append("\n");

		return sb.toString();
	}


	@Override
	public String toString()
	{
		return id + "::" + name + "::" + addr;
	}
}
