package ch.jkurs2.gui_person_File;

import java.io.FileNotFoundException;

import ch.java_akademie.tools.MyTools;
import ch.java_akademie.tools.TextFile;

public class PersonenArray
{
	private String fileName;
	private Person[] person = new Person[1000];
	private int anzahlPersonen = 0;


	public PersonenArray(String fileName)
	{
		this.fileName = fileName;
	}


	public String abspeichern()
	{
		TextFile outFile = null;

		try
		{
			outFile = new TextFile(fileName, 'o');
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		sortieren();

		for (int i = 0; i < anzahlPersonen; i++)
		{
			outFile.printLine(person[i].toString());
		}

		outFile.close();

		System.out.println("Adressarray wurde in die Datei '" + fileName + "' geschrieben");
		return ("Adressarray wurde in die Datei '" + fileName + "' geschrieben\n");
	}


	public String anzeigen()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n    AnzahlPersonen: " + anzahlPersonen + "\n\n");

		System.out.println();
		System.out.println("     Anzahl Personen: " + anzahlPersonen);
		System.out.println();

		for (int i = 0; i < anzahlPersonen; i++)
		{
			person[i].show();
			sb.append(person[i].show());
		}

		System.out.println("");
		sb.append("\n");

		return sb.toString();
	}


	public void einlesen()
	{
		TextFile inFile = null;

		try
		{
			inFile = new TextFile(fileName, 'i');
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Adressdaten noch nicht vorhanden");
			return;
		}

		String s;

		anzahlPersonen = 0;

		while ((s = inFile.readLine()) != null)
		{
			person[anzahlPersonen++] = new Person(s);
		}

		inFile.close();

		System.out.println("Adressarray wurde aus der Datei '" + fileName + "' gefuellt");

	}


	public void erfassen()
	{
		System.out.println("");

		Person p = new Person();

		if (vorhanden(p))
		{
			System.out.println("Person schon vorhanden ...");
		}
		else
		{
			person[anzahlPersonen++] = p;
		}
	}



	public String erfassen(String id, String name, String addr)
	{
		StringBuilder sb = new StringBuilder();

		System.out.println("");
		sb.append("\n");

		id = intSollGefuelltSein(id);
		name = stringSollGefuelltSein(name);
		addr = stringSollGefuelltSein(addr);

		Person p = new Person(Integer.parseInt(id), name, addr);

		if (vorhanden(p))
		{
			System.out.println("Person schon vorhanden ...");
			sb.append("Person schon vorhanden ... \n");
		}
		else
		{
			person[anzahlPersonen++] = p;

			System.out.println("Person eingefuegt\n");
			sb.append("Person eingefuegt \n");
		}

		return sb.toString();
	}


	private String stringSollGefuelltSein(String string)
	{
		if (string == null || string.trim().equals(""))
			return "x";
		else
			return string;

	}


	private String intSollGefuelltSein(String id)
	{
		if (id == null)
			return MyTools.getRandom() + "";

		try
		{
			Integer.parseInt(id);
			return id;
		}
		catch (Exception e)
		{
			return MyTools.getRandom() + "";
		}

	}


	public String loeschen()
	{
		if (anzahlPersonen == 0)
		{
			System.out.println("keine Personen gespeichert ...");
			;
			return ("keine Personen gespeichert ...");
		}

		int zwId = MyTools.getInteger("     ID   > ");

		return loeschen(zwId + "");
	}


	public String loeschen(String zwId)
	{
		if (zwId.equals("*"))
			anzahlPersonen = 0;
		
		if (anzahlPersonen == 0)
		{
			System.out.println("keine Personen gespeichert ...");
			;
			return ("keine Personen gespeichert ...");
		}

		// ID suchen
		int i;
		for (i = 0; i < anzahlPersonen; i++)
		{
			if (Integer.parseInt(zwId) == person[i].getId())
			{
				break;
			}
		}

		if (i == anzahlPersonen)
		{
			System.out.println("ID nicht vorhanden ...");
			return ("ID nicht vorhanden ...");
		}

		person[i] = person[--anzahlPersonen];
		sortieren();

		System.out.println("Adresse wurde aus Array entfernt");
		return ("Adresse wurde aus Array entfernt");

	}


	public String sortieren()
	{
		for (int i = 0; i < anzahlPersonen - 1; i++)
		{
			for (int j = i + 1; j < anzahlPersonen; j++)
			{
				if (person[i].getId() > person[j].getId())
				{
					Person zw = new Person(person[i].toString());
					person[i] = new Person(person[j].toString());
					person[j] = new Person(zw.toString());
				}
			}
		}

		System.out.println("");
		System.out.println("Personen sortiert!");
		System.out.println("");

		return "Personen sortiert";
	}


	private boolean vorhanden(Person p)
	{
		for (int i = 0; i < anzahlPersonen; i++)
		{
			if (p.getId() == person[i].getId())
			{
				return true;
			}
		}

		return false;
	}
}
