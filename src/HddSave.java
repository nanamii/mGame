import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class HddSave {
	
	
	public void saveToDisk (ArrayList<Player> tosave)
	{
		try
		{
			FileOutputStream fs = new FileOutputStream("./player.dat");
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
	
	
	public ArrayList<Player> loadFromDisk ()
	{
		try
		{
			FileInputStream fs = new FileInputStream("./player.dat");
			ObjectInputStream os = new ObjectInputStream(fs);
			
	
			ArrayList<Player> toload = (ArrayList<Player>) os.readObject();
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
