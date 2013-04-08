import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class GameLayout{
	
	JPanel gameField;
	JPanel dates;
	WindowModel wModel;
	
	public GameLayout(WindowModel wModel)
	{
		this.wModel = wModel;
		createLayout();	
	}
	
	
	public void createLayout()
	{
		wModel.panel.setLayout(new BorderLayout (5,5));
		
		gameField = new JPanel();
		gameField.setPreferredSize(new Dimension(600,800));
		gameField.setLayout(new GridLayout(4,4));
		wModel.panel.add(gameField, BorderLayout.LINE_START);
		
		dates = new JPanel();
		wModel.panel.add(dates, BorderLayout.LINE_END);
	}
	
	
	public void addButton(JButton button)
	{
		System.out.println("hellojj");
		gameField.add(button);
	}
	
	
}
