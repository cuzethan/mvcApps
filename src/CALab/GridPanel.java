package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {
    private JButton run1;
    private JButton run50;
    private JButton populate;
    private JButton clear;

    public GridPanel(AppFactory f){
        super(f);

        controlPanel.setLayout(new GridLayout(2, 2));

        JPanel run1Panel = new JPanel(new FlowLayout());
        JPanel run50Panel = new JPanel(new FlowLayout());
        JPanel populatePanel = new JPanel(new FlowLayout());
        JPanel clearPanel = new JPanel(new FlowLayout());

        run1Panel.setBackground(Color.PINK);
        run50Panel.setBackground(Color.PINK);
        populatePanel.setBackground(Color.PINK);
        clearPanel.setBackground(Color.PINK);


        run1 = new JButton("Run1");
        run50 = new JButton("Run50");
        populate = new JButton("Populate");
        clear = new JButton("Clear");

        run1Panel.add(run1);
        run50Panel.add(run50);
        populatePanel.add(populate);
        clearPanel.add(clear);

        controlPanel.add(run1Panel);
        controlPanel.add(run50Panel);
        controlPanel.add(populatePanel);
        controlPanel.add(clearPanel);

        run1.addActionListener(this);
        run50.addActionListener(this);
        populate.addActionListener(this);
        clear.addActionListener(this);
    }

}
