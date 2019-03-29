package bank;

import javax.swing.*;
import java.awt.event.*;

public class Abm{
	private static JFrame frame;
	
	public static void main(String[] args){
		createFrame();
	}
	
	public static void createFrame(){
		frame = new JFrame("JLCB Automated Banking Machine");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().add(new AbmPanel());
		CloseListener c = new CloseListener();
		frame.addWindowListener(c);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static JFrame getFrame(){
		return frame;
	}
}

class CloseListener implements WindowListener{
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){
			Abm.createFrame();
		}
		public void windowClosing(WindowEvent e){}
		public void windowDeactivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
	}