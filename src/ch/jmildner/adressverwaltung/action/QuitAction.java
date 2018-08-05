package ch.jmildner.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.adressverwaltung.dbtool.DbTool;
import ch.jmildner.adressverwaltung.ui.AdressverwaltungPanel;

public class QuitAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;

	DbTool dbTools = DbTool.getInstance();

	AdressverwaltungPanel panel;


	public QuitAction(final AdressverwaltungPanel panel)
	{
		super("Quit");
		this.putValue(SHORT_DESCRIPTION, "quit");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));

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
