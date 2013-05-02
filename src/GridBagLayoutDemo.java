import java.awt.*;
import javax.swing.*;

class GridBagLayoutDemo
{


  static void addComponent( Container cont,
                            GridBagLayout gbl,
                            Component c,
                            int x, int y,
                            int width, int height,
                            double weightx, double weighty )
  {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = x; gbc.gridy = y;
    gbc.gridwidth = width; gbc.gridheight = height;
    gbc.weightx = weightx; gbc.weighty = weighty;
    gbl.setConstraints( c, gbc );
    cont.add( c );
  }
}
