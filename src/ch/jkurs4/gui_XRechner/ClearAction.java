package ch.jkurs4.gui_XRechner;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class ClearAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	XRechnerPanel panel;


	public ClearAction(final XRechnerPanel panel)
	{
		super("CLEAR");
		putValue(SHORT_DESCRIPTION, "Clear all Fields");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_C));

		this.panel = panel;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		panel.clear();
		setEnabled(false);
		panel.getBtnAdd().getAction().setEnabled(false);
		panel.getBtnSub().getAction().setEnabled(false);
		panel.getBtnMult().getAction().setEnabled(false);
		panel.getBtnDiv().getAction().setEnabled(false);
	}
}
