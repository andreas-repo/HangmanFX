package org.game.model;

import org.game.userInterface.ImageGrabber;

import java.util.Arrays;


public class HangmanGame {

    private WordChooser wordChooser;
    private String word;
    private String obliteratedWord;
    private String status;
    private String[] indexedWord;
    private String[] indexedObliteratedWord;

    public HangmanGame() {
        this.wordChooser = new WordChooser();
        obliteratedWord();

    }


    private void obliteratedWord() {
        this.wordChooser.chooseWord();
        this.word = this.wordChooser.getChosenWord();
        this.indexedWord = new String[this.word.length()];
        for(int i = 0; i <= word.length()-1; i++) {
            char letter = this.word.charAt(i);
            this.indexedWord[i] = String.valueOf(letter);
        }

        this.indexedObliteratedWord = new String[this.word.length()];

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <= this.word.length()-1; i++) {
            stringBuilder.append("-");
            this.indexedObliteratedWord[i] = "-";
        }
        this.obliteratedWord = stringBuilder.toString();
        this.status = this.obliteratedWord;
    }

    public void newWord() {
        this.wordChooser.chooseWord();
        this.word = this.wordChooser.getChosenWord();
        obliteratedWord();
    }

    public boolean checkGuess(String guess) {
        boolean result = false;
        boolean contains = this.word.contains(guess);
        if(contains && guess.length() == 1) {

            for(int i = 0; i <= this.word.length()-1; i++) {
                if(this.indexedWord[i].equals(guess)) {
                    this.indexedObliteratedWord[i] = this.indexedObliteratedWord[i].replace("-", guess);
                }
            }
            result = true;

        } else if(this.word.equals(contains)) {
            result = true;
        }
        this.obliteratedWord = Arrays.toString(this.indexedObliteratedWord);

        return result;
    }


    public WordChooser getWordChooser() {
        return wordChooser;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getObliteratedWord() {
        return obliteratedWord;
    }

    public void setObliteratedWord(String obliteratedWord) {
        this.obliteratedWord = obliteratedWord;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getIndexedWord() {
        return indexedWord;
    }

    public void setIndexedWord(String[] indexedWord) {
        this.indexedWord = indexedWord;
    }

    public String[] getIndexedObliteratedWord() {
        return indexedObliteratedWord;
    }

    public void setIndexedObliteratedWord(String[] indexedObliteratedWord) {
        this.indexedObliteratedWord = indexedObliteratedWord;
    }
}
