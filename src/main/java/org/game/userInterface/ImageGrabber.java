package org.game.userInterface;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageGrabber {
    final Logger logger = Logger.getLogger(ImageGrabber.class.getName());


    private Image image;

    public void setStartImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/startImage.jpg");
            this.image = new Image(input);
        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setFirstImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/firstImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setSecondImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/secondImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setThirdImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/thirdImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setFourthImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/fourthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setFifthImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/fifthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setSixthImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/sixthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setSeventhImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/seventhImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setEighthImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/eighthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setNinthImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/ninthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setTenthImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/tenthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setEleventhImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/eleventhImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setTwelveImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/twelfthImage.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public void setWinImage() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/images/winScreen.jpg");
            this.image = new Image(input);

        }catch (IOException e) {
            logger.log(Level.INFO, "IOException got thrown in ImageGrabber.");
        }
    }

    public Image getImage() {
        return image;
    }
}
