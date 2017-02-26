package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class CreateTableAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	private TemplateFrame frame;


	public CreateTableAction(final TemplateFrame frame)
	{
		super("CreateTable");
		putValue(SHORT_DESCRIPTION, "create Table");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_T));

		this.setEnabled(false);

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("CreateTable gedrueckt");
		DbTool db = DbTool.getInstance();

		StringBuilder prot = new StringBuilder();

		try
		{
			prot.append(db.createAddress());
		}
		catch (Exception e)
		{
			prot.append(e.toString() + "\n");
		}
		finally
		{
			// Tabelle besteht bereits
			setEnabled(false);

			frame.getMiOpenDb().getAction().setEnabled(false);
			frame.getMiCloseDb().getAction().setEnabled(true);
					frame.getMiCreateAdressen().getAction().setEnabled(false);
			frame.getMiDropAdressen().getAction().setEnabled(true);
			frame.getMiInsertAdressen().getAction().setEnabled(true);
		}
		
		System.out.println(prot);
	}
}
