package four.Table;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private Font font = new Font("Courier New", Font.BOLD, 50);
    public Cell() {
        setFocusPainted(false);
        setOpaque(true);
        setBorderPainted(false);
        setFont(font);
    }
    public Cell(String text) {
        super(text);
        setFocusPainted(false);
        setOpaque(true);
        setFont(font);
    }
}
