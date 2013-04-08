import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Menue extends JPanel{

	Image bg;
	Dimension size;

	
	public Menue()
	{
		//this.loadMenue();	
		size = new Dimension();
		bg = new ImageIcon(this.getClass().getResource("menue.png")).getImage();
		size.width = bg.getWidth(null);
        size.height = bg.getHeight(null);
        setPreferredSize(size);	
	}
	
	public void loadMenue()
	{
		
		
		//wModel.panel.setBackground(Color.BLACK);
		
		
		//frame.addImageIcon(bg);
				
	}


    public void paint(Graphics g) {
    	Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bg, 0, 0, null); 
	}
	
}
