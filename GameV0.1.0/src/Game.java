import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JFrame implements KeyListener , ActionListener {
    GameMap gameMap = new GameMap(0);
    int result = gameMap.GameMap(0);
    Timer timer = new Timer(1000,this);


    public Game(int resolutionWidth, int resolutionHeight, int max) throws IOException {


        CustomButton customButton = new CustomButton() ;



        this.setFocusable(true);
        this.addKeyListener(this);

        JFrame frame = new JFrame();
        frame.setUndecorated(false);

        if(max == 1) {
            frame.setExtendedState(MAXIMIZED_BOTH);
        } else {
            frame.setBounds(10,10,resolutionWidth,resolutionHeight);
        }
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jpanelMap = new JPanel();


        JButton button = new JButton("button");
        button.setSize(100,100);

        GridLayout grid = new GridLayout(1,0);

        ImageCreator imageCreator = new ImageCreator();
        imageCreator.setName("game","BattleField");
        Image battlefield = imageCreator.getBufferedImage();

        //TEST

        File directory = new File("");
        String directoryFile = directory.getCanonicalPath();

        String fullDirectoryConfigFile = directoryFile + "\\src\\Config.txt";
        File f = new File(fullDirectoryConfigFile);
        String fullDirectoryMainMenuFile = directoryFile+"\\src\\RunnableMainMenu.txt";
        File f2 = new File(fullDirectoryMainMenuFile);

        String fullDirectoryStartIconB = directoryFile + "\\src\\img\\mainMenu\\startButtonB.png";
        String fullDirectoryStartIconA = directoryFile + "\\src\\img\\mainMenu\\startButtonA.png";

        BufferedImage startIconA = ImageIO.read(new File(fullDirectoryStartIconA));
        BufferedImage startIconB = ImageIO.read(new File(fullDirectoryStartIconB));

        ButtonCreator StartButton = new ButtonCreator(customButton, startIconA, startIconB, "Start", 300, 60);

        frame.add(StartButton);

        JPanel jPanelTest = new JPanel();

        BattleFieldTest battleFieldTest = new BattleFieldTest(customButton, battlefield, "Gallery", 300, 300);





        jPanelTest.add(StartButton);

        frame.add(jPanelTest);





        //TEST





        jpanelMap.add(gameMap);
        jpanelMap.setLayout(grid);


        JPanel panelMain = new JPanel();

        panelMain.add(jpanelMap);



        frame.add(panelMain);

        frame.setVisible(true);
        new GameMap(0);
        timer.start();

        System.out.println(result);
    }



    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int KeyCode = keyEvent.getKeyCode();

        if (KeyCode == KeyEvent.VK_UP)
            System.out.println(result);
        if (KeyCode == KeyEvent.VK_DOWN)
            System.out.println(result);
        if (KeyCode == KeyEvent.VK_RIGHT)
            System.out.println(result);
        if (KeyCode == KeyEvent.VK_LEFT)
            System.out.println(result);

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        repaint();
    }
}
