package ch.jmildner.rsa;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;


public class RandomAndTryAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	GetRandomAction myGetRandomAction;
	TryItAction tryItAction;


	public RandomAndTryAction(final GetRandomAction theGetRandomAction,
			final TryItAction theTryItAction)
	{
		super("R and T");
		putValue(SHORT_DESCRIPTION, "GetRandom and TryIt");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_A));

		myGetRandomAction = theGetRandomAction;
		tryItAction = theTryItAction;
	}


	// @Override
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("getRandom and tryIt");
		myGetRandomAction.actionPerformed(e);
		tryItAction.actionPerformed(e);
	}
}
