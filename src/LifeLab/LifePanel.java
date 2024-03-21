package LifeLab;

import CALab.Grid;
import CALab.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;

public class LifePanel extends GridPanel {
    public LifePanel(AppFactory f){
        super(f);
    }

    public static void main(String[] args) {
        AppFactory factory = new LifeFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }

}

