package ch.jmildner.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.adressverwaltung.dbtool.DbTool;
import ch.jmildner.adressverwaltung.ui.AdressverwaltungPanel;

public class CloseDBAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	private AdressverwaltungPanel panel;


	public CloseDBAction(final AdressverwaltungPanel panel)
	{
		super("closeDB");
		this.putValue(SHORT_DESCRIPTION, "close the Database");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
		this.setEnabled(false);

		this.panel = panel;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		DbTool db = DbTool.getInstance();
		String prot;
		try
		{
			prot = db.closeDB();
			setEnabled(false);
			panel.getBtOpenDB().getAction().setEnabled(true);
		}
		catch (Exception x)
		{
			prot = x.getMessage() + "\n";
		}

		panel.getTaProtokoll().append(prot);
	}
}
