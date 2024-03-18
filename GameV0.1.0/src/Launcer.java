
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

class Launcher extends JFrame implements Setup {

    public Launcher() throws IOException {

        boolean b1 = true;
        boolean b2 = false;

        JButton launch = new JButton("Launch");
        launch.setPreferredSize(new Dimension(150, 40));

        String[] resolutionItems = {
                "1280x720 ",
                "1920x1080 ",
                "2560x1440 "
        };
        String[] fullSizeItems = {
                "OFF",
                "ON",
        };
        String[] languageItems = {
                "EN",
                "RU",
                "UK"
        };

        File directory = new File("");
        String directoryFile = directory.getCanonicalPath();
        String fullDirectoryFile = directoryFile + "\\src\\img\\launcher\\launcher.png";
        String fullDirectoryConfigFile = directoryFile + "\\src\\Config.txt";
        Icon icon = new ImageIcon(fullDirectoryFile);

        JLabel labelIcon = new JLabel(icon);
        JLabel labelResolution = new JLabel("Resolution: ");
        JLabel labelFullSize = new JLabel("FullSize: ");
        JLabel labelLanguage = new JLabel("Language: ");

        Container container = getContentPane();
        JPanel jpanel1 = new JPanel();
        JPanel jpanel2 = new JPanel();
        JPanel jpanel3 = new JPanel();
        JPanel jpanel4 = new JPanel();

        JComboBox comboBox1 = new JComboBox(resolutionItems);
        JComboBox comboBox2 = new JComboBox(fullSizeItems);
        JComboBox comboBox3 = new JComboBox(languageItems);

        GridLayout gridLayout = new GridLayout(3,2);

        jpanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 100));

        jpanel1.add(labelIcon);

        jpanel2.setLayout(gridLayout);
        jpanel2.add(labelResolution);
        jpanel2.add(comboBox1);
        jpanel2.add(labelFullSize);
        jpanel2.add(comboBox2);
        jpanel2.add(labelLanguage);
        jpanel2.add(comboBox3);

        jpanel3.add(launch);

        jpanel4.add(jpanel2,BorderLayout.CENTER);
        jpanel4.add(jpanel3,BorderLayout.SOUTH);

        container.add(jpanel1, BorderLayout.CENTER);
        container.add(jpanel4, BorderLayout.SOUTH);


        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String s1 = comboBox1.getSelectedItem().toString();
                String s2 = comboBox2.getSelectedItem().toString();
                String s3 = comboBox3.getSelectedItem().toString();

                String fileData = "Language: "+s3+" FullSize: "+s2+" Resolution: "+s1;
                File f = new File(fullDirectoryConfigFile);

                FileOutputStream fos = null;

                try {
                    fos = new FileOutputStream(fullDirectoryConfigFile);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                try {
                    fos.write(fileData.getBytes());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    new MainMenu();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        };

        launch.addActionListener(actionListener);

        setBounds(10, 10, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }



}