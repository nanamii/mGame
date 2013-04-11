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
		gameField = new JPanel();
		gameField.setPreferredSize(new Dimension(600,800));
		wModel.panel.add(gameField, BorderLayout.LINE_START);
		gameField.setLayout(new GridLayout(4,4,5,5));
		
		dates = new JPanel();
		dates.setPreferredSize(new Dimension(180,800));
		wModel.panel.add(dates, BorderLayout.LINE_END);
		dates.setLayout(new GridLayout(1,1));
			
	}
	
	
	public void addButton(JButton button)
	{
		gameField.add(button);
	}
	
	
}
