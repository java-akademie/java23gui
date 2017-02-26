package ch.jkurs1.gui;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KlickMich3Frame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private _Layout layout;
	private static int zaehler;


	public KlickMich3Frame(_Layout layout)
	{
		super("KlickMich3 " + layout);

		this.layout = layout;
			setLayout(new GridLayout(3, 1));

		this.add(new KlickMich3Panel(this,layout));
		this.add(new JLabel("xxx"));
		this.add(new JLabel("zzz"));
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
