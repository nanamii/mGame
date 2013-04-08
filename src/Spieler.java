public class Spieler{
	
	private String name;
	private int points;
	private int highscorePosition;
	
	public Spieler(String name)
	{
		this.name = name;
		this.points = 0;		
	}
	

	public String getName()
	{
		return name;
	}

	
	public void setName(String name)
	{
		this.name = name;
	}
	
		
}
