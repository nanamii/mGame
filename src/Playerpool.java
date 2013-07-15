import java.util.*;
import java.io.Serializable;

public class Playerpool implements Serializable{
    
    private ArrayList <Player> playerList;
    
    public Playerpool()
    {
        playerList = new ArrayList <Player>();
    }
    
    
    public ArrayList <Player> getPlayerList()
    {
        return playerList;
    }
    
    
    public void addPlayer(Player player)
    {
        playerList.add(player);
        //Testprint
        System.out.println("Player dem Pool hinzugefügt"+player.getName());
    }
    
}
