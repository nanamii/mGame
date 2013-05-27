import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.net.URL;
import java.io.IOException;
import java.util.Observer;
import java.util.Observable;

public class GameLayout extends JPanel implements Observer{
	
	JPanel gameField;
	JPanel dates;
	JPanel top;
	JPanel bottom;
	JPanel center;
	WindowModel wModel;
	Image image;
	DisplayCanvas disPic;
	
	JLabel points1;
	JLabel points2;
	JLabel l1;
	JLabel l2;
	
	String name1;
	String name2;
	
	public GameLayout(WindowModel wModel, String name1, String name2)
	{
		this.wModel = wModel;
		createLayout();	
		this.name1 = name1;
		this.name2 = name2;
	}
	
	
	public void createLayout()
	{
		top = new JPanel();
		//top.setPreferredSize(new Dimension(5,800));
		wModel.panel.add(top, BorderLayout.NORTH);
		top.setLayout(new BorderLayout(0, 0));
		
		bottom = new JPanel();
		//top.setPreferredSize(new Dimension(5,800));
		wModel.panel.add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new BorderLayout(0, 0));
		
		center = new JPanel();
		//top.setPreferredSize(new Dimension(5,800));
		wModel.panel.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout(0, 0));
		
		// Spielfeld
		gameField = new JPanel();
		gameField.setPreferredSize(new Dimension(550,800));
		wModel.panel.add(gameField, BorderLayout.WEST);
		gameField.setLayout(new GridLayout(4,4,5,5));
		
		
		
		/*************************************************************
		Sidebar
		**************************************************************/
		
		/*dates.setPreferredSize(new Dimension(250,800));
		wModel.panel.add(dates, BorderLayout.EAST);
		dates.setLayout(new GridLayout(5,2,0,0));
		
		disPic = new DisplayCanvas();
		//dates.add(disPic);
		
		dates.add(new JButton ("halli"));
		dates.setBackground(disPic);
		*/
		
		dates = new JPanel();
		dates.setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("../gfx/datesBack.png"));
        dates.add(background);
        
        GridBagLayoutDemo demo = new GridBagLayoutDemo();
        GridBagLayout gbl = new GridBagLayout();
        background.setLayout(gbl);
        
        l1 = new JLabel(new ImageIcon("../gfx/spieler1.png"));
        points1 = new JLabel ("points");
        l2 = new JLabel(new ImageIcon("../gfx/spieler2.png"));
        points2 = new JLabel ("points");
        
        JButton b1 = new JButton("Menue");
        JButton b2 = new JButton("Beenden");
        //JButton b3 = new JButton("Pause");
       
        
        demo.addComponent( background, gbl, l1, 0, 2, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, points1, 0, 3, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, l2, 0, 4, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, points2, 0, 5, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, b1, 2, 6, 1, 1, 0.0, 0.0 );
		demo.addComponent( background, gbl, b2, 2, 7, 1, 1, 0.0, 0.0 );
		//demo.addComponent( background, gbl, b3, 2, 8, 1, 1, 0.0, 0.0 );
		
		wModel.panel.add(dates, BorderLayout.EAST);
						
    }

	
	public void addButton(JButton button)
	{
		gameField.add(button);
	}
	
	 @Override 
	 public void update( Observable o, Object arg ) 
  	{ 
  		if(arg instanceof Player)
  		{
  		    Player player = (Player)arg;
  		    int points = player.getPoints();
  		    System.out.println("Spieler" + player.getNum() + "an der Reihe");
  		    if(player.getNum()==1)
  		    {   
  		        System.out.println("Spieler1 punkte++");
  		        points1.setText("Punkte: "+points);
  		    }
  		    else if (player.getNum()==2)
  		    {
  		        System.out.println("Spieler2 punkte++");
  		        points2.setText("Punkte: "+points);
  		    }
  		}
  		else
  		{
  		    GameController controller = (GameController)arg;
  		    if(controller.getPlayer().getNum()==1)
  		    {
  		        ImageIcon image = new ImageIcon("../gfx/spieler1_play.png");
  		        l1.setIcon(image);
  		        ImageIcon imageOld = new ImageIcon("../gfx/spieler2.png");
  		        l2.setIcon(imageOld);
  		        System.out.println("spieler gewechselt");
  		    }
  		    else
  		    {
  		        ImageIcon imageI = new ImageIcon("../gfx/spieler2_play.png");
  		        l2.setIcon(imageI);
  		        ImageIcon imageOldI = new ImageIcon("../gfx/spieler1.png");
  		        l1.setIcon(imageOldI);
  		    }
  		}
 	} 
}
