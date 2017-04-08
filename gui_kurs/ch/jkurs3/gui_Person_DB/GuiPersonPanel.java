package ch.jkurs3.gui_Person_DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;
import ch.java_akademie.tools.MyTools;
import ch.java_akademie.tools.TestDatenTools;

public class GuiPersonPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JFrame jFrame;

	private JButton connect = new JButton("connect");
	private JButton close = new JButton("close");
	private JButton create = new JButton("create");
	private JButton drop = new JButton("drop");
	private JButton insert = new JButton("insert");
	private JButton select = new JButton("select");
	private JButton delete = new JButton("delete");
	private JButton update = new JButton("update");
	private JButton clear = new JButton("clear");
	private JButton ende = new JButton("ende");

	private JTextField id = new JTextField("", 5);
	private JTextField name = new JTextField("", 15);
	private JTextField addr = new JTextField("", 15);

	private JTextArea ta = new JTextArea(12, 40);

	private JTable table = null;

	private JScrollPane sp = null;

	PersonDao dao;


	MyPanel mp;


	int zeile;


	public GuiPersonPanel(JFrame jFrame)
	{
		this.jFrame = jFrame;
		makeTheLayout();
		addTheListener();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == connect)
		{
			connect();
			connect.setEnabled(false);
			close.setEnabled(true);
			create.setEnabled(true);
			drop.setEnabled(true);
			insert.setEnabled(true);
			select.setEnabled(true);
			delete.setEnabled(true);
			update.setEnabled(true);
			return;
		}

		if (e.getSource() == close)
		{
			close();
			connect.setEnabled(true);
			close.setEnabled(false);
			create.setEnabled(false);
			drop.setEnabled(false);
			insert.setEnabled(false);
			select.setEnabled(false);
			delete.setEnabled(false);
			update.setEnabled(false);

			return;
		}

		if (e.getSource() == create)
		{
			create();
			return;
		}

		if (e.getSource() == drop)
		{
			drop();
			return;
		}

		if (e.getSource() == insert)
		{
			insert();
			return;
		}

		if (e.getSource() == select)
		{
			select();
			return;
		}

		if (e.getSource() == delete)
		{
			delete();
			return;
		}

		if (e.getSource() == update)
		{
			update();
			return;
		}

		if (e.getSource() == ende)
		{
			System.exit(0);
		}

		if (e.getSource() == clear)
		{
			clear();
			return;

		}
	}


	private void addTheListener()
	{
		connect.addActionListener(this);
		close.addActionListener(this);
		create.addActionListener(this);
		drop.addActionListener(this);
		insert.addActionListener(this);
		select.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);

		clear.addActionListener(this);
		ende.addActionListener(this);
	}


	private void close()
	{
		dao = null;
		ta.setText("close OK");
	}


	private void connect()
	{
		try
		{
			dao = new PersonDaoImpl();
			
			ta.setText("connect OK");
		}
		catch (Exception e)
		{
			ta.setText(e.getMessage());
		}
	}


	private void insert()
	{
		ta.setText("");
		try
		{
			String sid = id.getText();
			sid = sid.trim();
			if (sid.trim().equals(""))
			{
				name.setText("");
				addr.setText("");

				clear();

				for (int i = 1; i < 10; i++)
				{
					Person p = new Person(MyTools.getRandom(1, 2000000000), TestDatenTools.getName(),
							TestDatenTools.getAdresse());
					dao.insert(p);
					ta.append(p + " eingefuegt!\n");
				}
			}
			else
			{
				try
				{
					int iid = Integer.parseInt(sid);
					String sname, saddr;
					sname = name.getText();
					saddr = addr.getText();
					Person p = new Person(iid, sname, saddr);
					dao.insert(p);
					clear();
					ta.append(p + " eingefuegt!\n");
				}
				catch (NumberFormatException x)
				{
					ta.append("id nicht numerisch:" + sid + "\n");
				}
			}


		}
		catch (SQLException e)
		{
			ta.append("\n" + e.getMessage());
		}
	}


	private void makeTheLayout()
	{
		boolean testZeile = false;
		mp = new MyPanel(5, 12, testZeile);

		zeile = testZeile ? 1 : 0;

		// zeile 1
		zeile++;
		mp.addCaptionCenter("PERSONENVERWALTUNG", zeile, 1, 7);

		// zeile 2
		zeile++;
		mp.add(connect, zeile, 2, 1);
		mp.add(close, zeile, 3, 1);

		// zeile 3
		zeile++;
		mp.add(create, zeile, 2, 1);
		mp.add(drop, zeile, 3, 1);

		// zeile 4
		zeile++;
		mp.add(insert, zeile, 2, 1);
		mp.add(select, zeile, 3, 1);
		mp.add(delete, zeile, 4, 1);
		mp.add(update, zeile, 5, 1);

		connect.setEnabled(true);
		close.setEnabled(false);
		create.setEnabled(false);
		drop.setEnabled(false);
		insert.setEnabled(false);
		select.setEnabled(false);
		delete.setEnabled(false);
		update.setEnabled(false);


		// zeile 5
		zeile++;
		mp.add(new JLabel("ID:"), zeile, 1, 1);
		mp.add(id, zeile, 2, 2);


		// zeile 6
		zeile++;
		mp.add(new JLabel("Name:"), zeile, 1, 1);
		mp.add(name, zeile, 2, 5);


		// zeile 7
		zeile++;
		mp.add(new JLabel("Addr:"), zeile, 1, 1);
		mp.add(addr, zeile, 2, 5);


		// zeile 8
		zeile++;
		mp.add(new JLabel("Ergebnisse:"), zeile, 1, 1);
		mp.add(new JScrollPane(ta), zeile, 2, 12);


		// zeile 9
		zeile += 12;
		mp.add(clear, zeile, 6, 1);
		mp.add(ende, zeile, 7, 1);

		zeile++;

		add(mp);
	}


	private void select()
	{
		String sid = id.getText();

		ta.setText("");


		if (!sid.trim().equals(""))
		{
			int iid = 0;
			try
			{
				iid = Integer.parseInt(sid);
			}
			catch (NumberFormatException x)
			{
				ta.append("\nid nicht numerisch:" + sid);
				return;
			}

			if (iid > 0)
			{
				try
				{
					mp.remove(sp);
					jFrame.pack();
				}
				catch (Exception e)
				{
				}

				try
				{
					Person p = dao.getById(iid);
					ta.append("\n" + p);
					return;
				}
				catch (SQLException e)
				{
					ta.append("\nid nicht vorhanden:" + iid);
					return;
				}
			}
		}

		String sname = name.getText().trim();

		try
		{
			if (sname.trim().equals(""))
				sname = "%";
			List<Person> personen = dao.getByName(sname);
			Vector<String> c = new Vector<String>();
			c.add("id");
			c.add("name");
			c.add("addr");
			Vector<Vector<String>> v = new Vector<Vector<String>>();

			for (Person p : personen)
			{
				// ta.append("\n" + p);

				Vector<String> s = new Vector<String>();
				s.add("" + p.getId());
				s.add(p.getName());
				s.add(p.getAddr());
				v.add(s);

			}
			try
			{
				mp.remove(sp);
			}
			catch (Exception e)
			{
			}

			table = new JTable(v, c);
			sp = new JScrollPane(table);
			mp.add(sp, zeile, 1, 7, 12);
			jFrame.pack();
		}
		catch (SQLException e)
		{
			ta.append("\n" + e.getMessage());
		}
	}


	private void drop()
	{
		try
		{
			dao.drop();
			ta.setText("drop OK");
		}
		catch (SQLException e)
		{
			ta.setText(e.getMessage());
		}
	}


	private void create()
	{
		try
		{
			dao.create();
			ta.setText("create OK");
		}
		catch (SQLException e)
		{
			ta.setText(e.getMessage());
		}
	}


	private void clear()
	{

		id.setText("");
		name.setText("");
		addr.setText("");

		ta.setText("");

		try
		{
			if (sp != null)
				mp.remove(sp);
		}
		catch (Exception e)
		{
			System.out.println("fehler in clear: " + e.getMessage());
		}

		jFrame.pack();
	}


	private void delete()
	{
		ta.setText("\ndelete under construktion");
	}


	private void update()
	{
		ta.setText("\nupdate under construktion");
	}
}
