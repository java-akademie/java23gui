package ch.jmildner.xgui.rsa.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigInteger;

import javax.swing.AbstractAction;

import ch.jmildner.xgui.rsa.ui.RsaPanel;

public class TryItAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	RsaPanel myPanel;


	BigInteger p, q, n, e, o, d, t, v, x;


	public TryItAction(final RsaPanel thePanel)
	{
		super("TryIt");
		putValue(SHORT_DESCRIPTION, "Try It");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_T));

		myPanel = thePanel;
	}


	// @Override
	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.tryIt();
		setEnabled(false);
		myPanel.getBtnTryIt().getAction().setEnabled(false);
	}


	private void makeD(BigInteger e, BigInteger o)
	{
		// d muss in folgende Gleichung passen
		// ((e*d)%o)==1

		d = BigInteger.ZERO;

		while (true)
		{
			d = d.add(BigInteger.ONE);

			BigInteger ed = e.multiply(d);
			BigInteger edmo = XHelper.mod(ed, o);

			if (edmo.equals(BigInteger.ONE))
			{
				return;
			}
		}
	}


	private void makeN()
	{
		// n = p * q
		n = p.multiply(q);
	}


	private void makeO()
	{
		// o = (p-1)*(q-1)

		BigInteger pMinusEins = p.subtract(BigInteger.ONE);
		BigInteger qMinusEins = q.subtract(BigInteger.ONE);

		o = pMinusEins.multiply(qMinusEins);
	}


	private void tryIt()
	{
		p = new BigInteger(myPanel.getTfP().getText());
		q = new BigInteger(myPanel.getTfQ().getText());
		e = new BigInteger(myPanel.getTfE().getText());

		makeN();
		myPanel.getTfN().setText(n + "");

		makeO();
		myPanel.getTfO().setText(o + "");

		makeD(e, o);

		myPanel.getTfD().setText(d + "");

		t = new BigInteger(myPanel.getTfT().getText());
		v = XHelper.verschluesseln(t, e, n);
		myPanel.getTfV().setText(v + "");
		x = XHelper.entschluesseln(v, d, n);
		myPanel.getTfX().setText(x + "");

		if (myPanel.getTfT().getText()
				.equals(myPanel.getTfX().getText()))
		{
			myPanel.getTa().append("DECODE/ENCODE OK\n");
		}
		else
		{
			myPanel.getTa().append(
					"DECODE/ENCODE NOT OK !!!!!!!!!!!!!!!\n");
		}
	}
}
