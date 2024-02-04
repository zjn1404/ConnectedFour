package four;

import javax.swing.*;
import java.awt.*;
import four.Table.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectFour extends JFrame {
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout(5,5));
        setTitle("Connect 4");

        TableGUI tableGUI = new TableGUI(6,7);
        add(tableGUI, BorderLayout.CENTER);

        JPanel bottomSection = new JPanel();
        ButtonReset buttonReset = new ButtonReset();
        buttonReset.setHorizontalAlignment(SwingConstants.CENTER);
        buttonReset.addActionListener(e -> {
            tableGUI.reset();
        });
        bottomSection.add(buttonReset);
        add(bottomSection, BorderLayout.SOUTH);
    }
}