package com.simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 50;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Simulation simulation = new Simulation();
        GridPane grid = new GridPane();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.LIGHTGREEN);
                cell.setStroke(Color.DARKGREEN);
                grid.add(cell, i, j);
            }
        }
        Button startButton = new Button("Start simulation");
        startButton.setOnAction(e -> simulation.start());

        Button pauseButton = new Button("Pause simulation");
        pauseButton.setOnAction(e -> simulation.pause());

        VBox root = new VBox(10, grid, startButton, pauseButton);
        Scene scene = new Scene(root, 700, 700);
        stage.setTitle("Simulation");
        stage.setScene(scene);
        stage.show();
    }
}
