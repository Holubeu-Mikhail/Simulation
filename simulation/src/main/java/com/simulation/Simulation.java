package com.simulation;

import com.simulation.entities.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Timeline simulationTimeline;
    private List<Entity> entities;
    private int moveCount;
    private Renderer renderer;

    public Simulation(GridPane grid) {
        entities = new ArrayList<>();
        moveCount = 1;
        renderer = new Renderer(grid);

        entities.add(new Wolf(new Position(1, 1)));
        //entities.add(new Rock(new Position(1, 2)));
        entities.add(new Rabbit(new Position(1, 4)));
        entities.add(new Grass(new Position(1, 8)));

        renderer.renderMap(entities);
    }

    public void start() {
        simulationTimeline = new Timeline(new KeyFrame(
                Duration.seconds(1),
                e -> nextTurn()
        ));
        simulationTimeline.setCycleCount(Timeline.INDEFINITE);
        simulationTimeline.play();
    }

    public void pause() {
        if (simulationTimeline != null) {
            simulationTimeline.stop();
        }
    }

    private void nextTurn() {
        makeEntitiesTurn();
        removeEntities();
        renderer.renderMap(entities);

        System.out.println("Iteration: " + moveCount++);
    }

    private void makeEntitiesTurn() {
        for (Entity entity : entities) {
            if (entity instanceof Herbivore) {
                ((Herbivore) entity).makeMove(entities);
            }
            else if (entity instanceof Predator) {
                ((Predator) entity).makeMove(entities);
            }
        }
    }

    private void removeEntities() {
        entities.removeIf(x -> {
            if (x instanceof Grass) {
                return ((Grass) x).isEaten();
            }
            if (x instanceof Creature) {
                return !((Creature) x).isAlive();
            }

            return false;
        });
    }
}
