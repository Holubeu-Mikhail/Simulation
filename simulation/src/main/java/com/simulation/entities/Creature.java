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

    protected abstract void makeMove(List<Entity> entities);

    protected Entity getClosest(List<Entity> entities, Class<? extends Entity> targetType) {
        Entity closest = null;
        double minDistance = Double.MAX_VALUE;

        for (Entity entity : entities) {
            if (targetType.isInstance(entity)) {
                double distance = this.position.getDistanceTo(entity.getPosition());
                if (distance < minDistance) {
                    minDistance = distance;
                    closest = entity;
                }
            }
        }
        return closest;
    }

    protected void increaseHealth(int amount) {
        health += amount;

        if (health < 0) {
            health = 0;
        }

        if (health > 100) {
            health = 100;
        }
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
