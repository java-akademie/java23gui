package ch.jkurs.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Rechner2Frame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public Rechner2Frame()
	{
		super("Rechner2");

		this.add(new Rechner2Panel());

		this.pack();


		this.setLocation(400, 500);

		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{

				System.exit(0);
			}
		});
	}
}
