package ch.jkurs1.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Rechner1Frame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public Rechner1Frame()
	{
		super("Rechner1");

		this.add(new Rechner1Panel());

		this.pack();

		this.setLocation(100, 200);

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

