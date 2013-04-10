import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;


public class Card{
	
	JButton button;
	ImageIcon image;
	
	public Card(String name)
	{
		
    	button = new JButton();
		button.setIcon(new ImageIcon(name));
		
		button.setBackground(Color.GRAY);
		button.setPreferredSize(new Dimension(128,128));
		
		//border = new LineBorder(Color.black,3, false);
		
	}
	
	
	public JButton getButton()
	{
		return button;
	}
	

}
	


