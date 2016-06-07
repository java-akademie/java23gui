package ch.jmildner.gui.klickmich;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class KlickMich3Frame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new KlickMich3Frame();
	}


	public KlickMich3Frame()
	{
		super("KlickMich");
		this.add(new KlickMich3Panel());

		this.setLocation(200, 100);
		this.pack();
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
