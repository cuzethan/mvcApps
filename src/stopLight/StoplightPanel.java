package stopLight;

import mvc.*;

import javax.swing.*;

public class StoplightPanel extends AppPanel {

    public StoplightPanel(AppFactory factory) {
        super(factory);
        JButton button = new JButton("Change");
        button.addActionListener(this);
        controls.add(button);
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }

}

