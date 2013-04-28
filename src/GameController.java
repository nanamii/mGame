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

public class GameController{
	
	private Player firstPlayer;
	private Player secondPlayer;
	private int counter = 0;
	
	private Card firstCard;
	private Card secondCard;
	
	
	public GameController(Player first, Player second)
	{
		this.firstPlayer = first;
		this.secondPlayer = second;
	}
	
	public GameController()
	{}
	
	public void playGame(Card selectedCard)
	{
		if(counter == 0)
		{
			counter++;
			System.out.println("Counter von 0 auf 1 hochgesetzt");
			firstCard = selectedCard;
		}
		else if (counter == 1)
		{
			secondCard = selectedCard;
			compareCards();
			counter = 0;
		}
	}
	
	public void compareCards()
	{
		if(firstCard.image_front.equals(secondCard.image_front))
		{
			firstCard.button.setVisible(false);
			secondCard.button.setVisible(false);
		}
		else
		{
			firstCard.button.setIcon(firstCard.getImage());
			secondCard.button.setIcon(secondCard.getImage());
		}
	}
	
	
	
	
	
}
