package ch.jmildner.gui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import ch.jmildner.tools.MyPanel;

public class DialogPanel extends MyPanel
{

    private static final long serialVersionUID = 1L;

   

    private JButton b1 = new JButton("klickMich");
    private JButton b2 = new JButton("startDialog");
    private JTextField tf1 = new JTextField("", 30);
    private JTextField tf2 = new JTextField("", 30);

    public DialogPanel()
    {
        this.makeTheLayout();
        this.addTheListener();
    }

    private void addTheListener()
    {
        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                klickmich();
            }
        });

        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dialog();
            }
        });
    }

    private void dialog()
    {
        new About();
    }

    public void ende()
    {
        // aufraeumen();
    }

    private void klickmich()
    {
        if (tf1.getText().equals(""))
        {
            tf1.setText("Danke dass Du mich geklickt hast");
            tf2.setText("");
        }
        else
        {
            tf2.setText("Danke dass Du mich geklickt hast");
            tf1.setText("");
        }
    }

    private void makeTheLayout()
    { 
        final MyPanel mp = new MyPanel();
        boolean test = true;
        this.init(6, 8, test);

        int zeile = test ? 1 : 0;

        zeile++;
        this.addCaptionCenter("UEBERSCHRIFT", zeile, 1, 6);

        zeile++;
        this.add(b1, zeile, 3, 2);
        this.add(b2, zeile, 5, 2);

        this.add(tf1, ++zeile, 1, 6);
        this.add(tf2, ++zeile, 1, 6);
    }
}
