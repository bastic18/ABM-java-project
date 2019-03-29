package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WestPanel extends JPanel{
	private static JButton b1, b2, b3, b4;
	JPanel buttonPanel, b1Panel, b2Panel, b3Panel, b4Panel;
	
	public WestPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(160, 480));
		Dimension rigidArea = new Dimension(0, 5);
		Dimension button = new Dimension(100, 60);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		b1Panel = new JPanel();
		b2Panel = new JPanel();
		b3Panel = new JPanel();
		b4Panel = new JPanel();
		
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		
		
		ButtonListener listener = new ButtonListener();
		QAction q = new QAction("pressed");
		WAction w = new WAction("pressed");
		SAction s = new SAction("pressed");
		XAction x = new XAction("pressed");
		
		b1 = new JButton();
		b1.setPreferredSize(button);
		b1.addActionListener(listener);
		b1.getInputMap(map).put(KeyStroke.getKeyStroke("Q"), "pressed");
		b1.getActionMap().put("pressed", q);
		
		b2 = new JButton();
		b2.setPreferredSize(button);
		b2.addActionListener(listener);
		b2.getInputMap(map).put(KeyStroke.getKeyStroke("W"), "pressed");
		b2.getActionMap().put("pressed", w);
		
		b3 = new JButton();
		b3.setPreferredSize(button);
		b3.addActionListener(listener);
		b3.getInputMap(map).put(KeyStroke.getKeyStroke("S"), "pressed");
		b3.getActionMap().put("pressed", s);
		
		b4 = new JButton();
		b4.setPreferredSize(button);
		b4.addActionListener(listener);
		b4.getInputMap(map).put(KeyStroke.getKeyStroke("X"), "pressed");
		b4.getActionMap().put("pressed", x);
		
		b1Panel.add(b1);
		b2Panel.add(b2);
		b3Panel.add(b3);
		b4Panel.add(b4);
		
		buttonPanel.add(Box.createVerticalGlue());
		buttonPanel.add(b1Panel);
		buttonPanel.add(b2Panel);
		buttonPanel.add(b3Panel);
		buttonPanel.add(b4Panel);
		buttonPanel.add(Box.createVerticalGlue());
		
		add(Box.createVerticalGlue());
		add(buttonPanel);
		add(Box.createVerticalGlue());
	}
	
	public static void setBText(JButton b, String str){
		b.setText(str);
	}
	
	public static JButton getB1(){
		return b1;
	}
	
	public static JButton getB2(){
		return b2;
	}
	
	public static JButton getB3(){
		return b3;
	}
	
	public static JButton getB4(){
		return b4;
	}
	
	public void promptUser(String str){
		CenterPanel.setDisplay(str);
	}
	
	public static void promptCount(){
		CenterPanel.setCount(12);
	}
	
	public static void promptUser(){
		promptCount();
		CenterPanel.getInput().setText("");
		CenterPanel.removeField();
		CenterPanel.setDisplay("Do you have any other actions?\n\n1 - Yes\n2 - No");
		CenterPanel.setLabel(null, CenterPanel.getPrompt());
		b1.setText("1");
		b2.setText("2");
		EastPanel.setBText(EastPanel.getB8(), null);
	}
	
	public void resume(){
		CenterPanel.getInput().setText("");
		CenterPanel.removeField();
		b1.setText(null);
		b2.setText(null);
		EastPanel.setBText(EastPanel.getB8(), "Continue");
		CenterPanel.setDisplay("Continue does not work.\n Hit Exit");
		CenterPanel.setLabel(null, CenterPanel.getPrompt());
		CenterPanel.setCount(13);
		EastPanel.setBText(EastPanel.getB5(), "Exit");
	}
	
	public void action(){
		CenterPanel.getInput().setText("");
		CenterPanel.removeField();
		CenterPanel.setDisplay(Menu.getActions());
		CenterPanel.setLabel(null, CenterPanel.getPrompt());
		b3.setText("3");
		b4.setText(null);
		EastPanel.setBText(EastPanel.getB8(), "Cancel");
		CenterPanel.setCount(3);
	}
	
	public void invest(){
		CenterPanel.setDisplay(Menu.getInvest());
		b3.setText(null);
		b4.setText(null);
		CenterPanel.setCount(11);
	}
	
	public void balanceInquiry(String card, String pin){
		CenterPanel.getInput().setText("");
		CenterPanel.removeField();
		String str = Double.toString(EastPanel.abm.balance(card, pin));
		CenterPanel.setDisplay("The remaining balance is " + str);
		EastPanel.setBText(EastPanel.getB8(), "Continue");
		b3.setText(null);
		//promptUser();
		promptCount();
	}
	
	public void toDeposit(){
		CenterPanel.getInput().setText("");
		CenterPanel.removeField();
		CenterPanel.setDisplay("1 - Deposit in this account \n2 - Deposit in another account");
		EastPanel.setBText(EastPanel.getB8(), null);
		b1.setText("1");
		b2.setText("2");
		b3.setText(null);
		CenterPanel.setCount(20);
	}
	
	public void deposit1(){
		CenterPanel.setLabel("Enter the amount", CenterPanel.getPrompt());
		CenterPanel.addField();
		EastPanel.setBText(EastPanel.getB8(), "Continue");
		b1.setText(null);
		b2.setText(null);
		
		CenterPanel.setCount(21);
	}
	
	public static void storeAmount(){
		String amt = CenterPanel.getInput().getText();
		CenterPanel.getInput().setText("");
		EastPanel.abm.finalDeposit1(EastPanel.getId(), EastPanel.getId1(), amt);
		EastPanel.getB8().setText("Continue");
		
		promptUser();
	}
	
	public static void withdraw(){
		CenterPanel.setDisplay("Add withdraw code...");
		EastPanel.setBText(EastPanel.getB8(), "Continue");
		b1.setText(null);
		b2.setText(null);
		b3.setText(null);
		promptUser();
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			switch(count){
				case 2:
					if(event.getSource() == b1 || event.getSource() == b2 || event.getSource() == b4) action();
					else if(event.getSource() == b3) invest();
					break;
				case 3:
					if (event.getSource() == b1) balanceInquiry(EastPanel.getId(), EastPanel.getId1());
					else if(event.getSource() == b2) toDeposit();
					else if(event.getSource() == b3) withdraw();
					break;
				case 11:
					if(event.getSource() == b1) balanceInquiry(EastPanel.getId(), EastPanel.getId1());
					else if(event.getSource() == b2) toDeposit();
					break;
			}
		}
	}
	
	private  class QAction extends AbstractAction{
		public QAction(String name){
			super(name);
		}
	
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			switch(count){
				case 2:
					action();
					break;
				case 3:
					balanceInquiry(EastPanel.getId(), EastPanel.getId1());
					break;
				case 11:
					balanceInquiry(EastPanel.getId(), EastPanel.getId1());
					break;
				case 12:
					action();
					break;
				case 20:
					deposit1();
					break;
			}	
		}
	}
	
	private  class WAction extends AbstractAction{
		public WAction(String name){
			super(name);
		}
	
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			switch(count){
				case 2:
					action();
					break;
				case 3:
					toDeposit();
					break;
				case 11:
					toDeposit();
					break;
				case 12:
					resume();
					break;
			}	
		}
	}
	
	private  class SAction extends AbstractAction{
		public SAction(String name){
			super(name);
		}
	
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			switch(count){
				case 2:
					invest();
					break;
				case 3:
					withdraw();
					break;
			}	
		}
	}
	
	private  class XAction extends AbstractAction{
		public XAction(String name){
			super(name);
		}
	
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			switch(count){
				case 2:
					action();
					break;
			}	
		}
	}
}