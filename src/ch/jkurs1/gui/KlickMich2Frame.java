package ch.jkurs1.gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KlickMich2Frame extends Frame
{
	private static final long serialVersionUID = 1L;

	private _Layout layout;


	public KlickMich2Frame(_Layout layout)
	{
		super("KlickMich2 " + layout);

		this.layout = layout;

		add(new KlickMich2Panel(layout));

		anzeigen();
	}


	private void anzeigen()
	{
		setLocation(400 * (1+layout.getOrdinal()), 300 * (1+layout.getOrdinal()));
		pack();
		setVisible(true);

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
