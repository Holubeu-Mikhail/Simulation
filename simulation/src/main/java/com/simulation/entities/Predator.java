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
        Herbivore target = (Herbivore) getClosest(entities, Herbivore.class);

        if (target != null) {
            if (this.position.getDistanceTo(target.getPosition()) <= 1) {
                increaseHealth(50);
                target.increaseHealth(-attackPower);
            }
            else {
                moveTo(target.getPosition());
            }
        }
    }
}
