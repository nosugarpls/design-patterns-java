package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ObserverPatternDemo");

        Label hint = new Label("Choose a color");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("DarkGrey");
        choiceBox.getItems().add("Beige");
        choiceBox.getItems().add("Ivory");
        choiceBox.getItems().add("Purple");
        choiceBox.getItems().add("Blue");


        HashMap<String, String> colorMap = new HashMap<>();
        colorMap.put("DarkGrey", "#a9a9a9");
        colorMap.put("Beige", "#f5f5dc");
        colorMap.put("Ivory", "#fffff0");
        colorMap.put("Purple", "#b19cd9");
        colorMap.put("Blue", "#add8e6");

        Circle circle = new Circle();
        circle.setRadius(50);

        VBox layout = new VBox();
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setSpacing(40);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(hint, choiceBox, circle);

        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.setResizable(false);

        // add a listener to choiceBox
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            String p = colorMap.get(newValue);
            circle.setFill(Paint.valueOf(p));
        });

        window.show();
    }


}