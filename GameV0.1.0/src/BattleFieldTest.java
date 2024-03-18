import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

class BattleFieldTest extends Canvas {
    Image imgButton;
    Image imgButtonDn;
    Container cont;
    int btnWidth;
    int btnHeight;
    Dimension dimMinSize;
    boolean bButtonUp = true;
    boolean bButtonEnter = true;

    String btnTitle;

    Image battleFieldFinish;

    public BattleFieldTest(Container parent,
                           Image img,
                           String btnTitle, int width, int height) throws IOException {

        ImageCreator imageCreator = new ImageCreator();

        imgButton = img;

        cont = parent;

        btnWidth  = width;
        btnHeight = height;
        this.btnTitle = btnTitle;

        imageCreator.setName("game","BattleField");
        Image battlefield = imageCreator.getBufferedImage();

        battleFieldFinish = battlefield;
    }


    public Dimension getPreferredSize()
    {
        return dimMinSize;
    }

    public Dimension getMinimumSize()
    {
        return dimMinSize;
    }

    public Dimension preferredSize()
    {
        return dimMinSize;
    }

    public Dimension minimumSize()
    {
        return dimMinSize;
    }

    public void paint(Graphics g) {

        FontMetrics fm = g.getFontMetrics();
        int nTitileWidth = fm.stringWidth(btnTitle);
        int nTitleHeight = fm.getAscent() -
                fm.getLeading() - fm.getDescent();

        int x0 = (btnWidth - nTitileWidth) / 2;
        int y0 = ((btnHeight - nTitleHeight) / 2) +
                nTitleHeight;

        g.drawImage(battleFieldFinish,0,0,this);

    }

    public boolean mouseDown(
            Event ev, int x, int y)
    {
        System.out.println("mouseDown");
        return true;
    }

    public boolean mouseEnter(
            Event ev, int x, int y)
    {
        bButtonUp = false;
        repaint();
        return true;
    }

    public boolean mouseExit(
            Event ev, int x, int y)
    {
        bButtonUp = true;
        repaint();
        return true;
    }

    public boolean mouseClick(Event ev,int x, int y) {
        return true;
    }

    public void run()
    {

    }

    public void doButtonAction()
    {
        ((CustomButton)cont).doButtonAction2(this);
    }


}
