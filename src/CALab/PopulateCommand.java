package CALab;

import mvc.Command;
import mvc.Model;

public class PopulateCommand extends Command {
    public PopulateCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        if (!(model instanceof Grid)) {
            throw new Exception("Model must instantiate Grid");
        }
        Grid grid = (Grid) model;
        grid.repopulate(true);
    }
}