package ch.jmildner.xgui.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.xgui.adressverwaltung.dbtool.DbTool;
import ch.jmildner.xgui.adressverwaltung.ui.AdressverwaltungPanel;

public class DropTableAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;

	DbTool dbTool = DbTool.getInstance();

	AdressverwaltungPanel panel;


	public DropTableAction(final AdressverwaltungPanel panel)
	{
		super("DropTable");
		putValue(SHORT_DESCRIPTION, "create Table");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_D));
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
			prot = db.dropAddress();
		}
		catch (Exception x)
		{
			prot = x.getMessage() + "\n";
		}
		panel.getTaProtokoll().append(prot);
	}


}
