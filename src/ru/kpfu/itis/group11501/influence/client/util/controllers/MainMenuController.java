package ru.kpfu.itis.group11501.influence.client.util.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import ru.kpfu.itis.group11501.influence.client.util.Connection;
import ru.kpfu.itis.group11501.influence.client.util.helpers.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    // FXML Resources
    private static final String GAME_FXML = "../../fxml/game.fxml";
    private static final String RULES_FXML = "../../fxml/rules.fxml";

    // Buttons from MainMenu
    @FXML
    private Pane menuPane;
    @FXML
    private Button btnMainMenuRules;
    @FXML
    private Button btnMainMenuPlayGame;
    @FXML
    private Button btnMainMenuExit;


    public void goTo(ActionEvent actionEvent) {

        String resource = "";

        if (actionEvent.getSource().equals(btnMainMenuExit)) {
            System.exit(0);
        }
        else if (actionEvent.getSource().equals(btnMainMenuPlayGame)) {
            resource = GAME_FXML;
            Connection.init();
        }
        else if (actionEvent.getSource().equals(btnMainMenuRules)) {
            resource = RULES_FXML;
        }
        Loader.goTo(resource, menuPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("MainController initialized!");

        //animated buttons
        ButtonAnimator.animate(btnMainMenuPlayGame);
        ButtonAnimator.animate(btnMainMenuRules);
        ButtonAnimator.animate(btnMainMenuExit);
    }
}