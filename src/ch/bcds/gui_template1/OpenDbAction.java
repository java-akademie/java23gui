package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class OpenDbAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	private TemplateFrame frame;


	public OpenDbAction(final TemplateFrame frame)
	{
		super("OpenDB");
		this.putValue(SHORT_DESCRIPTION, "open the Database");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_O));

		this.setEnabled(true);

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("DbOpen gedrueckt");

		DbTool db = DbTool.getInstance();

		StringBuilder prot = new StringBuilder();

		try
		{

			prot.append(db.openDB());

			setEnabled(false);

			frame.getMiOpenDb().getAction().setEnabled(false);
			frame.getMiCloseDb().getAction().setEnabled(true);
			frame.getMiCreateAdressen().getAction().setEnabled(true);
			frame.getMiDropAdressen().getAction().setEnabled(true);
			frame.getMiInsertAdressen().getAction().setEnabled(true);
		}
		catch (Exception e)
		{
			prot.append(e.toString() + "\n");
		}

		System.out.println(prot);
		// panel.getTaProtokoll().append(prot.toString());
	}

}
