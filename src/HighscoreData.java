import java.io.Serializable;

public class HighscoreData implements Comparable<HighscoreData>, Serializable{
	
	private Player player;
	private int points;
	
	
	public HighscoreData(Player player, int points)
	{
	    this.player = player;
	    this.points = points;
	}
	
	
	public Player getPlayer()
	{
	    return player;
	}
	
	
	@Override
	public int compareTo(HighscoreData data)
	{
	    if(points == data.player.getPoints())
	    {
	        return 0;
	    }
	    else if(points < data.player.getPoints())
	    {
	        return 1;
	    }
	    else
	    {
	        return -1;
	    }
	}
}