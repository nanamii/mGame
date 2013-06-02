import java.util.*;

public class Playerpool {
	
	private ArrayList <Player> playerList;
	private HddSave hdd;
	
	
	
	public Playerpool()
	{
	    hdd = new HddSave();
	    playerList = hdd.loadFromDisk();
	    
	    if(playerList == null)
	    {
	        playerList = new ArrayList<Player>();
	    }
	}
	
	
	public ArrayList <Player> getPlayerList()
	{
	    return playerList;
	}
	
	
	public void addPlayer(Player player)
	{
	    playerList.add(player);
	    System.out.println("Player dem Pool inzugefügt"+player.getName());
	}
	
	public void saveToDisk()
	{
	    hdd.saveToDisk(playerList);
	}
	
	
}
