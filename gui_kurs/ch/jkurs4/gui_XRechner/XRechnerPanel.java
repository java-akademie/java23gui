package ch.jkurs4.gui_XRechner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.jmb.tools.MyPanel;

public class XRechnerPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JButton btnAdd = new JButton("_add");
	private JButton btnSub = new JButton("_sub");
	private JButton btnMult = new JButton("_mult");
	private JButton btnDiv = new JButton("_div");

	private JButton btnClear = new JButton("_clear");
	private JButton btnQuit = new JButton("_quit");

	private JTextField wert1 = new JTextField("", 15);
	private JTextField wert2 = new JTextField("", 15);
	private JTextField ergebnis = new JTextField("", 15);

	XRechnerFrame frame;


	public XRechnerPanel(XRechnerFrame frame)
	{
		this.frame = frame;

		boolean testZeile = false;

		MyPanel mp = new MyPanel(5, 8, testZeile);

		int zeile = testZeile ? 1 : 0;

		// zeile 1
		zeile++;
		mp.addCaptionCenter("XRECHNER", zeile, 1, 5);

		// zeile 2
		zeile++;
		mp.addLabel("Wert 1: ", zeile, 1, 1);
		mp.add(wert1, zeile, 2, 4);

		// zeile 3
		zeile++;
		mp.addLabel("Wert 2: ", zeile, 1, 1);
		mp.add(wert2, zeile, 2, 4);

		// zeile 4
		zeile++;
		mp.add(btnAdd, zeile, 2, 1);
		mp.add(btnSub, zeile, 3, 1);
		mp.add(btnMult, zeile, 4, 1);
		mp.add(btnDiv, zeile, 5, 1);

		// zeile 5
		zeile++;
		mp.addLabel("Ergibt: ", zeile, 1, 1);
		mp.add(ergebnis, zeile, 2, 4);
		ergebnis.setEditable(false);

		// zeile 6
		zeile++;
		mp.add(btnClear, zeile, 4, 1);
		mp.add(btnQuit, zeile, 5, 1);

		this.add(mp);
	}


	protected void clear()
	{
		wert1.setText("");
		wert2.setText("");
		ergebnis.setText("");
	}



	protected void quit()
	{
		System.out.println("eventuell Aufraeumarbeiten !!!");
		frame.dispose();
	}


	protected void add()
	{
		double[] werte = werteFuellen();

		if (werte == null)
		{
			ergebnis.setText("mindestens ein Wert ist kein Double");
			return;
		}

		double w1 = werte[0];
		double w2 = werte[1];

		double erg = w1 + w2;
		ergebnis.setText(erg + "");
	}


	protected void sub()
	{
		double[] werte = werteFuellen();

		if (werte == null)
		{
			ergebnis.setText("mindestens ein Wert ist kein Double");
			return;
		}

		double w1 = werte[0];
		double w2 = werte[1];

		double erg = w1 - w2;
		ergebnis.setText(erg + "");
	}


	protected void mult()
	{
		double[] werte = werteFuellen();

		if (werte == null)
		{
			ergebnis.setText("mindestens ein Wert ist kein Double");
			return;
		}

		double w1 = werte[0];
		double w2 = werte[1];

		double erg = w1 * w2;
		ergebnis.setText(erg + "");
	}


	protected void div()
	{
		double[] werte = werteFuellen();

		if (werte == null)
		{
			ergebnis.setText("mindestens ein Wert ist kein Double");
			return;
		}

		double w1 = werte[0];
		double w2 = werte[1];

		double erg = w1 / w2;
		ergebnis.setText(erg + "");
	}


	//
	// getter und setter
	//

	private double[] werteFuellen()
	{
		double[] werte = { 0, 0 };
		try
		{
			werte[0] = Double.parseDouble(wert1.getText());
			werte[1] = Double.parseDouble(wert2.getText());
		}
		catch (Exception e)
		{
			werte = null;
		}
		return werte;
	}


	protected JButton getBtnAdd()
	{
		return btnAdd;
	}


	protected JButton getBtnClear()
	{
		return btnClear;
	}


	protected JButton getBtnDiv()
	{
		return btnDiv;
	}


	protected JButton getBtnQuit()
	{
		return btnQuit;
	}


	protected JButton getBtnMult()
	{
		return btnMult;
	}


	protected JButton getBtnSub()
	{
		return btnSub;
	}


	protected JTextField getErgebnis()
	{
		return ergebnis;
	}


	protected JTextField getWert1()
	{
		return wert1;
	}


	protected JTextField getWert2()
	{
		return wert2;
	}
}
