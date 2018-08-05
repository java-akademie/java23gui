package ch.bcds.gui_template2;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class ExitAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;


	EjbTestPanel panel;


	public ExitAction(final EjbTestPanel panel)
	{
		super("EXIT");
		this.putValue(SHORT_DESCRIPTION, "End of Program");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_X));
		this.setEnabled(true);
		this.panel = panel;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e == null)
			System.out.println("ende mit 'x'");
		else
			System.out.println("ende mit 'Quit'");

		System.exit(0);
	}

}
