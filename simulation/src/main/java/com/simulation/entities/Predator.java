package com.simulation.entities;

import java.util.List;

public class Predator extends Creature {
    protected int attackPower;

    protected Predator(Position position, int speed, int attackPower) {
        super(position, speed);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(List<Entity> entities) {

    }
}
