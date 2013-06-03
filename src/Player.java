import java.util.Observable;
import java.io.Serializable;

public class Player extends Observable implements Serializable{
	
	private String name;
	private int num;
	private int points;
	private int highscorePosition;
	private boolean isComputer = false;
	
	
	public Player()
	{}
	
	
	public Player(String name, int num)
	{
		this.name = name;
		this.num = num;
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
	    points = points +10;
	    setChanged();
        notifyObservers(this);
	}
	
	public int getPoints()
	{
	    return points;
	}
	
	public int getNum()
	{
	    return num;
	}
	
}
