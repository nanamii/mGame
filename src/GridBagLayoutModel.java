import java.awt.*;
import javax.swing.*;

class GridBagLayoutModel
{


  static void addComponent( Container cont,
                            GridBagLayout gbl,
                            Component c,
                            int x, int y,
                            int width, int height,
                            double weightx, double weighty )
  {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = x; gbc.gridy = y;
    gbc.gridwidth = width; gbc.gridheight = height;
    gbc.weightx = weightx; gbc.weighty = weighty;
    gbl.setConstraints( c, gbc );
    cont.add( c );
  }
}
