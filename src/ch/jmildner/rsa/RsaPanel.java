package ch.jmildner.rsa;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author Johann Mildner
 */
public class RsaPanel extends JPanel
{
	private static final long serialVersionUID = 1L;


	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Johann Mildner
	private JPanel panel1;


	private JLabel label1;


	private JLabel label2;


	private JTextField tfP;


	private JLabel label9;


	private JLabel label3;


	private JTextField tfQ;


	private JLabel label12;


	private JLabel label4;


	private JTextField tfN;


	private JLabel label13;


	private JLabel label5;


	private JTextField tfE;


	private JLabel label14;


	private JLabel label6;


	private JTextField tfO;


	private JLabel label15;


	private JLabel label7;


	private JTextField tfD;

	private JLabel label16;
	private JLabel label8;
	private JTextField tfT;
	private JLabel label17;
	private JLabel label10;
	private JTextField tfV;
	private JLabel label18;
	private JLabel label11;
	private JTextField tfX;
	private JLabel label19;
	private JPanel panel2;
	private JButton btnGetRandom;
	private JButton btnTryIt;
	private JButton btnRandomAndTry;
	private JScrollPane scrollPane1;
	private JTextArea ta;
	private JPanel panel3;
	private JButton btnClear;
	private JButton btnQuit;
	private JPopupMenu popupMenu1;
	private JMenuItem menuItemClear;


	public RsaPanel()
	{
		initComponents();
	}


	public void clear1()
	{
		tfP.setText("");
		tfQ.setText("");
		tfN.setText("");
		tfE.setText("");
		tfO.setText("");
		tfD.setText("");
		tfT.setText("");
		tfV.setText("");
		tfX.setText("");
	}


	public void clear2()
	{
		clear1();
		ta.setText("");
	}


	public JButton getBtnClear()
	{
		return btnClear;
	}


	public JButton getBtnGetRandom()
	{
		return btnGetRandom;
	}


	public JButton getBtnQuit()
	{
		return btnQuit;
	}


	public JButton getBtnRandomAndTry()
	{
		return btnRandomAndTry;
	}


	public JButton getBtnTryIt()
	{
		return btnTryIt;
	}


	public JMenuItem getMenuItemClear()
	{
		return menuItemClear;
	}


	public JPopupMenu getPopupMenu1()
	{
		return popupMenu1;
	}


	public JTextArea getTa()
	{
		return ta;
	}


	public JTextField getTfD()
	{
		return tfD;
	}


	public JTextField getTfE()
	{
		return tfE;
	}


	public JTextField getTfN()
	{
		return tfN;
	}


	public JTextField getTfO()
	{
		return tfO;
	}


	public JTextField getTfP()
	{
		return tfP;
	}


	public JTextField getTfQ()
	{
		return tfQ;
	}


	public JTextField getTfT()
	{
		return tfT;
	}


	public JTextField getTfV()
	{
		return tfV;
	}


	// JFormDesigner - End of variables declaration //GEN-END:variables

	public JTextField getTfX()
	{
		return tfX;
	}


	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Johann
		// Mildner
		panel1 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		tfP = new JTextField();
		label9 = new JLabel();
		label3 = new JLabel();
		tfQ = new JTextField();
		label12 = new JLabel();
		label4 = new JLabel();
		tfN = new JTextField();
		label13 = new JLabel();
		label5 = new JLabel();
		tfE = new JTextField();
		label14 = new JLabel();
		label6 = new JLabel();
		tfO = new JTextField();
		label15 = new JLabel();
		label7 = new JLabel();
		tfD = new JTextField();
		label16 = new JLabel();
		label8 = new JLabel();
		tfT = new JTextField();
		label17 = new JLabel();
		label10 = new JLabel();
		tfV = new JTextField();
		label18 = new JLabel();
		label11 = new JLabel();
		tfX = new JTextField();
		label19 = new JLabel();
		panel2 = new JPanel();
		btnGetRandom = new JButton();
		btnTryIt = new JButton();
		btnRandomAndTry = new JButton();
		scrollPane1 = new JScrollPane();
		ta = new JTextArea();
		panel3 = new JPanel();
		btnClear = new JButton();
		btnQuit = new JButton();
		popupMenu1 = new JPopupMenu();
		menuItemClear = new JMenuItem();

		// ======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(
						new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation",
						javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM,
						new java.awt.Font("Dialog", java.awt.Font.BOLD,
								12), java.awt.Color.red), getBorder()));
		addPropertyChangeListener(new java.beans.PropertyChangeListener()
		{
			@Override
			public void propertyChange(java.beans.PropertyChangeEvent e)
			{
				if ("border".equals(e.getPropertyName()))
					throw new RuntimeException();
			}
		});

		setLayout(new BorderLayout(5, 5));

		// ======== panel1 ========
		{
			panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] {
					0, 154, 348, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 0.0, 0.0, 1.0, 0.0 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 1.0, 0.0 };

			// ---- label1 ----
			label1.setText("ENCODE/DECODE RSA");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			panel1.add(label1, new GridBagConstraints(1, 0, 3, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label2 ----
			label2.setText("P");
			panel1.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(tfP, new GridBagConstraints(1, 1, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label9 ----
			label9.setText("first Prim Number");
			panel1.add(label9, new GridBagConstraints(2, 1, 1, 1, 1.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label3 ----
			label3.setText("Q");
			panel1.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(tfQ, new GridBagConstraints(1, 2, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label12 ----
			label12.setText("second Prim Number");
			panel1.add(label12, new GridBagConstraints(2, 2, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label4 ----
			label4.setText("N");
			panel1.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- tfN ----
			tfN.setEditable(false);
			panel1.add(tfN, new GridBagConstraints(1, 3, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label13 ----
			label13.setText("first public Key -  (P * Q)");
			panel1.add(label13, new GridBagConstraints(2, 3, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label5 ----
			label5.setText("E");
			panel1.add(label5, new GridBagConstraints(0, 4, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(tfE, new GridBagConstraints(1, 4, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label14 ----
			label14.setText("second public Key - Primzahl > max(P,Q)");
			panel1.add(label14, new GridBagConstraints(2, 4, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label6 ----
			label6.setText("O");
			panel1.add(label6, new GridBagConstraints(0, 5, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- tfO ----
			tfO.setEditable(false);
			panel1.add(tfO, new GridBagConstraints(1, 5, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label15 ----
			label15.setText("(P-1) * (Q-1)");
			panel1.add(label15, new GridBagConstraints(2, 5, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label7 ----
			label7.setText("D");
			panel1.add(label7, new GridBagConstraints(0, 6, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- tfD ----
			tfD.setEditable(false);
			panel1.add(tfD, new GridBagConstraints(1, 6, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label16 ----
			label16.setText("private Key - ((D*E)%O) have to be equal to 1");
			panel1.add(label16, new GridBagConstraints(2, 6, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label8 ----
			label8.setText("T");
			panel1.add(label8, new GridBagConstraints(0, 7, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(tfT, new GridBagConstraints(1, 7, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label17 ----
			label17.setText("to encode/decode - must be less N, should not be equal to {0,1,N-1}");
			panel1.add(label17, new GridBagConstraints(2, 7, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label10 ----
			label10.setText("V");
			panel1.add(label10, new GridBagConstraints(0, 8, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- tfV ----
			tfV.setEditable(false);
			panel1.add(tfV, new GridBagConstraints(1, 8, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label18 ----
			label18.setText("encoded - (T ** E) % N");
			panel1.add(label18, new GridBagConstraints(2, 8, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label11 ----
			label11.setText("X");
			panel1.add(label11, new GridBagConstraints(0, 9, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- tfX ----
			tfX.setEditable(false);
			panel1.add(tfX, new GridBagConstraints(1, 9, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ---- label19 ----
			label19.setText("decoded - (V ** D) % N");
			panel1.add(label19, new GridBagConstraints(2, 9, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ======== panel2 ========
			{
				panel2.setLayout(new GridBagLayout());
				((GridBagLayout) panel2.getLayout()).columnWidths = new int[] {
						0, 0, 0, 0 };
				((GridBagLayout) panel2.getLayout()).rowHeights = new int[] {
						0, 0 };
				((GridBagLayout) panel2.getLayout()).columnWeights = new double[] {
						0.0, 0.0, 0.0, 1.0E-4 };
				((GridBagLayout) panel2.getLayout()).rowWeights = new double[] {
						0.0, 1.0E-4 };

				// ---- btnGetRandom ----
				btnGetRandom.setText("RANDOM");
				panel2.add(btnGetRandom, new GridBagConstraints(0, 0,
						1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));

				// ---- btnTryIt ----
				btnTryIt.setText("TRY_IT");
				panel2.add(btnTryIt, new GridBagConstraints(1, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));

				// ---- btnRandomAndTry ----
				btnRandomAndTry.setText("R & T");
				panel2.add(btnRandomAndTry, new GridBagConstraints(2,
						0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
			}
			panel1.add(panel2, new GridBagConstraints(2, 10, 1, 1, 0.0,
					0.0, GridBagConstraints.WEST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ======== scrollPane1 ========
			{

				// ---- ta ----
				ta.setEditable(false);
				scrollPane1.setViewportView(ta);
			}
			panel1.add(scrollPane1, new GridBagConstraints(1, 11, 2, 1,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0,
					0));

			// ======== panel3 ========
			{
				panel3.setLayout(new GridBagLayout());
				((GridBagLayout) panel3.getLayout()).columnWidths = new int[] {
						0, 0, 0 };
				((GridBagLayout) panel3.getLayout()).rowHeights = new int[] {
						0, 0 };
				((GridBagLayout) panel3.getLayout()).columnWeights = new double[] {
						0.0, 0.0, 1.0E-4 };
				((GridBagLayout) panel3.getLayout()).rowWeights = new double[] {
						0.0, 1.0E-4 };

				// ---- btnClear ----
				btnClear.setText("CLEAR");
				panel3.add(btnClear, new GridBagConstraints(0, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));

				// ---- btnQuit ----
				btnQuit.setText("QUIT");
				panel3.add(btnQuit, new GridBagConstraints(1, 0, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
			}
			panel1.add(panel3, new GridBagConstraints(2, 12, 1, 1, 0.0,
					0.0, GridBagConstraints.EAST,
					GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));
		}
		add(panel1, BorderLayout.CENTER);

		// ======== popupMenu1 ========
		{

			// ---- menuItemClear ----
			menuItemClear.setText("CLEAR");
			menuItemClear.setIcon(null);
			popupMenu1.add(menuItemClear);
		}
		// //GEN-END:initComponents
	}
}
