package ch.jmildner.gui.personenverwaltung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class PersonenverwaltungPanel extends MyPanel
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
		this.addEmptyRow(8, ' ', 10, 10);
		addCaptionCenter("Personenverwaltung", 10, 1, 10);

		addLabelRight("ID:", 30, 1, 2);
		add(tfId, 30, 3, 2);

		addLabelRight("Name:", 40, 1, 2);
		add(tfName, 40, 3, 8);

		addLabelRight("Addr:", 50, 1, 2);
		add(tfAddr, 50, 3, 8);

		add(btErfassen, 70, 1, 2);
		add(btAnzeigen, 70, 3, 2);
		add(btSortieren, 70, 5, 2);
		add(btLoeschen, 70, 7, 2);
		add(btAbspeichern, 70, 9, 2);

		addTextArea(taErgebnis, 80, 1, 10, 1);

		add(clear, 100, 7, 2);
		add(quit, 100, 9, 2);

	}
}
