public class Main{
	
	public static void main(String [] args)
	{
		
		WindowModel wModel = new WindowModel();
		wModel.setVisible(true);
		GameLayout layout = new GameLayout(wModel);
		GameField field = new GameField(layout);
		
		//Menue menue = new Menue();
	 	
	 	//WindowModel wModel2 = new WindowModel();
	 	//wModel2.panel.add(new Menue());
	 	//wModel2.setVisible(true);
	 	//wModel.panel.add(new Menue());
		
		
	}
	
	
	
}
