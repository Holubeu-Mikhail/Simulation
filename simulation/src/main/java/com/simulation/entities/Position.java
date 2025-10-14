package com.simulation.entities;

import static com.simulation.Main.GRID_SIZE;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if (x > GRID_SIZE) {
            this.x = GRID_SIZE;
        }
        else if (x < 0) {
            this.x = 0;
        }
        else {
            this.x = x;
        }

        if (y > GRID_SIZE) {
            this.y = GRID_SIZE;
        }
        else if (y < 0) {
            this.y = 0;
        }
        else {
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistanceTo(Position other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
