package ch.jmildner.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.adressverwaltung.dbtool.DbTool;
import ch.jmildner.adressverwaltung.ui.AdressverwaltungPanel;

public class OpenDBAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	private AdressverwaltungPanel panel;


	public OpenDBAction(final AdressverwaltungPanel panel)
	{
		super("openDB");
		this.putValue(SHORT_DESCRIPTION, "open the Database");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_O));
		this.setEnabled(true);

		this.panel = panel;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		DbTool db = DbTool.getInstance();
		StringBuilder prot = new StringBuilder();
		try
		{
			prot.append(db.openDB());
			setEnabled(false);
			panel.getBtCloseDB().getAction().setEnabled(true);
		}
		catch (Exception x)
		{
			prot.append("Fehler bei setEnable BtClose ...  "
					+ x.toString() + "\n");
		}

		panel.getTaProtokoll().append(prot.toString());
	}

}
