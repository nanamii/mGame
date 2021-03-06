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
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class GameLayout extends JPanel implements Observer{
	
	private JPanel gameField;
	private JPanel dates;
	private JPanel top;
	private JPanel bottom;
	private JPanel center;
	private WindowModel wModel;
	private Image image;
	
	private JLabel points1;
	private JLabel points1Num;
	private JLabel points2;
	private JLabel points2Num;
	private JLabel l1;
	private JLabel l2;
	
	private Player player1;
	private Player player2;
	
	public GameLayout(WindowModel wModel, Player player1, Player player2)
	{
		this.wModel = wModel;
		this.player1 = player1;
		this.player2 = player2;
		createLayout();	
	}
	
	
	public void createLayout()
	{
		top = new JPanel();
		wModel.panel.add(top, BorderLayout.NORTH);
		top.setLayout(new BorderLayout(0, 0));
		
		bottom = new JPanel();
		wModel.panel.add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new BorderLayout(0, 0));
		
		center = new JPanel();
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
		
		dates = new JPanel();
		dates.setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("../gfx/datesBack.png"));
        dates.add(background);
        
        GridBagLayoutModel gblModel = new GridBagLayoutModel();
        GridBagLayout gbl = new GridBagLayout();
        background.setLayout(gbl);
        
        l1 = new JLabel(new ImageIcon("../gfx/spieler1.png"));
        points1 = new JLabel (new ImageIcon("../gfx/punkte.png"));
        points1Num = new JLabel("0");
        l2 = new JLabel(new ImageIcon("../gfx/spieler2.png"));
        points2 = new JLabel (new ImageIcon("../gfx/punkte.png"));
        points2Num = new JLabel("0");
        
        JLabel namePlayer1 = new JLabel(player1.getName());
        JLabel namePlayer2 = new JLabel(player2.getName());
        
        JButton end = new JButton("Beenden");
       
        gblModel.addComponent( background, gbl, l1, 0, 2, 1, 1, 1.0, 0.5 );
        gblModel.addComponent( background, gbl, namePlayer1, 1, 2, 1, 1, 1.0, 0.5 );
        gblModel.addComponent( background, gbl, points1, 0, 3, 1, 1, 1.0, 0.2 );
        gblModel.addComponent( background, gbl, points1Num, 1, 3, 1, 1, 1.0, 0.2 );
        gblModel.addComponent( background, gbl, l2, 0, 4, 1, 1, 1.0, 1.0 );
        gblModel.addComponent( background, gbl, namePlayer2, 1, 4, 1, 1, 1.0, 1.0 );
        gblModel.addComponent( background, gbl, points2, 0, 5, 1, 1, 1.0, 0.2 );
        gblModel.addComponent( background, gbl, points2Num, 1, 5, 1, 1, 1.0, 0.2 );
		gblModel.addComponent( background, gbl, end, 1, 6, 1, 1, 0.0, 0.2 );
		
		wModel.panel.add(dates, BorderLayout.EAST);
		
		end.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {
            System.exit(0);
        }});
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
  		        points1Num.setText(""+points);
  		    }
  		    else if (player.getNum()==2)
  		    {
  		        System.out.println("Spieler2 punkte++");
  		        points2Num.setText(""+points);
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
 	public JPanel getGameFieldPanel()
 	{
 		return gameField;
 	} 
}
