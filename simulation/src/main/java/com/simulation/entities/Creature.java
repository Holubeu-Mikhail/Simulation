package com.simulation.entities;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health = 100;
    protected int speed;

    protected Creature(Position position, int speed) {
        super(position);
        this.speed = speed;
    }

    public int getSpeed() { return speed; }

    public abstract void makeMove(List<Entity> entities);

    protected void moveTowards(Position target) {
    }
}
