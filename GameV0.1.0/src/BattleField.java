import javax.swing.*;
import java.awt.*;

public class BattleField extends JPanel {

    ImageIcon fight = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\game\\fight.png");
    ImageIcon player = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\game\\player.png");

    public BattleField() {
    }


    public void paint(Graphics g) {

        fight.paintIcon(this,g,10,10);
        g.fillRect(0,0,800,800);
        player.paintIcon(this,g,10,10);

    }

}
