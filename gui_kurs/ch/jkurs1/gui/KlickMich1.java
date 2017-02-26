package ch.jkurs1.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KlickMich1 extends Frame {
	private static final long serialVersionUID = 1L;

	private _Layout layout;

	private Button b = new Button("klickMich");
	private TextField tf1 = new TextField("", 30);
	private TextField tf2 = new TextField("", 30);

	public KlickMich1(_Layout layout) {
		super("KlickMich1 " + layout);
		this.layout = layout;
		makeTheLayout();
		addTheListener();
		anzeigen();
	}

	private void addTheListener() {
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText().equals("")) {
					tf1.setText("Danke dass Du mich geklickt hast");
					tf2.setText("");
					setBackground(Color.BLUE);
				} else {
					tf2.setText("Danke dass Du mich geklickt hast");
					tf1.setText("");
					setBackground(Color.RED);
				}
			}
		});

		/*
		 * der folgende Block ist noetig um das Programm durch anklicken des X
		 * in der rechten oberen Ecke beenden zu koennen
		 */
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				// ev. Aufraeumarbeiten
				System.exit(0);
			}
		});
	}

	private void anzeigen() {
		setLocation(300 * (1 + layout.getOrdinal()), 200 * (1 + layout.getOrdinal()));
		pack();
		setVisible(true);

	}

	private void makeTheLayout() {
		switch (layout) {
		case flow:
			setLayout(new FlowLayout());
			add(b);
			add(tf1);
			add(tf2);
			break;
		case grid:
			setLayout(new GridLayout(3, 1));
			add(b);
			add(tf1);
			add(tf2);
			break;
		case border:
			setLayout(new BorderLayout());
			add(BorderLayout.NORTH, b);
			add(BorderLayout.EAST, tf1);
			add(BorderLayout.WEST, tf2);
			break;
		}
	}
}
