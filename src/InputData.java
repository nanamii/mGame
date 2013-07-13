public class InputData{
	
    private Player player1;
    private Player player2;
    boolean isComputer = false;
    
    
    public void setPlayer(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void setIsComputer(boolean isComputer)
    {
        this.isComputer = isComputer;
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
