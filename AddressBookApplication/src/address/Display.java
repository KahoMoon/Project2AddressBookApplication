package address;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {
    private JButton button;
    private JPanel panelMain;

    public Display() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Hello");

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Display");
        frame.setContentPane(new Display().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
