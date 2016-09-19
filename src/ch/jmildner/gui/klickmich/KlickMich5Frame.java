package ch.jmildner.gui.klickmich;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class KlickMich5Frame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new KlickMich5Frame();
	}


	public KlickMich5Frame()
	{
		super("KlickMich5");
		add(new KlickMich5Panel());

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
