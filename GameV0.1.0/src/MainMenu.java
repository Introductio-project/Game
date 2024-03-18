import com.sun.jdi.Value;

import javax.imageio.ImageIO;
import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainMenu extends JFrame implements Setup {

    final ArrayList<Integer> arrayListResolution = new ArrayList();

    File directory = new File("");
    String directoryFile = directory.getCanonicalPath();

    String fullDirectoryConfigFile = directoryFile + "\\src\\Config.txt";
    File f = new File(fullDirectoryConfigFile);
    String fullDirectoryMainMenuFile = directoryFile+"\\src\\RunnableMainMenu.txt";
    File f2 = new File(fullDirectoryMainMenuFile);

    String fullDirectoryStartIconB = directoryFile + "\\src\\img\\mainMenu\\startButtonB.png";
    String fullDirectoryStartIconA = directoryFile + "\\src\\img\\mainMenu\\startButtonA.png";
    String fullDirectoryOptionIconB = directoryFile + "\\src\\img\\mainMenu\\optionButtonB.png";
    String fullDirectoryOptionIconA = directoryFile + "\\src\\img\\mainMenu\\optionButtonA.png";
    String fullDirectoryGalleryIconB = directoryFile + "\\src\\img\\mainMenu\\galleryButtonB.png";
    String fullDirectoryGalleryIconA = directoryFile + "\\src\\img\\mainMenu\\galleryButtonA.png";
    String fullDirectoryExitIconB = directoryFile + "\\src\\img\\mainMenu\\exitButtonB.png";
    String fullDirectoryExitIconA = directoryFile + "\\src\\img\\mainMenu\\exitButtonA.png";

    String fullDirectoryResolutionIconA = directoryFile + "\\src\\img\\mainMenu\\resolutionButtonA.png";
    String fullDirectoryResolutionIconB = directoryFile + "\\src\\img\\mainMenu\\resolutionButtonB.png";
    String fullDirectory1280x720IconA = directoryFile + "\\src\\img\\mainMenu\\1280x720ButtonA.png";
    String fullDirectory1280x720IconB = directoryFile + "\\src\\img\\mainMenu\\1280x720ButtonB.png";
    String fullDirectory1920x1080IconA = directoryFile + "\\src\\img\\mainMenu\\1920x1080ButtonA.png";
    String fullDirectory1920x1080IconB = directoryFile + "\\src\\img\\mainMenu\\1920x1080ButtonB.png";
    String fullDirector2560x1440IconA = directoryFile + "\\src\\img\\mainMenu\\2560x1440ButtonA.png";
    String fullDirectory2560x1440IconB = directoryFile + "\\src\\img\\mainMenu\\2560x1440ButtonB.png";

    String fullDirectoryLanguageIconA = directoryFile + "\\src\\img\\mainMenu\\languageButtonA.png";
    String fullDirectoryLanguageIconB = directoryFile + "\\src\\img\\mainMenu\\languageButtonB.png";
    String fullDirectoryONIconA = directoryFile + "\\src\\img\\mainMenu\\onButtonA.png";
    String fullDirectoryONIconB = directoryFile + "\\src\\img\\mainMenu\\onButtonB.png";
    String fullDirectoryOFFIconA = directoryFile + "\\src\\img\\mainMenu\\offButtonA.png";
    String fullDirectoryOFFIconB = directoryFile + "\\src\\img\\mainMenu\\offButtonB.png";
    String fullDirectoryFullSizeIconA = directoryFile + "\\src\\img\\mainMenu\\fullSizeButtonA.png";
    String fullDirectoryFullSizeIconB = directoryFile + "\\src\\img\\mainMenu\\fullSizeButtonB.png";


    BufferedImage startIconA = ImageIO.read(new File(fullDirectoryStartIconA));
    BufferedImage startIconB = ImageIO.read(new File(fullDirectoryStartIconB));
    BufferedImage optionIconA = ImageIO.read(new File(fullDirectoryOptionIconA));
    BufferedImage optionIconB = ImageIO.read(new File(fullDirectoryOptionIconB));
    BufferedImage galleryIconA = ImageIO.read(new File(fullDirectoryGalleryIconA));
    BufferedImage galleryIconB = ImageIO.read(new File(fullDirectoryGalleryIconB));
    BufferedImage exitIconA = ImageIO.read(new File(fullDirectoryExitIconA));
    BufferedImage exitIconB = ImageIO.read(new File(fullDirectoryExitIconB));

    BufferedImage resolutionIconA = ImageIO.read(new File(fullDirectoryResolutionIconA));
    BufferedImage resolutionIconB = ImageIO.read(new File(fullDirectoryResolutionIconB));
    BufferedImage Icon1280x720A = ImageIO.read(new File(fullDirectory1280x720IconA));
    BufferedImage Icon1280x720B = ImageIO.read(new File(fullDirectory1280x720IconB));
    BufferedImage Icon1920x1080A = ImageIO.read(new File(fullDirectory1920x1080IconA));
    BufferedImage Icon1920x1080B = ImageIO.read(new File(fullDirectory1920x1080IconB));
    BufferedImage Icon2560x1440A = ImageIO.read(new File(fullDirector2560x1440IconA));
    BufferedImage Icon2560x1440B = ImageIO.read(new File(fullDirectory2560x1440IconB));

    BufferedImage LanguageIconA = ImageIO.read(new File(fullDirectoryLanguageIconA));
    BufferedImage LanguageIconB = ImageIO.read(new File(fullDirectoryLanguageIconB));
    BufferedImage ONIconA = ImageIO.read(new File(fullDirectoryONIconA));
    BufferedImage ONIconB = ImageIO.read(new File(fullDirectoryONIconB));
    BufferedImage OFFIconA = ImageIO.read(new File(fullDirectoryOFFIconA));
    BufferedImage OFFIconB = ImageIO.read(new File(fullDirectoryOFFIconB));
    BufferedImage fullSizeIconA = ImageIO.read(new File(fullDirectoryFullSizeIconA));
    BufferedImage fullSizeIconB = ImageIO.read(new File(fullDirectoryFullSizeIconB));


    Bak bak = new Bak();

    Container container = getContentPane();
    FileOutputStream fos = null;


    public MainMenu() throws IOException {
        arrayListResolution.add(null);
        arrayListResolution.add(null);
        arrayListResolution.add(0);

        setUndecorated(true);


        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {


            fos = new FileOutputStream(fullDirectoryMainMenuFile);

            String mainMenuFileData = "----";
            fos.write(mainMenuFileData.getBytes());

            String value = reader.readLine();

            ArrayList<String> arrayListConfigResult = new ArrayList<>();
            ArrayList<String> arrayListConfig = new ArrayList<String>();
            arrayListConfig.add("Language");
            arrayListConfig.add("FullSize");
            arrayListConfig.add("Resolution");

            for (int i = 0; i < 3; i++) {
                String s = arrayListConfig.get(i);
                int in1 = value.indexOf(s);
                int in2 = value.indexOf(" ", in1);
                int in3 = in2 + 1;
                int in4 = value.indexOf(" ", in3);
                String result = value.substring(in3, in4);
                arrayListConfigResult.add(i, result);
            }

            String language = arrayListConfigResult.get(0);
            String fullSize = arrayListConfigResult.get(1);
            String resolution = arrayListConfigResult.get(2);

            if (fullSize.equals("ON")) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                System.out.println("resolution");
            } else {
                System.out.println("resolutionelse");
            }

            if (resolution.equals("1280x720")) {
                setBounds(0, 0, 1280, 720);
                arrayListResolution.set(0,1280);
                arrayListResolution.set(1,720);
            }
            if (resolution.equals("1920x1080")) {
                setBounds(0, 0, 1920, 1080);
                arrayListResolution.set(0,1920);
                arrayListResolution.set(1,1080);
            }
            if (resolution.equals("2560x1440")) {
                setBounds(0, 0, 2560, 1440);
                arrayListResolution.set(0,2560);
                arrayListResolution.set(1,1440);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        JPanel jpanel1 = new JPanel();
        JPanel jpanel2 = new JPanel();


        getContentPane().add(bak);


        jpanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        CustomButton customButton = new CustomButton();
        ButtonCreator StartButton = new ButtonCreator(customButton, startIconA, startIconB, "Start", 300, 60);
        ButtonCreator OptionButton = new ButtonCreator(customButton, optionIconA, optionIconB, "Option", 300, 60);
        ButtonCreator GalleryButton = new ButtonCreator(customButton, galleryIconA, galleryIconB, "Gallery", 300, 60);
        ButtonCreator ExitButton = new ButtonCreator(customButton, exitIconA, exitIconB, "Exit", 300, 60);

        ButtonCreator resolutionButton = new ButtonCreator(customButton, resolutionIconA, resolutionIconB, "Resolution", 150, 30);
        ButtonCreator button1280x720 = new ButtonCreator(customButton, Icon1280x720A, Icon1280x720B, "1280x720", 150, 30);
        ButtonCreator button1920x1080 = new ButtonCreator(customButton, Icon1920x1080A, Icon1920x1080B, "1920x1080", 150, 30);
        ButtonCreator button2560x1440 = new ButtonCreator(customButton, Icon2560x1440A,Icon2560x1440B, "2560x1440", 150, 30);

        ButtonCreator languageButton = new ButtonCreator(customButton, LanguageIconA, LanguageIconB, "Language", 150, 30);
        ButtonCreator ONButton = new ButtonCreator(customButton, ONIconA, ONIconB, "ON", 50, 30);
        ButtonCreator OFFButton = new ButtonCreator(customButton, OFFIconA, OFFIconB, "OFF", 50, 30);
        ButtonCreator fullSizeButton = new ButtonCreator(customButton, fullSizeIconA,fullSizeIconB, "FullSize", 150, 30);


        jpanel2.add(StartButton);
        jpanel2.add(OptionButton);
        jpanel2.add(GalleryButton);
        jpanel2.add(ExitButton);
        jpanel2.setBackground(Color.black);

        JPanel jpanelOption = new JPanel();
        jpanelOption.add(resolutionButton);
        jpanelOption.add(button1280x720);
        jpanelOption.add(button1920x1080);
        jpanelOption.add(button2560x1440);

        jpanelOption.add(fullSizeButton);
        jpanelOption.add(ONButton);
        jpanelOption.add(OFFButton);
        jpanelOption.add(languageButton);


        jpanelOption.setBackground(Color.darkGray);
        jpanelOption.setVisible(false);
        container.add(jpanelOption, BorderLayout.NORTH);


        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {

                try (BufferedReader reader2 = new BufferedReader(new FileReader(f2))){
                    String value2 = reader2.readLine();

                    System.out.println(value2+"erefrergf");
                    if(value2.equals("Start")) {
                        jpanelOption.setVisible(false);
                        setVisible(false);
                        new Game(arrayListResolution.get(0),arrayListResolution.get(1),arrayListResolution.get(2));
                        timer.cancel();
                    }
                    if(value2.equals("Option")) {
                        jpanelOption.setVisible(true);
                    }
                    if(value2.equals("Gallery")) {
                    }
                    if(value2.equals("Exit")) {
                        System.exit(0);
                    }
                    if(value2.equals("Resolution")) {
                    }
                    if(value2.equals("1280x720")) {
                        setBounds(0,0,1280,720);
                        arrayListResolution.set(0,1280);
                        arrayListResolution.set(1,720);
                    }
                    if(value2.equals("1920x1080")) {
                        setBounds(0,0,1920,1080);
                        arrayListResolution.set(0,1920);
                        arrayListResolution.set(1,1080);
                    }
                    if(value2.equals("2560x1440")) {
                        setBounds(0,0,2560,1440);
                        arrayListResolution.set(0,2560);
                        arrayListResolution.set(1,1440);
                    }
                    if(value2.equals("ON")) {
                        setExtendedState(JFrame.MAXIMIZED_BOTH);
                        arrayListResolution.set(2,1);
                    }
                    if(value2.equals("OFF")) {

                    }
                    if(value2.equals("FullSize")) {
                    }
                    if(value2.equals("Language")) {

                    }else {

                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String nullData = "null";
                try {
                    fos = new FileOutputStream(fullDirectoryMainMenuFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(nullData.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Timer");
            }
                       },0,100);




        GridLayout gridLayout = new GridLayout(4, 1, 10, 10);

        jpanel2.setLayout(gridLayout);

        jpanel1.setBackground(Color.darkGray);
        jpanel1.add(jpanel2);

        container.add(jpanel1, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        System.out.println("rt");

        repaint();
    }



}

