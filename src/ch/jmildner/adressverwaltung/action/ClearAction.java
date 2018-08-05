package ch.jmildner.adressverwaltung.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import ch.jmildner.adressverwaltung.ui.AdressverwaltungPanel;

public class ClearAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	private AdressverwaltungPanel panel;


	public ClearAction(final AdressverwaltungPanel panel)
	{
		super("Clear");

		this.putValue(SHORT_DESCRIPTION, "clear all");
		this.putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_L));
		this.setEnabled(false);

		this.panel = panel;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		panel.getTfId().setText("");
		panel.getTfName().setText("");
		panel.getTfAddr().setText("");
		panel.getTaProtokoll().setText("");
		this.setEnabled(false);
	}

}
