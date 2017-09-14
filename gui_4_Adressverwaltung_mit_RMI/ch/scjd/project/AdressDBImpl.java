package ch.scjd.project;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import ch.jmb.tools.TextFile;

public class AdressDBImpl extends UnicastRemoteObject implements
		AdressDB
{
	private static final long serialVersionUID = 1L;

	private String fileName;

	private Adresse[] adressen = new Adresse[1000];

	private int anzahlAdressen = 0;


	public AdressDBImpl(String fileName) throws RemoteException
	{
		this.fileName = fileName;
		this.adressenEinlesen();
	}


	@Override
	public String adressenAbspeichern()
	{
		if (anzahlAdressen == 0)
		{
			return "keine Adressen zum speichern vorhanden!";
		}

		TextFile tf = null;
		;
		try
		{
			tf = new TextFile(fileName, 'o');
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		for (int i = 0; i < anzahlAdressen; i++)
		{
			tf.printLine(adressen[i].toString());
		}

		tf.close();

		System.out.println(anzahlAdressen + " Adressen abgespeichert!");

		int zw = anzahlAdressen;
		anzahlAdressen = 0;
		return zw + " Adressen in Datei geschrieben!";
	}


	@Override
	public String adressenAnzeigen()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("\nListe der Mitarbeiter");
		sb.append("\n--------------------------------------");
		for (int i = 0; i < anzahlAdressen; i++)
		{
			sb.append("\n" + adressen[i]);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}


	@Override
	public String adressenEinlesen()
	{
		if (anzahlAdressen != 0)
		{
			return anzahlAdressen + " Adressen schon vorhanden";
		}

		System.out.println("open ... ");

		TextFile tf = null;

		try
		{

			tf = new TextFile(fileName, 'i');
		}
		catch (FileNotFoundException e)
		{
			System.out.println("adressen.dat nicht vorhanden");
			return "open nok ... adressen.dat nicht vorhanden";
		}

		String buff = tf.readLine();

		while (buff != null)
		{
			adressen[anzahlAdressen++] = new Adresse(buff);
			buff = tf.readLine();

		}

		tf.close();

		System.out.println(anzahlAdressen + " Adressen eingelesen!");

		return anzahlAdressen + " Adressen eingelesen!";
	}


	@Override
	public String adressenSortieren()
	{
		for (int i = 0; i < anzahlAdressen - 1; i++)
		{
			for (int j = i; j < anzahlAdressen; j++)
			{
				if (adressen[i].id > adressen[j].id)
				{
					int zwId = adressen[i].id;
					String zwName = adressen[i].name;
					String zwAddr = adressen[i].addr;
					adressen[i].id = adressen[j].id;
					adressen[i].name = adressen[j].name;
					adressen[i].addr = adressen[j].addr;
					adressen[j].id = zwId;
					adressen[j].name = zwName;
					adressen[j].addr = zwAddr;
				}
			}
		}

		return "Adressen sortiert";
	}


	@Override
	public Vector<String> fuellenColHeader()
	{
		Vector<String> colHeader = new Vector<String>();
		colHeader.add("id");
		colHeader.add("name");
		colHeader.add("addr");
		return colHeader;
	}


	@Override
	public Vector<Vector<String>> fuellenData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> zeile;

		for (int i = 0; i < anzahlAdressen; i++)
		{
			adressen[i].show();
			zeile = new Vector<String>();
			zeile.add(adressen[i].getID() + "");
			zeile.add(adressen[i].getName());
			zeile.add(adressen[i].getAddr());
			data.add(zeile);
		}

		return data;
	}


	@Override
	public Adresse getAdresse(int i)
	{
		return adressen[i];
	}


	@Override
	public int getAnzahlAdressen()
	{
		return anzahlAdressen;
	}


	@Override
	public String makeTestdata()
	{
		adressen[anzahlAdressen++] = new Adresse("meierxxx", "baselx");
		adressen[anzahlAdressen++] = new Adresse("muellerx", "genfxx");
		adressen[anzahlAdressen++] = new Adresse("gruberxx", "luzern");

		return "3 Adressen erstellt";
	}

}
