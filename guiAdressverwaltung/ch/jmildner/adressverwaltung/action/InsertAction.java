package ch.jmildner.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.adressverwaltung.dbtool.DbTool;
import ch.jmildner.adressverwaltung.ui.AdressverwaltungPanel;

public class InsertAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;

	DbTool dbTool = DbTool.getInstance();

	AdressverwaltungPanel panel;


	public InsertAction(final AdressverwaltungPanel panel)
	{
		super("Insert");
		putValue(SHORT_DESCRIPTION, "insert Address");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_I));

		this.panel = panel;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		String prot;

		int id = 0;
		String name = "";
		String addr = "";

		try
		{
			id = Integer.parseInt(panel.getTfId().getText());
		}
		catch (Exception x)
		{
			prot = x.toString();
			panel.getTaProtokoll().append(prot);
			return;
		}
		name = panel.getTfName().getText();
		addr = panel.getTfAddr().getText();

		if (id <= 0 || name.equals("") || addr.equals(""))
		{
			panel.getTaProtokoll().append(
					"id,name,addr muss gefuellt sein");
			return;
		}

		DbTool db = DbTool.getInstance();

		try
		{
			prot = db.insertAddress(id, name, addr) + "\n";
		}
		catch (Exception x)
		{
			prot = x.getMessage() + "\n";
		}
		panel.getTaProtokoll().append(prot);

	}

}
