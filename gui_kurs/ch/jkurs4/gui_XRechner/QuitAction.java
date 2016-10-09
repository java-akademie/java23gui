package ch.jkurs4.gui_XRechner;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class QuitAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	XRechnerPanel panel;


	public QuitAction(final XRechnerPanel panel)
	{
		super("QUIT");
		putValue(SHORT_DESCRIPTION, "Quit the Program");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));

		this.panel = panel;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
