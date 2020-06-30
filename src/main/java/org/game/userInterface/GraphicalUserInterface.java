package org.game.userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GraphicalUserInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FileInputStream input = new FileInputStream("C:\\Users\\andre\\Development\\Example Code\\HangmanFX\\src\\main\\resources\\startImage.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        HBox hBox = new HBox();
        hBox.getChildren().add(imageView);



        Button button = new Button("Change");
        button.setId("button");
        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.CENTER);
        hbButton.getChildren().add(button);

        GridPane gridPane = new GridPane();
        gridPane.add(hBox, 0, 1);
        gridPane.add(hbButton, 0, 2);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileInputStream input2 = null;
                try {
                    input2 = new FileInputStream("C:\\Users\\andre\\Development\\Example Code\\HangmanFX\\src\\main\\resources\\firstImage.jpg");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Image image2 = new Image(input2);
                ImageView imageView = new ImageView(image2);
                hBox.getChildren().remove(0);
                hBox.getChildren().add(imageView);
            }
        });






        Scene scene = new Scene(gridPane, 200, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HangmanFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
