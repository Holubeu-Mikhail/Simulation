package com.simulation;

import com.simulation.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Entity> entities;
    private int moveCount;
    private String renderer = "To be implemented";

    public Simulation() {
        entities = new ArrayList<>();
        moveCount = 0;
    }

    public void start() {
        System.out.println("start");
    }

    public void pause() {
        System.out.println("pause");
    }

    private void nextTurn() {
        // do logic
    }
}
