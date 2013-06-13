import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;


public class HddSave implements Serializable{
	
	
	public void saveToDisk (SaveObject tosave)
	{
		    try
		    {
			    FileOutputStream fs = new FileOutputStream("./saveObject.dat");
			    ObjectOutputStream os = new ObjectOutputStream(fs);
			
			    os.writeObject(tosave);
			    os.close();
		    }
		    catch(Exception e)
		    {
			    System.err.print("Fehler beim Schreiben.");
			    e.printStackTrace();
		    }
		    
	}
	
	
	public SaveObject loadFromDisk ()
	{
		    try
		    {
			    FileInputStream fs = new FileInputStream("./saveObject.dat");
			    ObjectInputStream os = new ObjectInputStream(fs);
			
			    SaveObject toload = (SaveObject)os.readObject();
			    os.close();
			
			    return toload;
		    }
		    catch(Exception e)
		    {
			    System.out.print("Fehler beim Lesen");
			    return null;
		    }
	}
	}
	

