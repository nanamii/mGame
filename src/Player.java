import java.util.Observable;
import java.io.Serializable;

public class Player extends Observable implements Serializable{
    
    private String name;
    private int num;
    private int points;
    
    
    public Player(String name, int num)
    {
        this.name = name;
        this.num = num;
        this.points = 0;
    }
    

    public void resetPoints()
    {
        this.points = 0;
    }

    public void setNum(int value)
    {
        this.num = value;
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
        System.out.println("PUNKTE addiert");
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
