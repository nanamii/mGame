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
import java.util.Observable;
import java.lang.*;


public class Card extends Observable implements ActionListener, Comparable {
    
    private JButton button;
    private ImageIcon image_front;
    private ImageIcon image_back;
    private String name;
    
    
    public Card(String name)
    {
        this.name = name;
       
        image_front = new ImageIcon(name);
        image_back = new ImageIcon("../gfx/back.png");
        
        button = new JButton();
        button.setIcon(image_back);
        button.setBackground(Color.GRAY);
        button.setPreferredSize(new Dimension(128,128));
        button.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent e) 
    {
        button.setIcon(image_front);
        button.setBackground(Color.WHITE); 
        
        informController();   
    }
    
    
    public void informController()
    {
        setChanged();
        notifyObservers(this);
    }
    
    
    public void turnCard()
    {
        button.setIcon(image_front);
        button.setBackground(Color.WHITE);
    }
    
    
    public ImageIcon getImage()
    {
        return image_back;
    }
    
    
    public JButton getButton()
    {
        return button;
    }
    
    
    public int compareTo(Object o1) 
     {
     
        if (this.name.equals(((Card)o1).name) && this != o1)
            return 0;
        else if (this.name.equals(((Card)o1).name)==false)
            return 1;
        else
            return -1;
    }
}
