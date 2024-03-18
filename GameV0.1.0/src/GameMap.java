import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameMap extends JPanel implements KeyListener, ActionListener {

    boolean isStarted = false;
    boolean isFailed = false;

    int[] mapX = new int[200];
    int[] mapY = new int[200];

    int[] roomX = new int[50];
    int[] roomY = new int[50];

    int rX = 100;
    int rY = 100;

    int iX = 0;
    int iY = 0;

    int ret = 0;

    int test1 = 10;

    String direction = "R";
    int time = 1000;

    Timer timer = new Timer(time,this);

    ImageIcon title = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\mainMenu\\background2.png");
    ImageIcon player = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\game\\player.png");
    ImageIcon room = new ImageIcon("C:\\Users\\User\\IdeaProjects 1\\GameV0.5\\src\\img\\game\\food.png");

    public GameMap(int i) {
    }

    public int GameMap(int ret) {
        this.setFocusable(true);
        this.addKeyListener(this);
        setup();
        timer.start();

        if (time == 10) {

        }

        return ret;
    }

    public void paint(Graphics g) {
        this.setBackground(Color.BLACK);
        title.paintIcon(this,g,0,0);
        g.fillRect(0,0,500,500);

        player.paintIcon(this, g, iX,iY);

        if(!isStarted){
            g.setColor(Color.WHITE);
        }

        room.paintIcon(this,g,rX,rY);
        repaint();
    }

    public void setup() {
        isStarted = false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        int i = 1;

        mapX[0] = mapX[0] + 25;

        if (isStarted && !isFailed) {
            mapX[0] = mapX[0];
            mapY[0] = mapY[0];
        }

        if (iX == rX && iY == iX) {
            ret = ret+1;

            BattleField battleField = new BattleField(); //DELETE


            JFrame frame = new JFrame();
            frame.setUndecorated(true);
            frame.setBounds(10,10,800,800);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLayout(null);
            battleField.setBounds(0,0,800,800);
            frame.add(battleField);
            frame.setVisible(true);
            new BattleField();
            i=i+1;
            timer.stop();
            int r = 1;
        }


        if (i == 1) {
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int KeyCode = keyEvent.getKeyCode();

        if (KeyCode == KeyEvent.VK_SPACE) {
            if (isFailed) {
                setup();
            } else
                isStarted = !isStarted;
        }

        if (KeyCode == KeyEvent.VK_UP)
            iY = iY - 25;
        direction = "U";
        if (KeyCode == KeyEvent.VK_DOWN)
            iY = iY + 25;
        direction = "D";
        if (KeyCode == KeyEvent.VK_RIGHT)
            iX = iX + 25;
        direction = "R";
        if (KeyCode == KeyEvent.VK_LEFT)
            iX = iX - 25;
        direction = "L";

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
