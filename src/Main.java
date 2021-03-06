import java.util.Observer;

public class Main{
    
    public static void main(String [] args)
    {
        SaveObject saveObject;
        
        HddSave hdd = new HddSave();
        saveObject = hdd.loadFromDisk();
        
        /* Enthält saveObject noch keine Daten (erster Aufruf),
           erstelle Playerpool, Highscore*/
        if(saveObject == null)
        {
            Playerpool playerPool = new Playerpool();
            Highscore highscore = new Highscore();
            saveObject = new SaveObject(playerPool,highscore,hdd);
        }
        
        Menue menue = new Menue(saveObject);            
    }
}
