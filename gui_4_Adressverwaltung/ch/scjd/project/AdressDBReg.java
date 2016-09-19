package ch.scjd.project;

import java.rmi.Naming;

public class AdressDBReg
{

	public static void main(String[] args)
	{
		registrieren("AdressDB");
		System.out.println("AdressDBReg beendet ...");
	}


	public static void registrieren(String name)
	{
		try
		{
			AdressDBImpl adb = new AdressDBImpl("adressen.dat");
			System.out.println("AdressDBImpl erstellt ...");
			Naming.rebind(name, adb);
			System.out.println(name + " registriert");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
