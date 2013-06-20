public class InputData{
	
	private String name1;
	private String name2;
	boolean createNewPlayer1 = false;
    boolean createNewPlayer2 = false;
    Player player1;
    Player player2;
    boolean isComputer = false;
    
    
    public void setNames(String name1, String name2)
    {
        this.name1 = name1;
        this.name2 = name2;
    }
    
    public void setCreateNewPlayer(boolean createNewPlayer1, boolean createNewPlayer2)
    {
        this.createNewPlayer1 = createNewPlayer1;
        this.createNewPlayer2 = createNewPlayer2;
    }
    
    public void setPlayer(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void setIsComputer(boolean isComputer)
    {
        this.isComputer = isComputer;
    }
    
    
    public String getName1()
    {
        return name1;
    }
    
    public String getName2()
    {
        return name2;
    }
	
	public boolean getCreateNewPlayer1()
	{
	    return createNewPlayer1;
	}
	
	public boolean getCreateNewPlayer2()
	{
	    return createNewPlayer2;
	}
	
	public Player getPlayer1()
	{
	    return player1;
	}
	
	public Player getPlayer2()
	{
	    return player2;
	}
	
	public boolean getIsComputer()
	{
	    return isComputer;
	}
	
}
