import java.io.Serializable;

public class SaveObject implements Serializable{
	
	
	private Playerpool playerpool;
	private Highscore highscore;
	private HddSave hddSave;
	
	
	public SaveObject(Playerpool playerpool, Highscore highscore, HddSave hddSave)
	{
	  this.playerpool = playerpool;
	  this.highscore = highscore;
	  this.hddSave = hddSave;
	}
	
	
	public Playerpool getPlayerpool()
	{
	    return playerpool;
	}
	
	
	public Highscore getHighscore()
	{
	    return highscore;
	}
	
    
    public void saveToDisk()
    {
        // Setze erreichte Punktzahl nach Spielende auf 0
        for (Player item : playerpool.getPlayerList())
        {
            item.resetPoints();
        }
        hddSave.saveToDisk(this);
    }	
}
