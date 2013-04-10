public class Main{
	
	public static void main(String [] args)
	{
		
		WindowModel wModel = new WindowModel();
		wModel.setVisible(true);
		GameLayout layout = new GameLayout(wModel);
		GameField field = new GameField(layout);
		
		//wModel.panel.add(new Menue());
		//Menue menue = new Menue();
		
	}
	
	
	
}
