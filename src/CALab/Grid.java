package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                cells[i][j] = makeCell(true);
                cells[i][j].row = i;
                cells[i][j].col = j;
                cells[i][j].myGrid = this;
            }
        }

        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                cells[i][j].neighbors = getNeighbors(cells[i][j], 1);
            }
        }
        changed();
        // 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j].reset(randomly);
            }
        }
        time = 0;
        changed();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
            Set<Cell> neighbors = new HashSet<>();
            int row = asker.row;
            int col = asker.col;

            for (int i = (-1 * radius); i <= radius; i++) {
                int currRow = i + row;
                if (currRow > dim - 1) {
                    currRow = i - 1;
                } else if (currRow < 0) {
                    currRow = dim + i;
                }
                for (int j = (-1 * radius); j <= radius; j++) {
                    int currCol = j + col;
                    if (currRow == asker.row && currCol == asker.col) {
                        continue;
                    }
                    if (currCol > dim - 1) {
                        currCol = j - 1;
                    } else if (currCol < 0) {
                        currCol = dim + j;
                    }
                    neighbors.add(cells[currRow][currCol]);
                }
            }
            return neighbors;
    }

    // cell phases:

    public void observe() {
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                cells[i][j].observe();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                cells[i][j].interact();
            }
        }
        notifySubscribers();
    }

    public void update() {
        for (int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                cells[i][j].update();
            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
        changed();
    }
}

