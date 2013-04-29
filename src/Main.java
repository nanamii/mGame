import java.util.Observer;

public class Main{
	
	public static void main(String [] args)
	{
		
		WindowModel wModel = new WindowModel();
		GameLayout layout = new GameLayout(wModel);
		GameField field = new GameField(layout);
		wModel.setVisible(true);
		
		Observer obs = new GameController(field);
				
		//Menue menue = new Menue();			
	}
		
}
