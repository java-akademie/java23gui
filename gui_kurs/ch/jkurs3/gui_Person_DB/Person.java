package ch.jkurs3.gui;


public class Person
{
	private Integer id;
	private String name;
	private String addr;


	public Person()
	{
	}


	public Person(Integer id, String name, String addr)
	{
		this.id = id;
		this.name = name;
		this.addr = addr;
	}


	public String getAddr()
	{
		return addr;
	}


	public Integer getId()
	{
		return id;
	}


	public String getName()
	{
		return name;
	}


	public void setAddr(String addr)
	{
		this.addr = addr;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	@Override
	public String toString()
	{
		return String.format("%3d / %-8s / %-8s ", id, name, addr);
	}
}
