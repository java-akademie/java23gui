package ch.jkurs2.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class PersonenverwaltungPanel extends JPanel
{
	PersonenArray pa = new PersonenArray("adressen.txt");


	private static final long serialVersionUID = 1L;

	JTextField tfId = new JTextField("", 10);
	JTextField tfName = new JTextField("", 20);
	JTextField tfAddr = new JTextField("", 20);

	JTextArea taErgebnis = new JTextArea("", 20, 10);

	JButton btErfassen = new JButton("ERFASSEN");
	JButton btAnzeigen = new JButton("ANZEIGEN");
	JButton btSortieren = new JButton("SORTIEREN");
	JButton btLoeschen = new JButton("LOESCHEN");
	JButton btAbspeichern = new JButton("ABSPEICHERN");

	JButton clear = new JButton("CLEAR");
	JButton quit = new JButton("QUIT");


	public PersonenverwaltungPanel()
	{
		pa.einlesen();
		makeTheLayout();
		addTheListener();
	}


	protected void addTheListener()
	{
		quit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(1);
			}
		});

		clear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				tfId.setText("");
				tfName.setText("");
				tfAddr.setText("");
				taErgebnis.setText("");
			}
		});

		btLoeschen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				taErgebnis.append(pa.loeschen(tfId.getText()));
				taErgebnis.append(pa.anzeigen());
			}
		});

		btErfassen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				taErgebnis.append(pa.erfassen(tfId.getText(), tfName.getText(), tfAddr.getText()));
			}
		});

		btAnzeigen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				taErgebnis.append(pa.anzeigen());
			}
		});

		btSortieren.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				taErgebnis.append(pa.sortieren());
			}
		});

		btAbspeichern.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				taErgebnis.append(pa.abspeichern());
			}
		});

	}


	protected void makeTheLayout()
	{
		boolean test = true;

		MyPanel mp = new MyPanel(10, 10, test);

		int zeile = test ? 1 : 0;
		
		// zeile 1
		zeile++;
		mp.addCaptionCenter("Personenverwaltung", zeile, 1, 10);

		// zeile 2
		zeile++;
		mp.addLabelRight("ID:", zeile, 1, 2);
		mp.add(tfId, zeile, 3, 2);

		// zeile 1
		zeile++;
	mp.addLabelRight("Name:", zeile, 1, 2);
		mp.add(tfName, zeile, 3, 8);

		// zeile 1
		zeile++;
		mp.addLabelRight("Addr:", zeile, 1, 2);
		mp.add(tfAddr, zeile, 3, 8);

		// zeile 1
		zeile++;
		mp.add(btErfassen, zeile, 1, 2);
		mp.add(btAnzeigen, zeile, 3, 2);
		mp.add(btSortieren, zeile, 5, 2);
		mp.add(btLoeschen, zeile, 7, 2);
		mp.add(btAbspeichern, zeile, 9, 2);

		// zeile 1
		zeile++;
		mp.addTextArea(taErgebnis, zeile, 1, 10, 1);

		// zeile 1
		zeile++;
		mp.add(clear, zeile, 7, 2);
		mp.add(quit, zeile, 9, 2);

		this.add(mp);
	}
}
