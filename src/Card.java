import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;
import java.io.*;


public class Card{
	
	JButton button;
	ImageIcon image;
	
	public Card(String name)
	{
		button = new JButton(name);
		image = createImageIcon("8.png", "Image");
		button.setIcon(image);
		button.setPreferredSize(new Dimension(50,50));
		
		/*try 
		{
    		image = ImageIO.read(getClass().getResource("8.png"));
    		button.setIcon(new ImageIcon(image));
  		} 
  		catch (IOException ex) { }
		*/
	}
	
	
	public JButton getButton()
	{
		return button;
	}
	
	/*
	protected ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
    */
}
	

}
