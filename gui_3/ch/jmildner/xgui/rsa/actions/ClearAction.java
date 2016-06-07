package ch.jmildner.xgui.rsa.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.UIManager;

import ch.jmildner.xgui.rsa.ui.RsaPanel;

public class ClearAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	RsaPanel myPanel;


	public ClearAction(final RsaPanel thePanel)
	{
		super("Clear", UIManager.getIcon("OptionPane.errorIcon"));
		putValue(SHORT_DESCRIPTION, "Clear all fields");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_C));

		myPanel = thePanel;
	}


	// @Override
	@Override
	public void actionPerformed(ActionEvent e)
	{
		myPanel.clear2();
		setEnabled(false);
		myPanel.getBtnTryIt().getAction().setEnabled(false);
	}
}
