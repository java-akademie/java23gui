package ch.jmildner.gui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ch.jmb.tools.MyPanel;

public class TableFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	TData td = new TData();

	JTable table;
	JButton go = new JButton("go");
	TableModel tm;


	public TableFrame()
	{
		super("TableTest");

		makeTheLayout();
		addTheListener();
		showTheFrame();
	}


	private void addTheListener()
	{
		table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int row = table.getSelectedRow();
				int cell = table.getSelectedColumn();
				String value = (String) tm.getValueAt(row, cell);
				String id = (String) tm.getValueAt(row, 0);
				System.out.println("clicked " + row + " " + cell + " "
						+ value + " " + id);

				if (value.equals("DEL"))
				{
					for (int i = 0; i < td.datal.size(); i++)
					{
						if (td.datal.get(i)[0].equals(id))
						{
							td.datal.remove(i);
							System.out.println("geloescht: " + id);
						}
					}
					tm.fireTableDataChanged();
				}
				if (value.equals("INS"))
				{
					int neu = 0;
					for (String[] d : td.datal)
					{
						System.out.println(d[0]);
						int alt = Integer.parseInt(d[0]);
						if (neu <= alt)
							neu = ++alt;
					}

					td.datal.add(row, new String[] { (neu + ""), "?",
							"?", "?", "DEL", "INS" });
					tm.fireTableDataChanged();
				}
			}
		});

		go.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int row = table.getSelectedRow();
				int cell = table.getSelectedColumn();

				if (row < 0)
				{
					System.out.println("keine Auswahl getroffen");
				}
				else
				{

					System.out.println(row + " ausgewaehlt");
					System.out.println(cell + " ausgewaehlt");

					table.clearSelection();
				}
				td.datal.get(1)[1] = "111111111111";
				td.datal.get(0)[2] = "020202020202";

				tm.fireTableCellUpdated(1, 1);

				tm.fireTableDataChanged();
			}
		});
	}


	private void makeTheLayout()
	{
		MyPanel mp = new MyPanel(6, 12, false);

		int zeile = 0;

		zeile++;
		mp.addCaptionCenter("Adressen", zeile, 1, 6);

		tm = new TableModel(td);
		table = new JTable(tm);

		zeile++;
		mp.add(new JScrollPane(table), zeile, 1, 6);

		zeile++;
		mp.add(go, zeile, 6, 1);

		this.add(mp);
	}


	private void showTheFrame()
	{
		this.pack();
		this.setLocation(800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
