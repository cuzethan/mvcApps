package LifeLab;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {
    protected int status = 0;
    protected int ambience = 0;

    public void observe() {
        int count = 0;
        for (Cell neighbor: neighbors) {
            if (((Agent) neighbor).status == 1) {
                count++;
            }
        }
        ambience = count;
    }
    public void interact() {/*no interact phase in this lab*/}
    public void update() {
        if (Society.rebirth.contains(ambience)) {
            status = 1;
        }

        if (Society.death.contains(ambience)) {
            status = 0;
        }
    }
    public void nextState() {
        if (status == 1) {
            status = 0;
            return;
        }
        status = 1;
    }
    public void reset(boolean randomly) {
        if (randomly) {
            Random r = new Random();
            int rng = r.nextInt(100);
            if (rng < Society.percentAlive) {
                status = 1;
            } else {
                status = 0;
            }
        } else {
            status = 0;
        }
        ambience = 0;
    }

    public Color getColor() {
        if (status == 0) {
            return Color.RED;
        }
        return Color.GREEN;
    }
    public int getStatus() {return ambience;}
}
