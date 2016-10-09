package ch.jkurs4.gui_XRechner;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class SubAction extends AbstractAction
	{
		private static final long serialVersionUID = 1L;

		XRechnerPanel panel;


		public SubAction(final XRechnerPanel panel)
		{
			super("-");
			putValue(SHORT_DESCRIPTION, "Add the fields");
			putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_S));

			this.panel = panel;
		}


		@Override
		public void actionPerformed(ActionEvent e)
		{
			panel.sub();
		}
	}
