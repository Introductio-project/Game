import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Option extends JPanel {
    File directory = new File("");
    String directoryFile = directory.getCanonicalPath();

    String fullDirectoryStartIconB = directoryFile + "\\src\\img\\mainMenu\\startButtonB.png";
    String fullDirectoryStartIconA = directoryFile + "\\src\\img\\mainMenu\\startButtonA.png";

    BufferedImage startIconA = ImageIO.read(new File(fullDirectoryStartIconA));
    BufferedImage startIconB = ImageIO.read(new File(fullDirectoryStartIconB));

    CustomButton customButton = new CustomButton();
    ButtonCreator StartButton = new ButtonCreator(customButton,startIconA,startIconB,"Start",300,60);

    public Option() throws IOException {
        add(StartButton);

    }

}
