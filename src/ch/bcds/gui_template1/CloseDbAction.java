package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;


public class CloseDbAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	private TemplateFrame frame;


	public CloseDbAction(final TemplateFrame frame)
	{
		super("CloseDB");
		this.putValue(SHORT_DESCRIPTION, "close the Database");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
	
		this.setEnabled(false);

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("DbClose gedrueckt");

		DbTool db = DbTool.getInstance();

		StringBuilder prot = new StringBuilder();

		try
		{
			prot.append(db.closeDB());

			setEnabled(false);

			frame.getMiOpenDb().getAction().setEnabled(true);

			frame.getMiOpenDb().getAction().setEnabled(true);
			frame.getMiCloseDb().getAction().setEnabled(false);
			frame.getMiCreateAdressen().getAction().setEnabled(false);
			frame.getMiDropAdressen().getAction().setEnabled(false);
			frame.getMiInsertAdressen().getAction().setEnabled(false);

		}
		catch (Exception e)
		{
			prot.append(e.toString() + "\n");
		}
		
		System.out.println(prot);
		// panel.getTaProtokoll().append(prot);
	}
}
