import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Menue extends JPanel{

	Image bg;
	Dimension size;

	
	public Menue()
	{
			
		size = new Dimension();
		bg = new ImageIcon(this.getClass().getResource("menue.png")).getImage();
		size.width = bg.getWidth(null);
        size.height = bg.getHeight(null);
        setPreferredSize(size);
        this.loadMenue();
        repaint();	
	}
	
	public void loadMenue()
	{
	}


    public void paint(Graphics g) {
    	Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bg, 0, 0, null); 
	}
	
	public static void main (String [] args)
	{
	    WindowModel wModel = new WindowModel();
	    wModel.add(new Menue());
	    
	    JPanel glass = (JPanel)wModel.getGlassPane();
	    glass.setLayout(new BorderLayout());
	    
	    JFrame help = new JFrame();
	    JPanel glassContainer = (JPanel)help.getGlassPane();
	    glassContainer.setLayout(new BoxLayout(glassContainer,                  BoxLayout.PAGE_AXIS));
	    
	    JButton newGame = new JButton(new ImageIcon("../gfx/newGame.png"));
	    JLabel highscore = new JLabel(new ImageIcon("../gfx/highscore.png"));
	    JLabel beenden = new JLabel(new ImageIcon("../gfx/beenden.png"));
	    
	    newGame.setBorderPainted(false);  
        newGame.setContentAreaFilled(false);  
        newGame.setFocusPainted(false);  
        newGame.setOpaque(false);  
        newGame.addMouseListener(new RolloverListener(newGame));
          
		
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		highscore.setAlignmentX(Component.CENTER_ALIGNMENT);
		beenden.setAlignmentX(Component.CENTER_ALIGNMENT);
		glassContainer.add(newGame);
		glassContainer.add(highscore);
		glassContainer.add(beenden);
		//glassContainer.add(button);
		glassContainer.setVisible(true);
		glass.add(glassContainer, BorderLayout.SOUTH);
		glass.setVisible(true);
		wModel.setVisible(true);
		
		
	}
	
}
