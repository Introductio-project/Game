import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// ===========================================
// Class CustomButton
// ===========================================
public class CustomButton extends Applet
{


  public CustomButton() throws IOException {
  }

  // ===========================================
  // init
  // ===========================================
  public void init()
  {

  }
  
  // ===========================================
  // getAppletInfo
  // ===========================================
  public String getAppletInfo()
  {
    return "Name: Custom Button";
  }
  
  // ===========================================
  // doButtonAction
  // ===========================================
  public void doButtonAction(ButtonCreator btn)
  {

    repaint();
  }
  public void doButtonAction2(BattleFieldTest btn)
  {

    repaint();
  }
}

