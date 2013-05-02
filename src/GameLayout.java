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


public class GameLayout extends JPanel{
	
	JPanel gameField;
	JPanel dates;
	JPanel top;
	JPanel bottom;
	JPanel center;
	WindowModel wModel;
	Image image;
	DisplayCanvas disPic;
	//JLayeredPane dates;
	
	public GameLayout(WindowModel wModel)
	{
		this.wModel = wModel;
		createLayout();	
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
        
        JLabel l1 = new JLabel("Spieler 1");
        JLabel points1 = new JLabel ("points");
        JLabel l2 = new JLabel("Spieler 2");
        JLabel points2 = new JLabel ("points");
        
        JButton b1 = new JButton("Menue");
        JButton b2 = new JButton("Beenden");
        JButton b3 = new JButton("Pause");
       
        
        demo.addComponent( background, gbl, l1, 0, 2, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, points1, 0, 3, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, l2, 0, 4, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, points2, 0, 5, 1, 1, 1.0, 1.0 );
        demo.addComponent( background, gbl, b1, 2, 6, 1, 1, 0.0, 0.0 );
		demo.addComponent( background, gbl, b2, 2, 7, 1, 1, 0.0, 0.0 );
		demo.addComponent( background, gbl, b3, 2, 8, 1, 1, 0.0, 0.0 );
		
		wModel.panel.add(dates, BorderLayout.EAST);
						
    }

	
	public void addButton(JButton button)
	{
		gameField.add(button);
	}
	
	
}
