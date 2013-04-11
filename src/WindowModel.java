import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class WindowModel extends JFrame{
	
	
	JPanel panel;
	
	public WindowModel()
	{
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new BorderLayout (0,0));
		
		setTitle("myMemo");
		setSize(800,800);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setLocation( 0, 0 );
		//frame.setSize( Toolkit.getDefaultToolkit().getScreenSize() );		
	}
	
	
}
