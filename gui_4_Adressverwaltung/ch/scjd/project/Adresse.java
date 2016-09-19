package ch.scjd.project;

import java.io.Serializable;
import java.util.StringTokenizer;

import ch.java_akademie.tools.MyTools;

public class Adresse implements Serializable
{
	private static final long serialVersionUID = 1L;

	private static int maxID = 0;


	public static void main(String[] args)
	{
		Adresse a = new Adresse();
		a.show();
		Adresse b = new Adresse(1 + a.toString());
		b.show();
		Adresse c = new Adresse("", "");
		c.show();
		Adresse d = new Adresse("", "");
		d.show();

	}

	int id;

	String name;


	String addr;


	public Adresse()
	{
		id = MyTools.getInteger("bitte id eingeben > ");
		name = MyTools.getString("bitte name eingeben > ");
		addr = MyTools.getString("bitte adresse eingeben > ");
	}


	public Adresse(int id, String name, String addr)
	{
		this.id = id;
		this.name = name;
		this.addr = addr;
		maxID = (maxID > id ? maxID : id);
	}


	public Adresse(String str)
	{
		StringTokenizer st = new StringTokenizer(str, "\\");
		id = Integer.parseInt((String) st.nextElement());
		name = (String) st.nextElement();
		addr = (String) st.nextElement();
		maxID = (maxID > id ? maxID : id);
	}


	public Adresse(String name, String addr)
	{
		id = ++maxID;
		this.name = name;
		this.addr = addr;
	}


	public String getAddr()
	{
		return addr;
	}


	public int getID()
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


	public void setName(String name)
	{
		this.name = name;
	}


	public void show()
	{
		System.out.println("id      : " + id);
		System.out.println("name    : " + name);
		System.out.println("adresse : " + addr);
	}


	@Override
	public String toString()
	{
		return id + "\\" + name + "\\" + addr + "\\";
	}
}
