package ch.jmildner.gui.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class DialogFrame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public static void main(String[] args)
	{
		new DialogFrame();
	}


	public DialogFrame()
	{
		super("Dialog");

		final DialogPanel dp = new DialogPanel();

		this.add(dp);

		this.setLocation(200, 100);
		this.pack();
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				dp.ende();
				dispose();
			}
		});
	}
}
