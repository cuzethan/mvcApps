package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements ActionListener {
    AppFactory appfactory;
    Model model;
    View view;
    protected ControlPanel controls;
    public AppPanel(AppFactory factory) {
        appfactory = factory;
        model = appfactory.makeModel();
        view =  appfactory.makeView(model);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
    }

    public void display() {
        this.add(controls);
        this.add(view);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(appfactory.getTitle());
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {

            String[] editCommands = appfactory.getEditCommands();
            for (String c: editCommands) {
                if (cmmd.equals(c)) {
                    appfactory.makeEditCommand(model, cmmd, e.getSource()).execute();
                    return;
                }
            }
            switch (cmmd) {

                case "Save": {
                    Utilities.save(model, model.getUnsavedChanges());
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        model = Utilities.open(model);
                        view.setView(model);
                        model.notifySubscribers();
                    }

                    break;

                }

                case "New": {
                    model = appfactory.makeModel();
                    view.setView(model);
                    model.notifySubscribers();
                    break;
                }

                case "Quit": {
                    System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform(appfactory.about());
                    break;
                }

                case "Help": {
                    String[] cmmds = appfactory.getHelp();
                    Utilities.inform(cmmds);
                    break;

                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", appfactory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }


    protected class ControlPanel extends JPanel {
        public ControlPanel() {
            setBackground(Color.PINK);
        }

    }
}
