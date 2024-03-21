package CALab;

import LifeLab.LifeFactory;
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

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

        run1 = new JButton("Run1");
        run1.addActionListener(this);
        run1.setAlignmentX(Component.CENTER_ALIGNMENT);
        run1.setMaximumSize(run1.getPreferredSize());

        run50 = new JButton("Run50");
        run50.addActionListener(this);
        run50.setAlignmentX(Component.CENTER_ALIGNMENT);
        run50.setMaximumSize(run50.getPreferredSize());

        populate = new JButton("Populate");
        populate.addActionListener(this);
        populate.setAlignmentX(Component.CENTER_ALIGNMENT);
        populate.setMaximumSize(populate.getPreferredSize());


        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);
        clear.setMaximumSize(clear.getPreferredSize());

        leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        leftPanel.add(run1);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        leftPanel.add(populate);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        rightPanel.add(run50);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        rightPanel.add(clear);


        controlPanel.add(leftPanel);
        controlPanel.add(rightPanel);

        /**
        controlPanel.add(run1);
        controlPanel.add(run50);
        controlPanel.add(populate);
        controlPanel.add(clear);*/
    }

}
