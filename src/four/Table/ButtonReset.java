package four.Table;

import javax.swing.*;
import java.awt.*;

public class ButtonReset extends JButton {
    private Font font = new Font("Courier New", Font.BOLD, 30);
    public ButtonReset() {
        setText("Reset");
        setName("ButtonReset");
        setFocusPainted(false);
        setOpaque(true);
        setBorderPainted(false);
        setFont(font);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
    }
}
