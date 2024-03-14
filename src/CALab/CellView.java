package CALab;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CellView extends JButton implements ActionListener, Subscriber { // extends JButton implements ActionListener, Subscriber
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
    }

    public CellView() { this(null); }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getStatus());
    }

    // called by notifySubscribers and GridView.update

    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getStatus());
    }
}
