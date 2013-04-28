import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;


public class Card implements ActionListener{
	
	JButton button;
	ImageIcon image_front;
	ImageIcon image_back;
	GameController game;
	
	public Card(String name)
	{
		
    	button = new JButton();
    	image_front = new ImageIcon(name);
    	image_back = new ImageIcon();
		button.setIcon(image_back);
		
		button.setBackground(Color.GRAY);
		button.setPreferredSize(new Dimension(128,128));
		
		button.addActionListener(this);
		
		//border = new LineBorder(Color.black,3, false);
		
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
         button.setIcon(image_front);
         button.setBackground(Color.WHITE);
         game = new GameController();
         game.playGame(this);
         
        
	}
	
	
	public ImageIcon getImage()
	{
		return image_back;
	}
	
	
	public JButton getButton()
	{
		return button;
	}
	

}
	


