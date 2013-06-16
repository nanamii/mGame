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
import java.lang.Math;
import java.util.*;


public class GameController extends Observable implements Observer{
	
	private GameField gameField;
	
	private Player firstPlayer; 
	private Player secondPlayer;
	private Player currentPlayer;
	
	private SaveObject saveObject;
	private Playerpool playerpool;
	private Highscore highscore;
	private boolean createNewPlayer1;
	private boolean createNewPlayer2;
	
	private int count = 0;
	
	private LinkedList <Card> list;
	private ArrayList <Card> PCchoiceList;
	boolean isComputer;
	
	
	public GameController(GameField gameField, GameLayout layout, String name1, 
	String name2, SaveObject saveObject, boolean createNewPlayer1, 
	boolean createNewPlayer2, Player player1, Player player2, boolean isComputer)
	{
		this.gameField = gameField;
		
		for(int i=0; i<gameField.aList.size();i++)
		{
			gameField.aList.get(i).addObserver(this);
		}
		
		this.saveObject = saveObject;
		this.highscore = saveObject.getHighscore();
		this.playerpool = saveObject.getPlayerpool();
		this.createNewPlayer1 = createNewPlayer1;
		this.createNewPlayer2 = createNewPlayer2;
		
		if(createNewPlayer1 == true)
		{
		    firstPlayer = new Player(name1, 1);
		    playerpool.addPlayer(firstPlayer);
		}
		else
		{
		    this.firstPlayer = player1;
		    System.out.println("Else-Teil");
		}
		
		
		if(createNewPlayer2 == true)
		{
		    secondPlayer = new Player(name2, 2);
		    playerpool.addPlayer(secondPlayer);
		}
		else
		{
		    this.secondPlayer = player2;
		    System.out.println("Else-Teil");
		}
		
		System.out.println("nameplayer1"+firstPlayer.getName());
		System.out.println("nameplayer2"+secondPlayer.getName());
		
		currentPlayer = new Player("currPl", 0);
		currentPlayer = firstPlayer;
		
		//playerpool.saveToDisk();
		saveObject.saveToDisk();
		
		firstPlayer.addObserver(layout);
		secondPlayer.addObserver(layout);
		this.addObserver(layout);
		
		list = new LinkedList<Card>();
		
		//Kopie von aList aus Class GameField
		PCchoiceList = new ArrayList <Card>();
		for(int i=0; i<gameField.aList.size(); i++)
		{
		    Card card = gameField.aList.get(i);
		    PCchoiceList.add(card);
		}
		
		this.isComputer = isComputer;
		
	}
	
	
    public void playGame()
    {
        if(twoClicked() == true)
        {
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
	    //Cards match
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
			System.out.println("Counter:"+count);
			
			
			
			if(gameEnd()==true)
            {
                
                //*****************************************
                //Dialog - The Winner is ......
                
                Object[] options = {"Revanche",
                    "Neues Spiel",
                    "Hauptmenue"};
                
                System.out.println("ITS OVER");
                int winner = checkWinner();
                if(winner == 1)
                {
                    System.out.println("Gewinner:"+firstPlayer.getName());
                    
                    int n = JOptionPane.showOptionDialog(null,
                                                    firstPlayer.getName()+"hat gewonnen",
                                                    "The Winner is ...",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    options,
                                                    options[2]);
                    
                }
                else if (winner == 2)
                {
                     System.out.println("Gewinner:"+secondPlayer.getName());
                     
                     int n = JOptionPane.showOptionDialog(null,
                                                    secondPlayer.getName()+"hat gewonnen",
                                                    "The Winner is ...",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    options,
                                                    options[2]);
                    
                }
                else if (winner == 0)
                {
                    System.out.println("Unentschieden");
                }
            }
            
			return true;
		}
		// Cards doesn't match
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
            if( isComputer == true)
            {
                computerMove();
                return secondPlayer;
            }
            else
            {
                return secondPlayer;
            }
        }
        else
        {
            return firstPlayer;
        }
	}
	
	public void computerMove()
	{
	  // Karten not clickable --> gesperrt für Spieler 1
	  double random1 = (Math.random()*(PCchoiceList.size())-1);
	  int randLong1 =(int) Math.round(random1);
	  double random2 = (Math.random()*(PCchoiceList.size()-2));
      int randLong2 = (int) Math.round(random2); 
      Card card1 = gameField.aList.get(randLong1);
      Card card2 = gameField.aList.get(randLong2);
      card1.turnCard();
      card2.turnCard();
      // Karten LinkedList hinzufügen, compareCards() bedient sich daraus
      list.push(card1);
      list.push(card2);
      compareCards();
      	  
	    
	}
	
	public boolean gameEnd()
	{
	    if(count==16)
	    {
	        System.out.println("Spiel vorbei");
	        HighscoreData data1 = new HighscoreData(firstPlayer, firstPlayer.getPoints());
	        HighscoreData data2 = new HighscoreData(secondPlayer, secondPlayer.getPoints());
	        highscore.addToHighscore(data1);
	        highscore.addToHighscore(data2);
	        highscore.sortHighscore();
	        saveObject.saveToDisk();
	        
	        for(int i=0; i<highscore.gethighscoreList().size(); i++)
	        {
	            System.out.println("1.Platz: " + highscore.gethighscoreList().get(i).getPlayer().getName());
	        }
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	
	public int checkWinner()
	{
	    if(firstPlayer.getPoints() > secondPlayer.getPoints())
	    {
	        return 1;
	    }
	    else if (firstPlayer.getPoints() != secondPlayer.getPoints())
	    {
	        return 2;
	    }
	    else
	    {
	        return 0;
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
