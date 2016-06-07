package ch.jmildner.gui.klickmich;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KlickMich2Frame extends Frame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new KlickMich2Frame();
	}


	public KlickMich2Frame()
	{
		super("KlickMich2");
		add(new KlickMich2Panel());

		setLocation(200, 100);
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
