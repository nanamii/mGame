import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.util.Observer;
import java.util.Observable;


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
    
    String name1;
    String name2;
	
	public Menue()
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
	}
	
	public void loadMainMenue()
	{
	    JPanel glass = (JPanel)mainMenueWindow.getGlassPane();
	    glass.setLayout(new BorderLayout());
	    
	    JFrame help = new JFrame();
	    JPanel glassContainer = (JPanel)help.getGlassPane();
	    glassContainer.setLayout(new BoxLayout(glassContainer,BoxLayout.PAGE_AXIS));
	    
	    JButton newGame = new JButton(new ImageIcon("../gfx/newGame.png"));
	    JButton highscore = new JButton(new ImageIcon("../gfx/highscore.png"));
	    JButton beenden = new JButton(new ImageIcon("../gfx/beenden.png"));
	    
	    modifyButton(newGame);
	    modifyButton(highscore);
	    modifyButton(beenden);
          
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		highscore.setAlignmentX(Component.CENTER_ALIGNMENT);
		beenden.setAlignmentX(Component.CENTER_ALIGNMENT);
		
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
            System.exit( 0 );
        }});
        
		glassContainer.add(newGame);
		glassContainer.add(highscore);
		glassContainer.add(beenden);
		glassContainer.setVisible(true);
		glass.add(glassContainer, BorderLayout.SOUTH);
		glass.setVisible(true);
		mainMenueWindow.setVisible(true);
	}

    
    public void newGameMenue()
    {
        newGameWindow = new WindowModel();
	    newGameWindow.setVisible(true);
	    
	    JPanel west = new JPanel();
	    west.setLayout(new BoxLayout(west, BoxLayout.PAGE_AXIS));
	    //west.setAlignmentX(Component.CENTER_ALIGNMENT );
	    west.setBorder(BorderFactory.createEmptyBorder(60,60,10,10));
	    JPanel east = new JPanel();
	    east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
	    east.setBorder(BorderFactory.createEmptyBorder(60,10,10,60));
	    
	    JPanel bottom = new JPanel(); //per default FlowLayout
	    
	    JLabel numPlayer = new JLabel(new ImageIcon("../gfx/newGame.png"));
	    JLabel namePlayer = new JLabel("Name Spieler 1");
	    JLabel namePlayer2 = new JLabel("Name Spieler 2");
	    JLabel chooseName = new JLabel("Gespeicherten Namen wählen");
	    JLabel gap = new JLabel();
	    
	    radio1 = new JRadioButton("1 vs. Computer");
	    radio2 = new JRadioButton("2");
	    ButtonGroup bG = new ButtonGroup();
	    bG.add(radio1);
	    bG.add(radio2);
	    
	    textName1 = new JTextField(20);
	    textName2 = new JTextField(20);
	    
	    JButton buttonNext = new JButton("WEITER");
	    JButton buttonBack = new JButton("zurück");
	    
	    west.add(numPlayer);
	    west.add(Box.createRigidArea(new Dimension(0,60)));
	    west.add(namePlayer);
	    west.add(Box.createRigidArea(new Dimension(0,10)));
	    west.add(namePlayer2);
	    west.add(Box.createRigidArea(new Dimension(0,20)));
	    west.add(chooseName);
	    
	    east.add(radio1);
	    east.add(radio2);
	    east.add(Box.createRigidArea(new Dimension(0,20)));
	    east.add(textName1);
	    east.add(Box.createRigidArea(new Dimension(0,10)));
	    east.add(textName2);
	    east.add(Box.createRigidArea(new Dimension(0,500)));
	   
	    
	    bottom.add(buttonBack);
	    bottom.add(buttonNext);
	    
	    newGameWindow.panel.add(west, BorderLayout.WEST);
	    newGameWindow.panel.add(east, BorderLayout.EAST);
	    newGameWindow.panel.add(bottom, BorderLayout.SOUTH);
	    
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
	    west.setBorder(BorderFactory.createEmptyBorder(60,60,10,10));
	    
	    JPanel east = new JPanel();
	    east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
	    east.setBorder(BorderFactory.createEmptyBorder(60,10,10,60));
	    
	    JPanel bottom = new JPanel(); //per default FlowLayout
	    
	    JButton back2 = new JButton("zurück");
	    JButton start = new JButton("START");
	    
	    JLabel theme = new JLabel("Thema:");
	    JLabel size = new JLabel("Spielfeldgröße:");
	    
	    JRadioButton b1 = new JRadioButton("Tiere");
	    JRadioButton b2 = new JRadioButton("Pflanzen");
	    JRadioButton b3 = new JRadioButton("Flaggen");
	    
	    JRadioButton b4 = new JRadioButton("4 x 4");
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
	    east.add(Box.createRigidArea(new Dimension(0,60)));
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
	
	public void modifyButton(JButton button)
	{
	    button.setBorderPainted(false);  
        button.setContentAreaFilled(false);  
        button.setFocusPainted(false);  
        button.setOpaque(false);  
        button.addMouseListener(new RolloverListener(button)); 
	}
	
	public void startGame()
	{
	    //String name1 = textName1.getText();
		//String name2 = textName2.getText();
	   
	    WindowModel wModel = new WindowModel();
		GameLayout layout = new GameLayout(wModel, name1, name2);
		GameField field = new GameField(layout);
		wModel.setVisible(true);
		
		
		GameController obs = new GameController(field, layout,name1, name2);
		
	}
	
}
