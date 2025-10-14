package com.simulation;

import com.simulation.entities.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.simulation.Main.CELL_SIZE;
import static com.simulation.Main.GRID_SIZE;

public class Renderer {
    private static final String IMAGES_PATH = "/images/";
    private static final String ROCK_IMAGE_NAME = "rock.png";
    private static final String GRASS_IMAGE_NAME = "grass.png";
    private static final String WOLF_IMAGE_NAME = "wolf.png";
    private static final String RABBIT_IMAGE_NAME = "rabbit.png";

    private GridPane grid;
    private Map<String, ImageView> images;

    public Renderer(GridPane grid) {
        this.grid = grid;
        images = loadImages();
    }

    public void renderMap(List<Entity> entities) {
        renderGrid();
        clearGrid();

        for (Entity entity : entities) {
            renderEntity(entity);
        }
    }

    private void renderGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
                grid.add(cell, i, j);
            }
        }
    }

    private void renderEntity(Entity entity) {
        ImageView entityImageView = images.get(entity.getClass().getName());
        int x = entity.getPosition().getX() - 1;
        int y = entity.getPosition().getY() - 1;
        grid.add(entityImageView, x, y);
    }

    private Map<String, ImageView> loadImages() {
        Map<String, ImageView> images = new HashMap<>();

        try {
            images.put(Rock.class.getName(), createImageView(IMAGES_PATH + ROCK_IMAGE_NAME));
            images.put(Wolf.class.getName(), createImageView(IMAGES_PATH + WOLF_IMAGE_NAME));
            images.put(Grass.class.getName(), createImageView(IMAGES_PATH + GRASS_IMAGE_NAME));
            images.put(Rabbit.class.getName(), createImageView(IMAGES_PATH + RABBIT_IMAGE_NAME));
        }
        catch (Exception ex) {
            System.err.println("Error occurred while loading images.");
        }

        return images;
    }

    private void clearGrid() {
        grid.getChildren().removeIf(node -> node instanceof ImageView);
    }

    private ImageView createImageView(String imagePath) {
        ImageView imageView = new ImageView(new Image(getClass().getResource(imagePath).toExternalForm()));
        imageView.setFitWidth(CELL_SIZE);
        imageView.setFitHeight(CELL_SIZE);
        imageView.setPreserveRatio(true);

        return imageView;
    }
}