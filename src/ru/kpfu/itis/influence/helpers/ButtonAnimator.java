package ru.kpfu.itis.influence.helpers;

import javafx.animation.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * Created by cmen on 12/12/16.
 */
public class ButtonAnimator {

    public static void animate(Button btn) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.0);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(colorAdjust.brightnessProperty(), colorAdjust.brightnessProperty().getValue(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(colorAdjust.brightnessProperty(), -0.5, Interpolator.LINEAR))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        btn.setOnMouseEntered(mouseEvent -> {
            btn.setEffect(colorAdjust);
            timeline.play();
        });

        btn.setOnMouseExited(mouseEvent -> {
            timeline.stop();
            btn.setEffect(null);
        });


        /*
        FillTransition fillTransition = new FillTransition(Duration.seconds(0.5), bg);
            this.setOnMouseEntered(mouseEvent -> {
                fillTransition.setFromValue(Color.DARKGRAY);
                fillTransition.setToValue(Color.DARKGOLDENROD);
                fillTransition.setCycleCount(Animation.INDEFINITE);
                fillTransition.setAutoReverse(true);
                fillTransition.play();
            });
            this.setOnMouseExited(mouseEvent -> {
                fillTransition.stop();
                bg.setFill(Color.WHITE);
            });
         */
    }

}
