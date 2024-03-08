package stopLight;

import mvc.*;

public class StoplightPanel extends AppPanel {

    public StoplightPanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
    }

}

