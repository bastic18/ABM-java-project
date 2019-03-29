package bank;

import java.awt.*;
import javax.swing.*;

public class AbmPanel extends JPanel{
	
	public AbmPanel(){
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(960, 480));
		
		add(new CenterPanel(), BorderLayout.CENTER);
		add(new WestPanel(), BorderLayout.WEST);
		add(new EastPanel(), BorderLayout.EAST);
		add(new SouthPanel(), BorderLayout.SOUTH);
	}
}