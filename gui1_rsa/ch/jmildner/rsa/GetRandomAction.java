package ch.jmildner.rsa;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class GetRandomAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	RsaPanel myPanel;


	public GetRandomAction(final RsaPanel thePanel)
	{
		super("GetRandom");
		putValue(SHORT_DESCRIPTION, "Get Random");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_R));

		myPanel = thePanel;
	}


	// @Override
	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.getRandom();
	}


	private void getRandom()
	{
		myPanel.clear1();

		// p und q: muessen Pimzahlen sein
		// e: e muss eine Primzahl sein und zusaetzlich groesser p und q
		// t: der zu verschluesselnde wert muss kleiner p*q sein

		long p, q, e, t;

		while (true)
		{
			p = XHelper.getRandomPrime(20, 200);
			q = XHelper.getRandomPrime(20, 200);

			long m = Math.max(p, q) + 1;
			long n = m + 1000;

			e = XHelper.getRandomPrime(m, n);

			if (p == e || q == e || p == q)
			{
				System.out.print(".");
			}
			else
				break;
		}

		t = XHelper.getRandom(1, (int) (p * q - 1));

		System.out.printf("p=%d, q=%d, e=%d, t=%d \n", p, q, e, t);

		myPanel.getTfP().setText("" + p);
		myPanel.getTfQ().setText("" + q);
		myPanel.getTfE().setText("" + e);
		myPanel.getTfT().setText("" + t);
	}
}
