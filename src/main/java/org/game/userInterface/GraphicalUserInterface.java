package org.game.userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.game.model.HangmanGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class GraphicalUserInterface extends Application {

    private HangmanGame hangmanGame = new HangmanGame();
    private int counter = 1;
    private ImageView imageView;
    private String[] game = new String[this.hangmanGame.getWord().length()];
    private Set<String> listOfGuesses;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageGrabber imageGrabber = new ImageGrabber();
        imageGrabber.setStartImage();
        //HBox and ImageView for game progress
        this.imageView = new ImageView(imageGrabber.getImage());
        HBox hBox = new HBox();
        hBox.getChildren().add(this.imageView);

        //GridPan for interaction with player
        GridPane grid = new GridPane();
        GridPane gridExtraControlls = new GridPane();
        gridExtraControlls.setAlignment(Pos.CENTER);
        gridExtraControlls.setHgap(10);
        gridExtraControlls.setVgap(10);
        gridExtraControlls.setPadding(new Insets(25, 25, 25, 25));
        gridExtraControlls.getStylesheets().add("styling.css");

        //create the list of the already guessed letters
        this.listOfGuesses = new HashSet<>();

        //Textfield for the word
        TextField questionText = new TextField(this.hangmanGame.getObliteratedWord());
        questionText.setId("questionTest");
        questionText.setAlignment(Pos.CENTER);
        questionText.setEditable(false);
        HBox hbQuestionText = new HBox(10);
        hbQuestionText.setAlignment(Pos.CENTER);
        hbQuestionText.getChildren().add(questionText);
        grid.add(hbQuestionText, 0, 0, 4, 1);

        //Seperator to sperate questionText and answerText
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        separator.setVisible(false);
        HBox hbSeperator = new HBox(10);
        hbSeperator.setAlignment(Pos.BOTTOM_CENTER);
        hbSeperator.getChildren().add(separator);
        grid.add(hbSeperator, 0, 1);

        //textfield for the letter or the whole word you guess
        TextField answerText = new TextField();
        answerText.setId("answerText");
        answerText.setAlignment(Pos.CENTER);
        HBox hbAnswerText = new HBox(10);
        hbAnswerText.setAlignment(Pos.CENTER);
        hbAnswerText.getChildren().add(answerText);
        hbAnswerText.setMaxWidth(140);
        hbAnswerText.setMinWidth(140);
        grid.add(hbAnswerText, 0, 3);

        //Button to try if your guess is true
        Button button = new Button("Try it!");
        button.setId("button");
        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.CENTER);
        hbButton.getChildren().add(button);
        grid.add(hbButton, 3, 3);

        //Button to uncover the first letter
        Button tippButton = new Button("Tipp!");
        tippButton.setId("tippButton");
        HBox hbTippButton = new HBox(10);
        hbTippButton.setAlignment(Pos.CENTER);
        hbTippButton.getChildren().add(tippButton);
        gridExtraControlls.add(hbTippButton, 0, 0);

        //textarea for already guessed letters
        TextArea listOfGuessesTextArea = new TextArea(listOfGuesses.toString());
        listOfGuessesTextArea.setId("listOfGuessesTextArea");
        listOfGuessesTextArea.setWrapText(true);
        HBox hbListOfGuessesTextArea = new HBox(10);
        hbListOfGuessesTextArea.setAlignment(Pos.CENTER);
        hbListOfGuessesTextArea.getChildren().add(listOfGuessesTextArea);
        gridExtraControlls.add(hbListOfGuessesTextArea, 0, 1);

        //actions for the "try your guess" button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String answer = answerText.getText();
                boolean result = GraphicalUserInterface.this.hangmanGame.checkGuess(answer);
                if(answer.equals(GraphicalUserInterface.this.hangmanGame.getWord()) || !GraphicalUserInterface.this.hangmanGame.getObliteratedWord().contains("-")) {
                    imageGrabber.setWinImage();
                    hBox.getChildren().remove(GraphicalUserInterface.this.imageView);
                    ImageView imageView2 = new ImageView(imageGrabber.getImage());
                    hBox.getChildren().add(imageView2);
                    GraphicalUserInterface.this.imageView = imageView2;
                    counter = 0;
                    GraphicalUserInterface.this.hangmanGame.newWord();
                    answerText.setText("");
                    questionText.setText(GraphicalUserInterface.this.hangmanGame.getObliteratedWord());
                    GraphicalUserInterface.this.listOfGuesses = new HashSet<>();
                } else if (GraphicalUserInterface.this.listOfGuesses.contains(answer)) {

                } else if(result) {
                    questionText.setText(GraphicalUserInterface.this.hangmanGame.getObliteratedWord().toString());
                    GraphicalUserInterface.this.listOfGuesses.add(answer);
                    listOfGuessesTextArea.setText(GraphicalUserInterface.this.listOfGuesses.toString());
                } else if(!answer.equals("")){
                    switch (counter) {
                        case 0: imageGrabber.setStartImage();   break;
                        case 1: imageGrabber.setFirstImage();   break;
                        case 2: imageGrabber.setSecondImage();  break;
                        case 3: imageGrabber.setThirdImage();   break;
                        case 4: imageGrabber.setFourthImage();  break;
                        case 5: imageGrabber.setFifthImage();   break;
                        case 6: imageGrabber.setSixthImage();   break;
                        case 7: imageGrabber.setSeventhImage(); break;
                        case 8: imageGrabber.setEighthImage();  break;
                        case 9: imageGrabber.setNinthImage();   break;
                        case 10: imageGrabber.setTenthImage();  break;
                        case 11: imageGrabber.setEleventhImage();   break;
                        case 12: imageGrabber.setTwelveImage();  GraphicalUserInterface.this.hangmanGame.newWord();  answerText.setText(""); questionText.setText(GraphicalUserInterface.this.hangmanGame.getObliteratedWord());  break;
                    }
                    hBox.getChildren().remove(GraphicalUserInterface.this.imageView);
                    ImageView imageView2 = new ImageView(imageGrabber.getImage());
                    hBox.getChildren().add(imageView2);
                    GraphicalUserInterface.this.imageView = imageView2;
                    if(counter >= 12) {
                        GraphicalUserInterface.this.listOfGuesses = new HashSet<>();
                        listOfGuessesTextArea.setText(GraphicalUserInterface.this.listOfGuesses.toString());
                        counter = -1;
                    } else {
                        GraphicalUserInterface.this.listOfGuesses.add(answer);
                        listOfGuessesTextArea.setText(GraphicalUserInterface.this.listOfGuesses.toString());
                    }
                    counter++;
                }
            }
        });

        //action for the tipp button
        tippButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String[] indexedWord = GraphicalUserInterface.this.hangmanGame.getIndexedWord();
                String firstLetter = indexedWord[0];
                String[] indexedObliteratedWord = GraphicalUserInterface.this.hangmanGame.getIndexedObliteratedWord();
                indexedObliteratedWord[0] = firstLetter;

                GraphicalUserInterface.this.hangmanGame.setIndexedObliteratedWord(indexedObliteratedWord);
                GraphicalUserInterface.this.hangmanGame.setObliteratedWord(Arrays.toString(indexedObliteratedWord));
                questionText.setText(GraphicalUserInterface.this.hangmanGame.getObliteratedWord());

                GraphicalUserInterface.this.listOfGuesses.add(firstLetter);
                listOfGuessesTextArea.setText(GraphicalUserInterface.this.listOfGuesses.toString());
            }
        });


        GridPane gridPane = new GridPane();
        gridPane.add(hBox, 0, 1);
        gridPane.add(grid, 0, 3);
        gridPane.add(gridExtraControlls, 0,4);

        //gridExtraControlls.setGridLinesVisible(true);
        //grid.setGridLinesVisible(true);
        //gridPane.setGridLinesVisible(true);

        Scene scene = new Scene(gridPane, 200, 390);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HangmanFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
