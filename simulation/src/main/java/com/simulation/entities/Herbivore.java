package com.simulation.entities;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(Position position, int speed) {
        super(position, speed);
    }

    @Override
    public void makeMove(List<Entity> entities) {
        Grass target = (Grass) getClosest(entities, Grass.class);

        if (target != null) {
            if (this.position.getDistanceTo(target.getPosition()) <= 1) {
                increaseHealth(50);
                target.setEaten(true);
            }
            else {
                moveTo(target.getPosition());
            }
        }
        else {
            Predator predator = (Predator) getClosest(entities, Predator.class);
            //moveFrom(predator);
        }
    }
}
