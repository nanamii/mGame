import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GameField {
    
    GameLayout layout;
    ArrayList <Card> aList;
    
    public GameField(GameLayout layout, int theme)
    {
        this.layout = layout;
        createPlayField(8,theme);           
    }
    
    
    public void createPlayField(int cards, int theme)
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
            layout.gameField.add(aList.get(i).getButton()); 
        }
    }   
}
