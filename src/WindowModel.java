import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class WindowModel{
	
	JFrame frame;
	JPanel panel;
	
	public WindowModel()
	{
		frame = new JFrame();
		panel = new JPanel();
		
		frame.setTitle("myMemo");
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//frame.setLocation( 0, 0 );
		//frame.setSize( Toolkit.getDefaultToolkit().getScreenSize() );
		
		frame.add(panel);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	
}
