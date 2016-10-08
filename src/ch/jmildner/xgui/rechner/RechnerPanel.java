package ch.jmildner.xgui.rechner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class RechnerPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JButton btnAdd = new JButton("+");
	private JButton btnSub = new JButton("-");
	private JButton btnMult = new JButton("*");
	private JButton btnDiv = new JButton("/");
	private JButton btnClear = new JButton("clear");
	private JButton btnEnd = new JButton("ende");
	private JTextField wert1 = new JTextField("", 15);
	private JTextField wert2 = new JTextField("", 15);
	private JTextField ergebnis = new JTextField("", 15);


	public RechnerPanel()
	{
		MyPanel mp = new MyPanel(6, 8, false);

		mp.addCaptionCenter("Rechner", 1, 1, 6);

		mp.addLabel("Wert 1: ", 10, 1, 1);
		mp.add(wert1, 10, 2, 4);
		mp.addLabel("Wert 2: ", 20, 1, 1);
		mp.add(wert2, 20, 2, 4);
		mp.add(btnAdd, 30, 2, 1);
		mp.add(btnSub, 30, 3, 1);
		mp.add(btnMult, 30, 4, 1);
		mp.add(btnDiv, 30, 5, 1);
		mp.addLabel("Ergibt: ", 40, 1, 1);
		mp.add(ergebnis, 40, 2, 4);
		ergebnis.setEditable(false);
		mp.add(btnClear, 50, 4, 1);
		mp.add(btnEnd, 50, 5, 1);

		this.add(mp);
	}


	public void clear()
	{
		wert1.setText("");
		wert2.setText("");
		ergebnis.setText("");
	}


	public JButton getBtnAdd()
	{
		return btnAdd;
	}


	public JButton getBtnClear()
	{
		return btnClear;
	}


	public JButton getBtnDiv()
	{
		return btnDiv;
	}


	public JButton getBtnEnd()
	{
		return btnEnd;
	}


	public JButton getBtnMult()
	{
		return btnMult;
	}


	public JButton getBtnSub()
	{
		return btnSub;
	}


	public JTextField getErgebnis()
	{
		return ergebnis;
	}


	public JTextField getWert1()
	{
		return wert1;
	}


	public JTextField getWert2()
	{
		return wert2;
	}

}
