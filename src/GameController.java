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
	private Player currentPlayer;
	private boolean firstCardSet = false;
	private boolean pairs = false;
	
	private Card firstCard ;
	private Card secondCard;
	
	
	
	public GameController(GameField gameField)
	{
		this.gameField = gameField;
		
		for(int i=0; i<gameField.aList.size();i++)
		{
			gameField.aList.get(i).addObserver(this);
		}
		
		Player currentPlayer = new Player();
		currentPlayer = firstPlayer;
	}
	
	

	
	
	public void playGame(Card selectedCard)
	{
		if(firstCardSet == false)
		{
			firstCard = selectedCard;
			firstCardSet = true;
		}
		else if (firstCardSet == true)
		{
			secondCard = selectedCard;
            firstCardSet = false;

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
			
			try
			{
		        Thread.sleep(2000);
		    }
		    catch(Exception e){}
		   
			firstCard.button.setIcon(firstCard.getImage());
			secondCard.button.setIcon(secondCard.getImage());
			
			currentPlayer = switchPlayer(currentPlayer);
		}
	}
	
	
	public Player switchPlayer(Player currentPlayer)
	{
	   if (currentPlayer.equals(firstPlayer))
        {
            return secondPlayer;
        }
        else
        {
            return firstPlayer;
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
