import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;


public class DisplayCanvas extends Canvas{
	
	Image image;
	
	public DisplayCanvas()
	{
		image = Toolkit.getDefaultToolkit().getImage("../gfx/datesBack2.png");
		
	}
	
	public void paint(Graphics g) 
	{
    	Graphics2D g2D = (Graphics2D) g;
    	g2D.drawImage(image, 0, 0, null);
	}
}
