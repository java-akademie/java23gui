package ch.jmildner.gui.klickmich;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlickMich extends Frame implements ActionListener
{
	private static final long serialVersionUID = 4771671414455219066L;


	public static void main(String[] args)
	{
		new KlickMich();
		System.out.println("ende klickmich");
	}

	private Button b1 = new Button("KlickMich");
	private Button b2 = new Button("nein mich");

	private TextField tf1 = new TextField("", 30);
	private TextField tf2 = new TextField("", 30);


	public KlickMich()
	{
		makeTheLayout();
		addTheListener();
		anzeigen();
	}


	private void addTheListener()
	{
		b1.addActionListener(this);
	}


	private void anzeigen()
	{
		this.pack();
		this.setLocation(100, 200);
		this.setVisible(true);
	}


	private void makeTheLayout()
	{
		this.setLayout(new FlowLayout());
		this.add(b1);
		this.add(b2);
		this.add(tf1);
		this.add(tf2);

	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("gklickt");

	}

}
