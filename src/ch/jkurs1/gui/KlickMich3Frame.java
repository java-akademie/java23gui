package ch.jkurs1.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class KlickMich3Frame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private _Layout layout;
	private static int zaehler;


	public KlickMich3Frame(_Layout layout)
	{
		super("KlickMich3 " + layout);

		this.layout = layout;

		this.add(new KlickMich2Panel(layout));
		KlickMich3Frame.zaehler++;

		this.anzeigen();
	}


	private void anzeigen()
	{
		setLocation(300 * (1 + layout.getOrdinal()), 200 * (1 + layout.getOrdinal()));
		pack();
		setVisible(true);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				removeAll();
				zaehler--;
				if (zaehler == 0)
					System.exit(0);
			}
		});
	}
}
