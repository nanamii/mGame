import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;


public class GameField {
	
	GameLayout layout;
	ArrayList <Card> aList;
	
	public GameField(GameLayout layout)
	{
		this.layout = layout;
		createDates(); 
		createPlayField(8);			
	}
	
	
	public void createPlayField(int cards)
	{		
		aList = new ArrayList<Card>(cards);
	
		for(int i=0; i<cards; i++)
		{	
			String num = "../gfx/"+(i+1)+".png";
			Card card = new Card(num);
			Card card2 = new Card(num);
			aList.add(card);
			aList.add(card2);			
		}
		
		// ArrayList mischen
		Collections.shuffle(aList);
		
		for(int i=0; i<cards*2; i++)
		{
			layout.gameField.add(aList.get(i).getButton());	
		}
		
		//TEST
		//aList.get(0).getButton().setVisible(false);		
	}	
	
	
	public void createDates()
	{
		//JButton button2 = new JButton("Lala");
		//layout.dates.add(button2);	
	}
	
}
