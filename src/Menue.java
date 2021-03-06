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

    private Image bg;
    private Dimension size;
    private WindowModel mainMenueWindow;
    private WindowModel newGameWindow;
    private WindowModel nextWindow;
    private WindowModel highscoreWindow;
    private JRadioButton isComputerRB;
    private JRadioButton twoPlayerRB;
    private JRadioButton newNameRB1;
    private JRadioButton savedNameRB1;
    private JRadioButton newNameRB2;
    private JRadioButton savedNameRB2;
    private JRadioButton themeRB1;
    private JRadioButton themeRB2;
    private JRadioButton themeRB3;
    private JTextField textName1;
    private JTextField textName2;
    private JComboBox selectList1;
    private JComboBox selectList2;

    private ArrayList <Player> playerList;
    private SaveObject saveObject;

    private Player player1;
    private Player player2;
    private boolean isComputer = false;
    private int themeChoice;



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

    //############################################################################
    public void newGameMenue()
    {
        newGameWindow = new WindowModel();
        newGameWindow.setVisible(true);

        JPanel west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.PAGE_AXIS));
        west.setBorder(BorderFactory.createEmptyBorder(60,70,10,10));
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        east.setBorder(BorderFactory.createEmptyBorder(70,5,10,180));

        JPanel bottom = new JPanel((new FlowLayout(FlowLayout.TRAILING))); 
        //per default FlowLayout

        JLabel numPlayer = new JLabel(new ImageIcon("../gfx/radPlayer.png"));
        JLabel namePlayer = new JLabel(new ImageIcon("../gfx/name1.png"));
        JLabel namePlayer2 = new JLabel(new ImageIcon("../gfx/name2.png"));

        isComputerRB = new JRadioButton("Alleine vs. Computer");
        twoPlayerRB = new JRadioButton("2 Spieler");
        ButtonGroup bg_playerQuantity = new ButtonGroup();
        bg_playerQuantity.add(isComputerRB);
        bg_playerQuantity.add(twoPlayerRB);

        textName1 = new JTextField(20);
        textName2 = new JTextField(20);




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

        east.add(isComputerRB);
        east.add(twoPlayerRB);
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

        isComputerRB.setAlignmentX(Component.LEFT_ALIGNMENT);
        twoPlayerRB.setAlignmentX(Component.LEFT_ALIGNMENT);
        textName1.setAlignmentX(Component.LEFT_ALIGNMENT);
        textName2.setAlignmentX(Component.LEFT_ALIGNMENT);
        savedNameRB1.setAlignmentX(Component.LEFT_ALIGNMENT);
        savedNameRB2.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectList1.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectList2.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Default-Zustand der RadioButtons herstellen
        isComputerRB.setSelected(true);
        newNameRB1.setSelected(true);
        newNameRB2.setEnabled(false);
        savedNameRB1.setEnabled(true);
        savedNameRB2.setEnabled(false);
        selectList1.setEnabled(false);
        selectList2.setEnabled(false);

        //***********************************************************
        //ActionListener
        //***********************************************************

        //RadioButtons

        isComputerRB.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            textName2.setEnabled(false);
            selectList2.setEnabled(false);
            newNameRB2.setEnabled(false);
            savedNameRB2.setEnabled(false);
            isComputer = true;

        }});

        twoPlayerRB.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            textName2.setEnabled(true);
            selectList2.setEnabled(false);
            newNameRB2.setEnabled(true);
            savedNameRB2.setEnabled(true);
        }});

        newNameRB1.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            selectList1.setEnabled(false);
            textName1.setEnabled(true);
        }});

        newNameRB2.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            selectList2.setEnabled(false);
            textName2.setEnabled(true);
        }});

        savedNameRB1.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            selectList1.setEnabled(true);
            textName1.setEnabled(false);
        }});

        savedNameRB2.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            selectList2.setEnabled(true);
            textName2.setEnabled(false);
        }});

        // zurück-Button
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   
            newGameWindow.setVisible(false);
            mainMenueWindow.setVisible(true);
        }});

        // weiter-Button
        buttonNext.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e )
        {   

            player1 = getPlayer(1);
            player2 = getPlayer(2);
            if (player1.getName().equals(player2.getName()))
        {
            System.out.println(player1.getName());
            System.out.println(player2.getName());
            showWarningPlayerExists("2x gleichen Player gewählt");
        }
        else
        {

            System.out.println("juhi");
            newGameWindow.setVisible(false);
            newGameMenueNEXT();
        }
        }
        });}


        public Player getPlayer(int value)
        {
            Player p = null;

            if (isComputerRB.isSelected() == true && value == 2)
            {
                p = getComputerPlayer();
                isComputer = true;
            }
            else
            {
                p = readPlayerFromGui(value);
            }
            return p;
        }


        public Player readPlayerFromGui(int value)
        {
            JTextField tf = null;
            JRadioButton newName = null;
            JComboBox sl = null;

            if (value == 1)
            {
                tf = textName1;
                newName = newNameRB1;
                sl = selectList1;
            }
            else if (value == 2)
            {
                tf = textName2;
                newName = newNameRB2;
                sl = selectList2;
            }

            Player player = null;
            if (newName.isSelected() == true)    
            {
                player = new Player(tf.getText(), value);
                System.out.println("Player:" + tf.getText() + "erstellt");

                if (checkNames(player.getName()) == true)
                {
                    showWarningPlayerExists("Player existiert bereits");
                    return null;
                }
                saveObject.getPlayerpool().addPlayer(player);
            }
            else
            {
                System.out.println("select player from list");

                for(int i=0; i<playerList.size(); i++)
                {
                    if(playerList.get(i).getName().equals(sl.getSelectedItem()))
                    {
                        player = playerList.get(i);
                        player.setNum(value);
                            
                    }
                }
            }
            return player;
        }


        public Player getComputerPlayer()
        {
            return new Player("Computer", 2);
        }


        public void showWarningPlayerExists(String warning)
        {
            JOptionPane.showMessageDialog(newGameWindow, 
                    warning);
        }

        public void newGameMenueNEXT()
        {
            nextWindow = new WindowModel();
            nextWindow.setVisible(true);

            JPanel west = new JPanel();
            west.setLayout(new BoxLayout(west, BoxLayout.PAGE_AXIS));
            west.setBorder(BorderFactory.createEmptyBorder(60,70,10,10));

            JPanel east = new JPanel();
            east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
            //top,left,bottom,right
            east.setBorder(BorderFactory.createEmptyBorder(70,10,10,300));

            JPanel bottom = new JPanel((new FlowLayout(FlowLayout.TRAILING))); 
            //per default FlowLayout

            JButton back2 = new JButton("zurück");
            JButton start = new JButton("START");

            JLabel theme = new JLabel(new ImageIcon("../gfx/thema.png"));
            JLabel size = new JLabel(new ImageIcon("../gfx/spielfeldgroesse.png"));

            themeRB1 = new JRadioButton("Tiere");
            themeRB1.setSelected(true);
            themeRB2 = new JRadioButton("Pflanzen");
            themeRB3 = new JRadioButton("Flaggen");

            JRadioButton b4 = new JRadioButton(" 4 x 4");
            b4.setSelected(true);
            JRadioButton b5 = new JRadioButton(" 8 x 8");

            ButtonGroup butGroup = new ButtonGroup();
            butGroup.add(themeRB1);
            butGroup.add(themeRB2);
            butGroup.add(themeRB3);

            ButtonGroup butGroup2 = new ButtonGroup();
            butGroup2.add(b4);
            butGroup2.add(b5);

            west.add(theme);
            west.add(Box.createRigidArea(new Dimension(0,60)));
            west.add(size);

            east.add(themeRB1);
            east.add(themeRB2);
            east.add(themeRB3);
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

                if(themeRB1.isSelected()==true)
            {
                themeChoice = 1;
            }
            else if(themeRB2.isSelected()==true)
            {
                themeChoice = 2;
            }
            else
            {
                themeChoice = 3;
            }


            if(themeChoice ==1 || themeChoice ==2 || themeChoice ==3)
            {
                nextWindow.setVisible(false);
                startGame();
            }
            else
            {
                JOptionPane.showMessageDialog(newGameWindow, 
                        "Wähle Thema und Spielfeldgröße");
            }
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


        public boolean checkNames(String name)
        {
            for(int i=0; i<playerList.size();i++)
            {
                if(playerList.get(i).getName().equals(name))
                {
                    return true;
                }
            }
            return false;   
        }


        public void showHighscore()
        {
            String [] colNames = {"Platz","Name","Punkte"};
            Object [][] data = new Object [11][3];
            int highscoreSize = saveObject.getHighscore().gethighscoreList().size();
            int ranges;

            if(highscoreSize > 0)
            {
                if(highscoreSize >= 10)
                {
                    ranges = 10; 		
                }
                else
                {
                    ranges = highscoreSize;
                }

                for(int i=1; i<ranges+1; i++)
                {   
                    data [i][0] = i;
                    data [i][1] = saveObject.getHighscore().gethighscoreList().get(i-1).getPlayer().getName();
                    data [i][2] = saveObject.getHighscore().gethighscoreList().get(i-1).getPoints();
                }
            }

            highscoreWindow = new WindowModel();
            highscoreWindow.setVisible(true);

            JPanel hcPanel = new JPanel();
            hcPanel.setLayout(new BoxLayout(hcPanel, BoxLayout.PAGE_AXIS));
            JTable hcTable = new JTable(data,colNames);
            JScrollPane spTable = new JScrollPane(hcTable);
            JLabel highscoreLabel = new JLabel(new ImageIcon("../gfx/highscoreLabel.png"));
            JButton backToMenue = new JButton("zurück");
            hcPanel.add(highscoreLabel);
            hcPanel.add(Box.createRigidArea(new Dimension(0,40)));
            hcPanel.add(spTable);
			highscoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			
            JPanel buttonPanel = new JPanel((new FlowLayout(FlowLayout.TRAILING)));
            buttonPanel.add(backToMenue);

            highscoreWindow.add(hcPanel);
            highscoreWindow.panel.add(buttonPanel, BorderLayout.SOUTH);

            backToMenue.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent e )
            {   
                highscoreWindow.setVisible(false);
                mainMenueWindow.setVisible(true);
            }});
        }


        public void startGame()
        {
            InputData inputData = new InputData();
            inputData.setPlayer(player1,player2);
            inputData.setIsComputer(isComputer);

            WindowModel wModel = new WindowModel();
            GameLayout layout = new GameLayout(wModel, player1, player2);
            GameField field = new GameField(layout,themeChoice);
            wModel.setVisible(true);
            GameController obs = new GameController(field, layout, saveObject,inputData);
        }
}
