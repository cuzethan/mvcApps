package CALab;

import mvc.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
        for (int i = 0; i < ((Grid) model).getDim(); i++) {
            for (int j = 0; j < ((Grid) model).getDim(); i++) {
                CellView cell = new CellView(((Grid)model).getCell(i, j));
                cellViews[i][j] = cell;
            }
        }
    }

    public void update() {
        for (int i = 0; i < ((Grid) model).getDim(); i++) {
            for (int j = 0; j < ((Grid) model).getDim(); i++) {
                cellViews[i][j].update();
            }
        }
    }
}
