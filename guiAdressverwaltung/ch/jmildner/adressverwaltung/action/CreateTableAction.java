package ch.jmildner.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.adressverwaltung.dbtool.DbTool;
import ch.jmildner.adressverwaltung.ui.AdressverwaltungPanel;

public class CreateTableAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	DbTool dbTool = DbTool.getInstance();

	AdressverwaltungPanel panel;


	public CreateTableAction(final AdressverwaltungPanel panel)
	{
		super("CreateTable");
		putValue(SHORT_DESCRIPTION, "create Table");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_T));

		this.panel = panel;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		DbTool db = DbTool.getInstance();

		String prot;

		try
		{
			prot = db.createAddress();
		}
		catch (Exception x)
		{
			prot = x.getMessage() + "\n";
		}

		panel.getTaProtokoll().append(prot);
	}
}
