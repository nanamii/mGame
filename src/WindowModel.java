import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.*;

public class WindowModel extends JFrame{
	
	
	JPanel panel;
	
	public WindowModel()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new BorderLayout (0,0));
	
		setTitle("myMemo");
		setSize(800,800);
		setLocationRelativeTo(null);
		//setResizable(false);
		
		//frame.setLocation( 0, 0 );
		//frame.setSize( Toolkit.getDefaultToolkit().getScreenSize() );		
	}
	
	
}
