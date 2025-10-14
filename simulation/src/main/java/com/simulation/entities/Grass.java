package com.simulation.entities;

public class Grass extends Entity {
    private boolean isEaten = false;

    public Grass(Position position) {
        super(position);
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }
}
