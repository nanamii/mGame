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
		
		gameField = new JPanel();
		gameField.setPreferredSize(new Dimension(600,800));
		wModel.panel.add(gameField, BorderLayout.WEST);
		gameField.setLayout(new GridLayout(4,4,5,5));
		
		dates = new JPanel();
		dates.setPreferredSize(new Dimension(180,800));
		wModel.panel.add(dates, BorderLayout.EAST);
		dates.setLayout(new GridLayout(5,0,0,0));
		
		disPic = new DisplayCanvas();
		dates.add(disPic);
		
		dates.add(new JButton ("halli"));
		
		//image = new ImageIcon(this.getClass().getResource("../gfx/8.png")).getImage();
		//URL imgUrl = getClass().getClassLoader().getResource("/home/susi/github/mGame/gfx");
					
    }

	
	public void addButton(JButton button)
	{
		gameField.add(button);
	}
	
	
}
