package ch.jmildner.rsa;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class QuitAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	RsaPanel myPanel;


	public QuitAction(final RsaPanel thePanel)
	{
		super("Quit");
		putValue(SHORT_DESCRIPTION, "Quit the Program");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_U));

		myPanel = thePanel;
	}


	// @Override
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
