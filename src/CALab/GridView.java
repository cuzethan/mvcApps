package CALab;

import mvc.*;

import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];
    int dim;

    public GridView(Model model) {
        super(model);
        setGrid();
    }

    @Override
    public void setView(Model model) {
        super.setView(model);
        this.removeAll();
        setGrid();
    }

    public void setGrid() {
        dim = ((Grid) model).getDim();
        this.setLayout(new GridLayout(dim, dim));
        cellViews = new CellView[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                CellView cell = new CellView(((Grid)model).getCell(i, j));
                cellViews[i][j] = cell;
                cellViews[i][j].setOpaque(true);
                this.add(cellViews[i][j]);
                cellViews[i][j].update();
            }
        }
    }
    @Override
    public void update() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cellViews[i][j].update();
            }
        }
    }
}
