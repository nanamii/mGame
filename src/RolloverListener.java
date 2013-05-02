    import java.awt.Color;  
    import java.awt.FlowLayout;  
    import java.awt.event.MouseEvent;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.geom.*; 
       
    import javax.swing.JButton;  
    import javax.swing.JFrame;  
    import javax.swing.event.MouseInputAdapter;



public final class RolloverListener extends MouseInputAdapter{

       
       JButton button;
       
       public RolloverListener(JButton button)
       {
           this.button=button;
       }
       
       
        public void mouseEntered(MouseEvent e) 
        {  
            button.setIcon(new ImageIcon("../gfx/newGameRoll.png"));
        }  
   
        public void mouseExited(MouseEvent e) 
        {
            button.setIcon(new ImageIcon("../gfx/newGame.png"));
        }  
      
	
	
	
	
	
}
