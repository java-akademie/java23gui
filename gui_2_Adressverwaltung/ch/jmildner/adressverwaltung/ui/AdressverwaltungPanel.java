package ch.jmildner.adressverwaltung.ui;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.java_akademie.tools.MyPanel;

public class AdressverwaltungPanel extends MyPanel
{
	private static final long serialVersionUID = 1L;

	private JButton btClear = new JButton("_clear");
	private JButton btCloseDB = new JButton("_close");
	private JButton btCreateTable = new JButton("_create");
	private JButton btDelete = new JButton("_delete");
	private JButton btDropTable = new JButton("_drop");
	private JButton btInsert = new JButton("_insert");
	private JButton btOpenDB = new JButton("_open");
	private JButton btQuit = new JButton("_quit");
	private JButton btSelect = new JButton("_select");
	private JButton btUpdate = new JButton("_update");

	private JMenuItem menuItemClear = new JMenuItem("_clear");
	private JMenuItem menuItemCloseDB = new JMenuItem("_close");
	private JMenuItem menuItemCreateTable = new JMenuItem("_create");
	private JMenuItem menuItemDropTable = new JMenuItem("_drop");
	private JMenuItem menuItemExit = new JMenuItem("_exit");


	private JMenuItem menuItemOpenDB = new JMenuItem("_open");
	private JPopupMenu popupMenu = new JPopupMenu();
	private JTextArea taProtokoll = new JTextArea("", 15, 40);
	private JTextField tfAddr = new JTextField("", 20);


	private JTextField tfId = new JTextField("", 10);

	private JTextField tfName = new JTextField("", 20);


	{
		menuItemClear.setText("_clear");
		menuItemClear.setIcon(null);
		popupMenu.add(menuItemClear);
		popupMenu.add(menuItemExit);
	}


	final static boolean TEST = true;


	public AdressverwaltungPanel()
	{
		super(7, 20, TEST);


		int zeile = TEST ? 1 : 0;

		zeile++;
		add(makeMenue(), zeile, 1, 7, 1);

		zeile++;
		this.addCaptionCenter("Adressverwaltung 10/2016", zeile, 1, 7);

		zeile++;
		this.add(btOpenDB, zeile, 1, 1);
		this.add(btCloseDB, zeile, 2, 1);

		zeile++;
		this.add(btCreateTable, zeile, 1, 1);
		this.add(btDropTable, zeile, 2, 1);

		zeile++;
		this.add(btInsert, zeile, 1, 1);
		this.add(btSelect, zeile, 2, 1);
		this.add(btUpdate, zeile, 3, 1);
		this.add(btDelete, zeile, 4, 1);

		zeile++;
		this.addLabelRight("ID:", zeile, 1, 1);
		this.add(tfId, zeile, 2, 1);

		zeile++;
		this.addLabelRight("NAME:", zeile, 1, 1);
		this.add(tfName, zeile, 2, 5);

		zeile++;
		this.addLabelRight("ADDR:", zeile, 1, 1);
		this.add(tfAddr, zeile, 2, 5);

		zeile++;
		taProtokoll.setEditable(false);
		this.addTextArea(taProtokoll, zeile, 1, 7, 1);

		zeile++;
		this.add(btClear, zeile, 6, 1);
		this.add(btQuit, zeile, 7, 1);
	}


	public JButton getBtClear()
	{
		return btClear;
	}


	public JButton getBtCloseDB()
	{
		return btCloseDB;
	}


	public JButton getBtCreateTable()
	{
		return btCreateTable;
	}


	public JButton getBtDelete()
	{
		return btDelete;
	}


	public JButton getBtDropTable()
	{
		return btDropTable;
	}


	public JButton getBtInsert()
	{
		return btInsert;
	}


	public JButton getBtOpenDB()
	{
		return btOpenDB;
	}


	public JButton getBtQuit()
	{
		return btQuit;
	}


	public JButton getBtSelect()
	{
		return btSelect;
	}


	public JButton getBtUpdate()
	{
		return btUpdate;
	}


	public JMenuItem getMenuItemClear()
	{
		return menuItemClear;
	}


	public JMenuItem getMenuItemCloseDB()
	{
		return menuItemCloseDB;
	}


	public JMenuItem getMenuItemCreateTable()
	{
		return menuItemCreateTable;
	}


	public JMenuItem getMenuItemDropTable()
	{
		return menuItemDropTable;
	}


	public JMenuItem getMenuItemOpenDB()
	{
		return menuItemOpenDB;
	}


	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}


	public JTextArea getTaProtokoll()
	{
		return taProtokoll;
	}


	public JTextField getTfAddr()
	{
		return tfAddr;
	}


	public JTextField getTfId()
	{
		return tfId;
	}


	public JTextField getTfName()
	{
		return tfName;
	}



	JMenuBar makeMenue()
	{


		JMenuBar menuBar = new JMenuBar();
		JMenuItem menuItem;

		// Datenbank

		JMenu menuDatenbank = new JMenu("Datenbank");

		menuDatenbank.add(menuItemOpenDB);
		menuDatenbank.add(menuItemCloseDB);
		menuDatenbank.add(menuItemCreateTable);
		menuDatenbank.add(menuItemDropTable);

		menuItem = new JMenuItem("Insert Adressen");
		menuDatenbank.add(menuItem);

		menuItem = new JMenuItem("Disconnect");
		menuDatenbank.add(menuItem);

		menuItem = new JMenuItem("exit");
		menuDatenbank.add(menuItem);

		menuBar.add(menuDatenbank);

		// Adressen

		JMenu menuAdressen = new JMenu("Adressen");

		menuItem = new JMenuItem("alle anzeigen");
		menuAdressen.add(menuItem);

		menuItem = new JMenuItem("einfuegen/aendern/loeschen");
		menuAdressen.add(menuItem);

		menuBar.add(menuAdressen);

		// Hilfe

		JMenu menuHilfe = new JMenu("Hilfe");

		menuItem = new JMenuItem("Tips");
		menuHilfe.add(menuItem);

		menuItem = new JMenuItem("About");
		menuHilfe.add(menuItem);

		menuBar.add(menuHilfe);

		return menuBar;
	}


	public void setMenuItemClear(JMenuItem menuItemClear)
	{
		this.menuItemClear = menuItemClear;
	}


	public void setMenuItemCloseDB(JMenuItem menuItemCloseDB)
	{
		this.menuItemCloseDB = menuItemCloseDB;
	}


	public void setMenuItemCreateTable(JMenuItem menuItemCreateTable)
	{
		this.menuItemCreateTable = menuItemCreateTable;
	}


	public void setMenuItemDropTable(JMenuItem menuItemDropTable)
	{
		this.menuItemDropTable = menuItemDropTable;
	}


	public void setMenuItemOpenDB(JMenuItem menuItemOpenDB)
	{
		this.menuItemOpenDB = menuItemOpenDB;
	}
}
