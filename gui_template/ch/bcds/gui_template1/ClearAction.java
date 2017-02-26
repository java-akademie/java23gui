package ch.bcds.gui_template1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class ClearAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;


	TemplateFrame frame;


	public ClearAction(final TemplateFrame frame)
	{
		super("Clear");
		this.putValue(SHORT_DESCRIPTION, "Clear the Frame");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_R));

		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Clear gedrueckt");

		if (frame.getContentPanel() != null)
		{
			System.out.println("contentPanel wird removed");
			frame.remove(frame.getContentPanel());
			frame.setContentPanel(null);
			frame.repaint();
		}
		else
			System.out.println("contentPanel is  null");

	}


}
