package ch.jmildner.gui.work;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GuiUebungFrame extends JFrame
{

    private static final long serialVersionUID = 1L;

    public GuiUebungFrame(int test)
    {
        super("GuiUebung");

        if (test == 1)
        {
            GuiUebung1Panel mp = new GuiUebung1Panel();
            this.add(mp);
            this.setLocation(200, 100);
        }
        else
        {
            GuiUebung2Panel mp = new GuiUebung2Panel();

            this.add(mp);
            this.setLocation(400, 300);
        }

        this.pack();

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                // mp.ende();
                dispose();
            }
        });
    }
}
