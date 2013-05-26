public class Player{
	
	private String name;
	private int points;
	private int highscorePosition;
	
	public Player(String name)
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
	
	public void addPoints()
	{
	    points =+ 10;
	}
	
		
}
