package CALab;

import mvc.*;


public abstract class GridFactory implements AppFactory {
    public abstract Model makeModel();
    public View makeView(Model m) { return new GridView(m); }
    public String getTitle(){
        return "CA Lab";
    }
    public String[] getHelp(){
        //dunno if thats what clear does
        return new String[]{"click RUN1 to run one cycle", "click RUN50 to run fifty cycles",
                "click POPULATE to have all the cells set to a random state", "click CLEAR to reset the state of all cells"};
    }
    public String about(){
        return "Cellular Automata simulating 'The Game of Life'";
    }
    public String[] getEditCommands(){
        return new String[]{"Run1","Run50", "Populate", "Clear"};
    }
    public Command makeEditCommand(Model m, String type, Object source){
        if (type.equals("Run1"))
            return new RunCommand(m,1);
        else if (type.equals("Run50"))
            return new RunCommand(m, 50);
        else if (type.equals("Populate"))
            return new PopulateCommand(m);
        else if (type.equals("Clear"))
            return new ClearCommand(m);
        return null;
    }
}
