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
       String picNormal;
       String picRoll;
       
       public RolloverListener()
       {
           
       }
       
       public RolloverListener(JButton button, String picNormal, String picRoll)
       {
           this.button=button;
           this.picNormal = picNormal;
           this.picRoll = picRoll;
       }
       
       
        public void mouseEntered(MouseEvent e) 
        {  
            button.setIcon(new ImageIcon(picRoll));
        }  
   
        public void mouseExited(MouseEvent e) 
        {
            button.setIcon(new ImageIcon(picNormal));
        }  
	
}
