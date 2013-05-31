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
    JRadioButton radio1;
    JRadioButton radio2;
    JTextField textName1;
    JTextField textName2;
    JComboBox selectList1;
    JComboBox selectList2;
    
    Playerpool playerPool;
    String name1;
    String name2;
	
	public Menue(Playerpool playerPool)
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
        
        this.playerPool = playerPool;	
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
            System.out.println("Highscore");
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
	    radio2 = new JRadioButton("2 Spieler");
	    ButtonGroup bG = new ButtonGroup();
	    bG.add(radio1);
	    bG.add(radio2);
	    
	    textName1 = new JTextField(20);
	    textName2 = new JTextField(20);
	    
	    
	    // CompoBox füllen
	    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    ArrayList <Player> playerList = new ArrayList <Player>();
	    playerList = playerPool.getPlayerList();
	    String [] stringArray = new String [playerList.size()];
	    
	    for(int i=0; i<playerList.size(); i++)
	    {
	        String name = playerList.get(i).getName();
	        stringArray[i] = name;
	    }
	    
	    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    
	    selectList1 = new JComboBox(stringArray);
	    selectList2 = new JComboBox(stringArray);
	    
	    JLabel newNameLabel = new JLabel("Spieler neu erstellen:");
	    JLabel savedNameLabel = new JLabel("Spieler laden:");
	    JLabel newNameLabel2 = new JLabel("Spieler neu erstellen:");
	    JLabel savedNameLabel2 = new JLabel("Spieler laden:");
	    
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
	    east.add(newNameLabel);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(textName1);
	    east.add(Box.createRigidArea(new Dimension(0,20)));
	    east.add(savedNameLabel);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(selectList1);
	    east.add(Box.createRigidArea(new Dimension(0,70)));
	    east.add(newNameLabel2);
	    east.add(Box.createRigidArea(new Dimension(0,5)));
	    east.add(textName2);
	    east.add(Box.createRigidArea(new Dimension(0,20)));
	    east.add(savedNameLabel2);
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
        }});
        
         radio2.addActionListener(new ActionListener(){
		  public void actionPerformed( ActionEvent e )
        {   
            textName2.setEnabled(true);
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
	
	public void startGame()
	{
	    WindowModel wModel = new WindowModel();
		GameLayout layout = new GameLayout(wModel, name1, name2);
		GameField field = new GameField(layout);
		wModel.setVisible(true);
		
		GameController obs = new GameController(field, layout,name1, name2);
	}
	
}
