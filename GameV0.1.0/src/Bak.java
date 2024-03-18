import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bak extends Component {

    File directory = new File("");
    String directoryFile = directory.getCanonicalPath();


    String fullDirectoryFile = directoryFile + "\\src\\img\\mainMenu\\MainMenuTitle.png";
    Icon mainMenuBackground = new ImageIcon(fullDirectoryFile);

    public Bak() throws IOException {
    }

    public void paint(Graphics g)
    {
        mainMenuBackground.paintIcon(this, g, 0, 0);
    }

}
