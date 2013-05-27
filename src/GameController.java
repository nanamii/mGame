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
import java.util.LinkedList;


public class GameController extends Observable implements Observer{
	
	private GameField gameField;
	
	private Player firstPlayer; 
	private Player secondPlayer;
	private Player currentPlayer;
	
	private boolean firstCardSet = false;
	private boolean pairs = false;
	private int count = 0;
	
	private LinkedList <Card> list;
	
	
	public GameController(GameField gameField, GameLayout layout, String name1, String name2)
	{
		this.gameField = gameField;
		
		for(int i=0; i<gameField.aList.size();i++)
		{
			gameField.aList.get(i).addObserver(this);
		}
		
		firstPlayer = new Player(name1, 1);
		secondPlayer = new Player(name2, 2);
		
		currentPlayer = new Player("currPl", 0);
		currentPlayer = firstPlayer;
		
		//currentPlayer.addObserver(layout);
		firstPlayer.addObserver(layout);
		secondPlayer.addObserver(layout);
		this.addObserver(layout);
		
		list = new LinkedList<Card>();
		
	}
	
	
    public void playGame()
    {
       
        if(twoClicked() == true)
        {
            Thread queryThread = new Thread() 
            {
                public void run() 
                {
                    //boolean pairs = 
                    compareCards();
                }
            };
            queryThread.start();
               
               if(count == 16)
                {
                    System.out.println("Spiel vorbei");
                }
        }
    }
	
	
	public boolean twoClicked()
	{
		if(list.size() == 2 )
		{   
			return true;
		}
		else 
		{
            return false;
		}
	}
	
	
	public boolean compareCards()
	{
	    System.out.println(currentPlayer.getNum());
	    if(list.get(0).compareTo(list.get(1)) == 0)
		{
			try
			{
		        Thread.sleep(1000);
		    }
		    catch(Exception e){}
			
			list.get(0).button.setVisible(false);
			list.get(1).button.setVisible(false);
			list.clear();
			currentPlayer.addPoints();
			System.out.println(currentPlayer.getPoints());
			count = count+2;
			return true;
		}
		
		else
		{	
			try
			{
		        Thread.sleep(2000);
		    }
		    catch(Exception e){}
		   
			list.get(0).button.setIcon(list.get(0).getImage());
			list.get(1).button.setIcon(list.get(1).getImage());
			list.clear();
			currentPlayer = switchPlayer(currentPlayer);
			setChanged();
			notifyObservers(this);
			return false;
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
  		
  		list.push(temp);
  		playGame();
 	} 
 	
 	public Player getPlayer()
 	{
 	    return currentPlayer;
 	}
 	    
 	
	
}
