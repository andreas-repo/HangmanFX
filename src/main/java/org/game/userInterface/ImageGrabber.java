package org.game.userInterface;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageGrabber {
    final Logger logger = Logger.getLogger(ImageGrabber.class.getName());


    private ImageView image;

    public void setStartImage() {
        try {
            FileInputStream input = new FileInputStream("C:\\Users\\andre\\Development\\Example Code\\HangmanFX\\src\\main\\resources\\startImage.jpg");
            Image image = new Image(input);
            this.image = new ImageView(image);
        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setSecondImage() {
        try {
            FileInputStream input = new FileInputStream("C:\\Users\\andre\\Development\\Example Code\\HangmanFX\\src\\main\\resources\\secondImage.jpg");
            Image image = new Image(input);
            this.image = new ImageView(image);
        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public ImageView getImage() {
        return image;
    }
}
