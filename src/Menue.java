import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.util.Observer;
import java.util.Observable;
import java.util.*;


public class Menue extends JPanel{

	Image bg;
	Dimension size;
    WindowModel mainMenueWindow;
    WindowModel newGameWindow;
    WindowModel nextWindow;
    WindowModel highscoreWindow;
    JRadioButton radio1;
    JRadioButton radio2;
    JRadioButton newNameRB1;
    JRadioButton savedNameRB1;
    JRadioButton newNameRB2;
    JRadioButton savedNameRB2;
    JTextField textName1;
    JTextField textName2;
    JComboBox selectList1;
    JComboBox selectList2;
    
    ArrayList <Player> playerList;
    SaveObject saveObject;
   
    String name1;
    String name2;
    boolean createNewPlayer1 = false;
    boolean createNewPlayer2 = false;
    Player player1;
    Player player2;
    boolean isComputer = false;
    
	
	public Menue(SaveObject saveObject)
	{
		mainMenueWindow = new WindowModel();
	    mainMenueWindow.add(this);
		
		size = new Dimension();
		bg = new ImageIcon(this.getClass().getResource("menue.png")).getImage();
		size.width = bg.getWidth(null);
        size.height = bg.getHeight(null);
        setPreferredSize(size);
        this.loadMainMenue();
        repaint();
        
        this.saveObject = saveObject;
	}
	
	
	public void loadMainMenue()
	{
	    JPanel glass = (JPanel)mainMenueWindow.getGlassPane();
	    glass.setLayout(new BorderLayout());
	    
	    JFrame help = new JFrame();
	    JPanel glassContainer = (JPanel)help.getGlassPane();
	    glassContainer.setLayout(new BoxLayout(glassContainer,BoxLayout.PAGE_AXIS));
	    
	    String picNewGame = "../gfx/newGame.png";
	    String picNewGameRoll = "../gfx/newGameRoll.png";
	    String picHighscore = "../gfx/highscore.png";
	    String picHighscoreRoll = "../gfx/highscoreRoll.png";
	    String picBeenden = "../gfx/beenden.png";
	    String picBeendenRoll = "../gfx/beendenRoll.png";
	    
	    JButton newGame = new JButton(new ImageIcon(picNewGame));
	    JButton highscore = new JButton(new ImageIcon(picHighscore));
	    JButton beenden = new JButton(new ImageIcon(picBeenden));
	    
	    modifyButton(newGame,picNewGame,picNewGameRoll);
	    modifyButton(highscore,picHighscore,picHighscoreRoll);
	    modifyButton(beenden,picBeenden,picBeendenRoll);
          
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		highscore.setAlignmentX(Component.CENTER_ALIGNMENT);
		beenden.setAlignmentX(Component.CENTER_ALIGNMENT);
        
		glassContainer.add(newGame);
		glassContainer.add(highscore);
		glassContainer.add(beenden);
		glassContainer.setVisible(true);
		glass.add(glassContainer, BorderLayout.SOUTH);
		glass.setVisible(true);
		glass.setBorder(new EmptyBorder(5,5,25,5));
		mainMenueWindow.setVisible(true);
		
		newGame.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {
            mainMenueWindow.setVisible(false);
            newGameMenue();
        }});
        
        highscore.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {
            mainMenueWindow.setVisible(false);
            showHighscore();
        }});
        
		
		beenden.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {
            System.exit(0);
        }});
	}

    
    public void newGameMenue()
    {
        newGameWindow = new WindowModel();
	    newGameWindow.setVisible(true);
	    
	    JPanel west = new JPanel();
	    west.setLayout(new BoxLayout(west, BoxLayout.PAGE_AXIS));
	    //west.setAlignmentX(Component.CENTER_ALIGNMENT );
	    west.setBorder(BorderFactory.createEmptyBorder(60,70,10,10));
	    JPanel east = new JPanel();
	    east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
	    east.setBorder(BorderFactory.createEmptyBorder(70,10,10,130));
	    
	    JPanel bottom = new JPanel(); //per default FlowLayout
	    
	    JLabel numPlayer = new JLabel(new ImageIcon("../gfx/radPlayer.png"));
	    JLabel namePlayer = new JLabel(new ImageIcon("../gfx/name1.png"));
	    JLabel namePlayer2 = new JLabel(new ImageIcon("../gfx/name2.png"));
	    
	    radio1 = new JRadioButton("Alleine vs. Computer");
	    radio1.doClick();
	    radio2 = new JRadioButton("2 Spieler");
	    ButtonGroup bg_playerQuantity = new ButtonGroup();
	    bg_playerQuantity.add(radio1);
	    bg_playerQuantity.add(radio2);
	    
	    textName1 = new JTextField(10);
	    textName2 = new JTextField(10);
	    
	    
	    // CompoBox füllen
	    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    playerList = new ArrayList <Player>();
	    playerList = saveObject.getPlayerpool().getPlayerList();
	    String [] stringArray = new String [playerList.size()];
	    
	    for(int i=0; i<playerList.size(); i++)
	    {
	        String name = playerList.get(i).getName();
	        stringArray[i] = name;
	    }
	    
	    selectList1 = new JComboBox(stringArray);
	    selectList2 = new JComboBox(stringArray);
	    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    
	    
	    newNameRB1 = new JRadioButton("Spieler neu erstellen:");
	    savedNameRB1 = new JRadioButton("Spieler laden:");
	    newNameRB2 = new JRadioButton("Spieler neu erstellen:");
	    savedNameRB2 = new JRadioButton("Spieler laden:");
	    ButtonGroup bg_playerChoose1 = new ButtonGroup();
	    ButtonGroup bg_playerChoose2 = new ButtonGroup();
	    bg_playerChoose1.add(newNameRB1);
	    bg_playerChoose1.add(savedNameRB1);
	    bg_playerChoose2.add(newNameRB2);
	    bg_playerChoose2.add(savedNameRB2);
	    newNameRB1.doClick();
	    newNameRB2.doClick();
	    	    
	    JButton buttonNext = new JButton("WEITER");
	    JButton buttonBack = new JButton("zurück");
	    
	    west.add(numPlayer);
	    west.add(Box.createRigidArea(new Dimension(0,50)));
	    west.add(namePlayer);
	    west.add(Box.createRigidArea(new Dimension(0,85)));
	    west.add(namePlayer2);
	    west.add(Box.createRigidArea(new Dimension(0,20)));
	    
	    east.add(radio1);
	    east.add(radio2);
	    east.add(Box.createRigidArea(new Dimension(0,90)));
	    east.add(newNameRB1);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(textName1);
	    east.add(Box.createRigidArea(new Dimension(0,20)));
	    east.add(savedNameRB1);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(selectList1);
	    east.add(Box.createRigidArea(new Dimension(0,70)));
	    east.add(newNameRB2);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(textName2);
	    east.add(Box.createRigidArea(new Dimension(0,20)));
	    east.add(savedNameRB2);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(selectList2);
	    east.add(Box.createRigidArea(new Dimension(0,200)));
	   
	    
	    bottom.add(buttonBack);
	    bottom.add(buttonNext);
	    
	    newGameWindow.panel.add(west, BorderLayout.WEST);
	    newGameWindow.panel.add(east, BorderLayout.EAST);
	    newGameWindow.panel.add(bottom, BorderLayout.SOUTH);
	    
	    
	    
	    
	    
	    //***********************************************************
	    //ActionListener
	    //***********************************************************
	    
	   radio1.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            textName2.setEnabled(false);
            selectList2.setEnabled(false);
            newNameRB2.setEnabled(false);
            savedNameRB2.setEnabled(false);
            isComputer = true;
            
        }});
        
        radio2.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            textName2.setEnabled(true);
            selectList2.setEnabled(true);
            newNameRB2.setEnabled(true);
            savedNameRB2.setEnabled(true);
            isComputer = false;
            name1 = "Computer";
            createNewPlayer2 = true;
        }});
        
        newNameRB1.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            selectList1.setEnabled(false);
            textName1.setEnabled(true);
            createNewPlayer1 = true;
        }});
        
        newNameRB2.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            selectList2.setEnabled(false);
            textName2.setEnabled(true);
            createNewPlayer2 = true;
        }});
        
        savedNameRB1.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            selectList1.setEnabled(true);
            textName1.setEnabled(false);
            createNewPlayer1 = false;
           
        }});
        
        savedNameRB2.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            selectList2.setEnabled(true);
            textName2.setEnabled(false);
            createNewPlayer2 = false;
           
        }});
        
        
        
	    
	    buttonBack.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            newGameWindow.setVisible(false);
            mainMenueWindow.setVisible(true);
        }});
        
        
        buttonNext.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            name1 = textName1.getText();
            name2 = textName2.getText();
            System.out.println(name1+name2);
            
            
            String savedName1 = (String)selectList1.getSelectedItem();
            System.out.println(savedName1);
            
            for(int i=0; i<playerList.size(); i++ )
            {
                if(playerList.get(i).getName().equals(savedName1))
                {
                    player1 = playerList.get(i);
                }
            }
            
            
            String savedName2 = (String)selectList2.getSelectedItem();
            System.out.println(savedName2);
            
            for(int i=0; i<playerList.size(); i++ )
            {
                if(playerList.get(i).getName().equals(savedName2))
                {
                    player2 = playerList.get(i);
                }
            }
            
            newGameWindow.setVisible(false);
            newGameMenueNEXT();
            
        }});
	    
	}
	
	
	public void newGameMenueNEXT()
	{
	    nextWindow = new WindowModel();
	    nextWindow.setVisible(true);
	    
	    JPanel west = new JPanel();
	    west.setLayout(new BoxLayout(west, BoxLayout.PAGE_AXIS));
	    //west.setAlignmentX(Component.CENTER_ALIGNMENT );
	    west.setBorder(BorderFactory.createEmptyBorder(60,70,10,10));
	    
	    JPanel east = new JPanel();
	    east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
	    //top,left,bottom,right
	    east.setBorder(BorderFactory.createEmptyBorder(70,10,10,300));
	    
	    JPanel bottom = new JPanel(); //per default FlowLayout
	    
	    JButton back2 = new JButton("zurück");
	    JButton start = new JButton("START");
	    
	    JLabel theme = new JLabel(new ImageIcon("../gfx/thema.png"));
	    JLabel size = new JLabel(new ImageIcon("../gfx/spielfeldgroesse.png"));
	    
	    JRadioButton b1 = new JRadioButton("Tiere");
	    JRadioButton b2 = new JRadioButton("Pflanzen");
	    JRadioButton b3 = new JRadioButton("Flaggen");
	    
	    JRadioButton b4 = new JRadioButton(" 4 x 4");
	    JRadioButton b5 = new JRadioButton(" 8 x 8");
	    
	    ButtonGroup butGroup = new ButtonGroup();
	    butGroup.add(b1);
	    butGroup.add(b2);
	    butGroup.add(b3);
	    
	    ButtonGroup butGroup2 = new ButtonGroup();
	    butGroup2.add(b4);
	    butGroup2.add(b5);
	    
	    west.add(theme);
	    west.add(Box.createRigidArea(new Dimension(0,60)));
	    west.add(size);
	    
	    east.add(b1);
	    east.add(b2);
	    east.add(b3);
	    east.add(Box.createRigidArea(new Dimension(0,80)));
	    east.add(b4);
	    east.add(b5);
	    
	    bottom.add(back2);
	    bottom.add(start);
	    
	    nextWindow.add(west, BorderLayout.WEST);
	    nextWindow.add(east, BorderLayout.EAST);
	    nextWindow.add(bottom, BorderLayout.SOUTH);
	    
	   back2.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            nextWindow.setVisible(false);
            mainMenueWindow.setVisible(true);
        }});
        
          start.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            nextWindow.setVisible(false);
            startGame();
        }});
	    
	}
        
    
    public void paint(Graphics g) 
    {
    	Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bg, 0, 0, null); 
	}
	
	
	public void modifyButton(JButton button, String picNormal, String picRoll)
	{
	    button.setBorderPainted(false);  
        button.setContentAreaFilled(false);  
        button.setFocusPainted(false);  
        button.setOpaque(false);  
        button.addMouseListener(new RolloverListener(button,picNormal,picRoll)); 
	}
	
	
	public void showHighscore()
	{
	    String [] colNames = {"Platz","Name","Punkte"};
	    Object [][] data = new Object [10][3];
	    
	    for(int i=0; i<2; i++)
	    {   
	        data [i][0] = i;
	        data [i][1] = saveObject.getHighscore().gethighscoreList().get(i).getPlayer().getName();
	        data [i][2] = saveObject.getHighscore().gethighscoreList().get(i).getPoints();
	    }
	    
	    highscoreWindow = new WindowModel();
	    highscoreWindow.setVisible(true);
	    
	    JPanel hcPanel = new JPanel();
	    JTable hcTable = new JTable(data,colNames);
	    JScrollPane spTable = new JScrollPane(hcTable);
	    hcPanel.add(spTable);
	    
	    highscoreWindow.add(hcPanel);
	}
	
	
	public void startGame()
	{
	    WindowModel wModel = new WindowModel();
		GameLayout layout = new GameLayout(wModel, name1, name2);
		System.out.println("startGame-Methode, Namen:"+name1+name2);
		GameField field = new GameField(layout);
		wModel.setVisible(true);
		
		GameController obs = new GameController(field, layout,name1, name2, saveObject, createNewPlayer1, createNewPlayer2, player1, player2, isComputer);
	}
	
}
