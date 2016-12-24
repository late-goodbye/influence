package ru.kpfu.itis.influence.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Created by cmen on 24/12/16.
 */
public class GameButton {

    private static final String GAME_BUTTON_FXML = "../fxml/game_button.fxml";
    private static final int SCREEN_WIDTH = 800;
    private int enemyCells = 1;
    private int playerCells = 1;
    Stop[] stops;
    LinearGradient linearGradient;

    private double startX = 400;
    private double endX = 410;

    private Pane gameButton;

    public GameButton(Color playerColor, Color enemyColor) {
        try {
            gameButton = FXMLLoader.load(getClass().getResource(GAME_BUTTON_FXML));
            stops = new Stop[] {new Stop(0, playerColor), new Stop(1, enemyColor)};
            linearGradient = new LinearGradient(startX, 0, endX, 0, false,
                    CycleMethod.NO_CYCLE, stops);
            ((Rectangle) gameButton.getChildren().get(0)).setFill(linearGradient);
            ((Rectangle) gameButton.getChildren().get(3)).setFill(playerColor);

            gameButton.setOnMouseClicked(mouseEvent -> {
                System.out.println("Click!");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCellsNumbers(int playerCells, int enemyCells) {
        this.enemyCells = enemyCells;
        this.playerCells = playerCells;

        startX = playerCells >= enemyCells ? 800 - (double) enemyCells / playerCells * 400 : (double) playerCells / enemyCells * 400;
        endX = startX + 10;
        System.out.println("Set! " + startX);

        linearGradient = new LinearGradient(startX, 0, endX, 0, false, CycleMethod.NO_CYCLE,
                stops);
        ((Rectangle) gameButton.getChildren().get(0)).setFill(linearGradient);
    }

    public Pane getPaneForm() {
        return gameButton;
    }

    public void setMainLabelText(String text) {
        ((Label) gameButton.getChildren().get(1)).setText(text);
    }

    public void setSecondaryLabelText(String text) {
        ((Label) gameButton.getChildren().get(2)).setText(text);
    }

    public int getEnemyCells() {
        return enemyCells;
    }

    public int getPlayerCells() {
        return playerCells;
    }

}
