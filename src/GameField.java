import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GameField {
    
    private GameLayout layout;
    private ArrayList <Card> aList;
    
    public GameField(GameLayout layout, int theme)
    {
        this.layout = layout;
        createGameField(8,theme);           
    }
    
    
    public void createGameField(int cards, int theme)
    {       
        aList = new ArrayList<Card>(cards);
    
        for(int i=0; i<cards; i++)
        {   
            String num = "../gfx/cardlayout/"+theme+"/"+(i+1)+".png";
            Card card = new Card(num);
            Card card2 = new Card(num);
            aList.add(card);
            aList.add(card2);           
        }
        
        // ArrayList mischen d.h. Karten mischen
        Collections.shuffle(aList);
        
        for(int i=0; i<cards*2; i++)
        {
            layout.getGameFieldPanel().add(aList.get(i).getButton()); 
        }
    }
    
    public ArrayList<Card> getAList()
    {
    	return aList;
    }   
}
