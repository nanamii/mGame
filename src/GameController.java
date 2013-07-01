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
    private ArrayList <Integer> pcChoiceList;
    boolean isComputer;
    
    
    public GameController(GameField gameField, GameLayout layout, SaveObject saveObject, Player player1, Player player2, InputData inputData)
    {
        this.gameField = gameField;
        
        for(int i=0; i<gameField.aList.size();i++)
        {
            gameField.aList.get(i).addObserver(this);
        }
        
        this.saveObject = saveObject;
        this.highscore = saveObject.getHighscore();
        this.playerpool = saveObject.getPlayerpool();
        //this.createNewPlayer1 = inputData.getCreateNewPlayer1();
        //this.createNewPlayer2 = inputData.getCreateNewPlayer2();
        this.isComputer = inputData.getIsComputer();
        
        firstPlayer = player1;
        secondPlayer = player2;
        //currentPlayer = new Player("currPl", 0);
        currentPlayer = firstPlayer;
        
        
        //Testprint
        System.out.println("nameplayer1"+firstPlayer.getName());
        System.out.println("nameplayer2"+secondPlayer.getName());
        
        saveObject.saveToDisk();
        
        firstPlayer.addObserver(layout);
        secondPlayer.addObserver(layout);
        this.addObserver(layout);
        
        list = new LinkedList<Card>();
        
        pcChoiceList = new ArrayList <Integer>();
        
    }
    
    
    public void playGame()
    {
        System.out.println("In Playgame nameplayer1"+firstPlayer.getName());
        System.out.println("Punkte In Playgame nameplayer1 --> "+firstPlayer.getPoints());
        System.out.println("In Playgame nameplayer2"+secondPlayer.getName());
        System.out.println("In Punkte Playgame nameplayer2 --> "+secondPlayer.getPoints());

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
            currentPlayer.addPoints();
            System.out.println(currentPlayer.getPoints() + currentPlayer.getName());
            count = count+2;
            System.out.println("Counter:"+count);
            editPcChoiceList();
            list.clear();
            
            if(currentPlayer.equals(secondPlayer))
            {
                if(isComputer == true)
                {
                    computerMove();
                }
            }
            
            
            
            if(gameEnd()==true)
            {
                
                //*****************************************
                //Dialog - The Winner is ......
                
                Object[] options = {"Revanche",
                    "Highscore",
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
                saveObject.saveToDisk();
                    
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
                    
                saveObject.saveToDisk();
                }
                else if (winner == 0)
                {
                    System.out.println("Unentschieden");
                    
                    int n = JOptionPane.showOptionDialog(null,
                                                    "Unentschieden - Gleiche Punktzahl",
                                                    "The Winner is ...",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    options,
                                                    options[2]);
            saveObject.saveToDisk();
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
            System.out.println("Spielername vor Wechsel"+currentPlayer.getName());
            currentPlayer = switchPlayer(currentPlayer);
            System.out.println("Spielername nach Wechsel"+currentPlayer.getName());
            
            if(currentPlayer.equals(secondPlayer))
            {
                if(isComputer == true)
                {
                    computerMove();
                }
            }
            
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
    
    
    public void computerMove()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(Exception e){}
        
        int randLong1;
        int randLong2;
      
      do
      {
        // Karten not clickable --> gesperrt für Spieler 1 ergänzen
        double random1 = (Math.random()*(gameField.aList.size())-1);
        randLong1 =(int) Math.round(random1);
        double random2 = (Math.random()*(gameField.aList.size()-1));
        randLong2 = (int) Math.round(random2); 
      }
      while (checkIndex(randLong1,randLong2)==true);
      
      Card card1 = gameField.aList.get(randLong1);
      Card card2 = gameField.aList.get(randLong2);
      card1.turnCard();
      card2.turnCard();
      System.out.println(randLong1);
      System.out.println(randLong2);
      
      // Karten LinkedList hinzufügen, compareCards() bedient sich daraus
      list.push(card1);
      list.push(card2);
      compareCards();
    }
    
    
    public boolean checkIndex(int randLong1, int randLong2)
    {
        if(pcChoiceList.contains(randLong1) || pcChoiceList.contains(randLong2) || randLong1 == randLong2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public void editPcChoiceList()
    {
        int index1 = gameField.aList.indexOf(list.get(0));
        int index2 = gameField.aList.indexOf(list.get(1));
      
        pcChoiceList.add(index1);
        pcChoiceList.add(index2);
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
