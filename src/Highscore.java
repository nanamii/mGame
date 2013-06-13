import java.util.Collections;
import java.util.*;
import java.io.Serializable;

public class Highscore implements Serializable{
	
	private ArrayList <HighscoreData> highscoreList;
	
	
	public Highscore()
	{
	  highscoreList = new ArrayList <HighscoreData>();
	}
	
	
	public void addToHighscore(HighscoreData hcData)
	{
	    highscoreList.add(hcData);
	}
	
	
	public void sortHighscore()
	{
	    Collections.sort(highscoreList);
	}
	
	
	public ArrayList<HighscoreData> gethighscoreList()
	{
	    return highscoreList;
	}
	
}
