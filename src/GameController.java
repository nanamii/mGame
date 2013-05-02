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
import java.lang.Thread;
import java.util.Scanner;


public class GameController implements Observer{
	
	private GameField gameField;
	
	private Player firstPlayer;
	private Player secondPlayer;
	private int counter = 0;
	
	private Card firstCard ;
	private Card secondCard;
	
	
	
	public GameController(GameField gameField)
	{
		this.gameField = gameField;
		
		for(int i=0; i<gameField.aList.size();i++)
		{
			gameField.aList.get(i).addObserver(this);
		}
	}
	
	
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
			System.out.println("Counter von 1 auf 2 hochgesetzt");
			secondCard = selectedCard;
			//secondCard.button.revalidate();
            counter = 0;

            Thread queryThread = new Thread() 
            {
                public void run() 
                {
                    compareCards();
                }
            };
            queryThread.start();	
		}
	}
	
	
	public void compareCards()
	{
	    if(firstCard.compareTo(secondCard) == 0)
		{
			
			try
			{
		        Thread.sleep(1000);
		    }
		    catch(Exception e){}
			
			firstCard.button.setVisible(false);
			secondCard.button.setVisible(false);
		}
		
		else
		{	
			//System.out.println("compareCards else-Teil");
			
			try
			{
		        Thread.sleep(2000);
		    }
		    catch(Exception e){}
		   
			firstCard.button.setIcon(firstCard.getImage());
			secondCard.button.setIcon(secondCard.getImage());
		}
	}
	
	
	 @Override 
	 public void update( Observable o, Object arg ) 
  	{ 
  		Card temp = (Card)arg;
  		//System.out.println("im GameController gelandet, karte"+temp.name);
    	//System.out.println(temp.button.getIcon());
    	
    	playGame(temp);
 	} 
	
}
