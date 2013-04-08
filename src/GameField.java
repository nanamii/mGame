import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;


public class GameField{
	
	GameLayout layout;
	
	public GameField(GameLayout layout)
	{
		this.layout = layout;
		createDates(); 
		
		createPlayField(8);			
	}
	
	
	public void createPlayField(int cards)
	{		
		ArrayList <Card> aList = new ArrayList<Card>(cards);
	
		for(int i=0; i<cards; i++)
		{	
			String num = (i+1)+".png";
			Card card = new Card(num);
			Card card2 = new Card(num);
			aList.add(card);
			aList.add(card2);
			System.out.println(aList.size()); //TEST-Print
			System.out.println(num);		//TEST-Print
		}
		
		// ArrayList mischen
		Collections.shuffle(aList);
		
		for(int i=0; i<cards*2; i++)
		{
			layout.gameField.add(aList.get(i).getButton());
			System.out.println("test");
			//newCard.setBackground(Color.WHITE);
			//newCard.setIcon(new ImageIcon("1.png"));
			//border = new LineBorder(Color.black,3, false);			
			//newCard.setBorder(border);
		}		
	}	
	
	
	public void createDates()
	{
		JButton button = new JButton("Lala");
		layout.dates.add(button);
		System.out.println("Test2");
	}
	
}
