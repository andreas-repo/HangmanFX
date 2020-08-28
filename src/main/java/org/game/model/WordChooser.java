package org.game.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class WordChooser {

    final Logger logger = Logger.getLogger(WordChooser.class.getName());


    private String chosenWord;

    public WordChooser() {
        chooseWord();
    }

    public void chooseWord() {
        Random random = new Random();

        try(Stream<String> allLines = Files.lines(Paths.get("C:\\Users\\andre\\Development\\Example Code\\HangmanFX\\src\\main\\resources\\hangman-wordlist.txt"))) {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\andre\\Development\\Example Code\\HangmanFX\\src\\main\\resources\\hangman-wordlist.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();

            int randomLine = random.nextInt(lines);

            chosenWord = allLines.skip(randomLine-1).findFirst().isPresent().get();

            reader.close();

        } catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in WordChooser.");
        }
    }

    public String getChosenWord() {
        return chosenWord;
    }
}
