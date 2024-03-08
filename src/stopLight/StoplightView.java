package stopLight;

import mvc.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StoplightView extends View {

    public StoplightView(Stoplight light) {
        super(light);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.LIGHT_GRAY);
    }

    public void update() {
        repaint();
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Stoplight light = (Stoplight) model;
        StoplightShape shape = new StoplightShape(light);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }
}