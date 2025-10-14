package com.simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static final int GRID_SIZE = 10;
    public static final int CELL_SIZE = 50;

    private Simulation simulation;
    private GridPane grid;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        grid = new GridPane();
        simulation = new Simulation(grid);

        Button startButton = new Button("Start simulation");
        startButton.setOnAction(e -> simulation.start());

        Button pauseButton = new Button("Pause simulation");
        pauseButton.setOnAction(e -> simulation.pause());

        VBox root = new VBox(10, grid, startButton, pauseButton);
        Scene scene = new Scene(root);

        stage.setTitle("Simulation");
        stage.setScene(scene);
        stage.show();
    }
}
