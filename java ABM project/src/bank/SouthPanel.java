package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SouthPanel extends JPanel{
	private static JButton b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, enter, back, cancel;
	public SouthPanel(){
		setPreferredSize(new Dimension(640, 60));
		
		ButtonListener listener = new ButtonListener();
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		
		b10 = new JButton("0");
		b10.addActionListener(listener);
		b10.getInputMap(map).put(KeyStroke.getKeyStroke("0"), "pressed");
		b10.getActionMap().put("pressed", new Action0("pressed"));
		
		b11 = new JButton("1");
		b11.addActionListener(listener);
		b11.getInputMap(map).put(KeyStroke.getKeyStroke("1"), "pressed");
		b11.getActionMap().put("pressed", new Action1("pressed"));
		
		b12 = new JButton("2");
		b12.addActionListener(listener);
		b12.getInputMap(map).put(KeyStroke.getKeyStroke("2"), "pressed");
		b12.getActionMap().put("pressed", new Action2("pressed"));
		
		b13 = new JButton("3");
		b13.addActionListener(listener);
		b13.getInputMap(map).put(KeyStroke.getKeyStroke("3"), "pressed");
		b13.getActionMap().put("pressed", new Action3("pressed"));
		
		b14 = new JButton("4");
		b14.addActionListener(listener);
		b14.getInputMap(map).put(KeyStroke.getKeyStroke("4"), "pressed");
		b14.getActionMap().put("pressed", new Action4("pressed"));
		
		b15 = new JButton("5");
		b15.addActionListener(listener);
		b15.getInputMap(map).put(KeyStroke.getKeyStroke("5"), "pressed");
		b15.getActionMap().put("pressed", new Action5("pressed"));
		
		b16 = new JButton("6");
		b16.addActionListener(listener);
		b16.getInputMap(map).put(KeyStroke.getKeyStroke("6"), "pressed");
		b16.getActionMap().put("pressed", new Action6("pressed"));
		
		b17 = new JButton("7");
		b17.addActionListener(listener);
		b17.getInputMap(map).put(KeyStroke.getKeyStroke("7"), "pressed");
		b17.getActionMap().put("pressed", new Action7("pressed"));
		
		b18 = new JButton("8");
		b18.addActionListener(listener);
		b18.getInputMap(map).put(KeyStroke.getKeyStroke("8"), "pressed");
		b18.getActionMap().put("pressed", new Action8("pressed"));
		
		b19 = new JButton("9");
		b19.addActionListener(listener);
		b19.getInputMap(map).put(KeyStroke.getKeyStroke("9"), "pressed");
		b19.getActionMap().put("pressed", new Action9("pressed"));
		
		enter = new JButton("Enter");
		enter.addActionListener(listener);
		enter.getInputMap(map).put(KeyStroke.getKeyStroke("ENTER"), "pressed");
		enter.getActionMap().put("pressed", new ActionE("pressed"));
		
		back = new JButton("Backspace");
		back.addActionListener(listener);
		back.getInputMap(map).put(KeyStroke.getKeyStroke("BACK_SPACE"), "pressed");
		back.getActionMap().put("pressed", new ActionB("pressed"));
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(listener);
		
		add(b10);
		add(b11);
		add(b12);
		add(b13);
		add(b14);
		add(b15);
		add(b16);
		add(b17);
		add(b18);
		add(b19);
		add(enter);
		add(back);
		add(cancel);
	}
	
	public void keypad(ActionEvent e){
		Object source = e.getSource();
		JTextField input = CenterPanel.getInput();
		String text = input.getText();
		int last = text.length() - 1;
		int count = CenterPanel.getCount();
			
		switch(count){
			case 0:
				if(source == b10) input.setText(input.getText() + "0");
				else if(source == b11) input.setText(input.getText() + "1");
				else if(source == b12) input.setText(input.getText() + "2");
				else if(source == b13) input.setText(input.getText() + "3");
				else if(source == b14) input.setText(input.getText() + "4");
				else if(source == b15) input.setText(input.getText() + "5");
				else if(source == b16) input.setText(input.getText() + "6");
				else if(source == b17) input.setText(input.getText() + "7");
				else if(source == b18) input.setText(input.getText() + "8");
				else if(source == b19) input.setText(input.getText() + "9");
				else if(source == back) input.setText(text.substring(0, last));
				else if(source == cancel) EastPanel.enterCard();
				else if(source == enter) EastPanel.enterPin();
				break;
			case 1:
				if(source == b10) input.setText(input.getText() + "0");
				else if(source == b11) input.setText(input.getText() + "1");
				else if(source == b12) input.setText(input.getText() + "2");
				else if(source == b13) input.setText(input.getText() + "3");
				else if(source == b14) input.setText(input.getText() + "4");
				else if(source == b15) input.setText(input.getText() + "5");
				else if(source == b16) input.setText(input.getText() + "6");
				else if(source == b17) input.setText(input.getText() + "7");
				else if(source == b18) input.setText(input.getText() + "8");
				else if(source == b19) input.setText(input.getText() + "9");
				else if(source == back) input.setText(text.substring(0, last));
				else if(source == cancel) EastPanel.enterCard();
				else if(source == enter) EastPanel.displayAccounts();
				break;
			case 21:
				if(source == b10) input.setText(input.getText() + "0");
				else if(source == b11) input.setText(input.getText() + "1");
				else if(source == b12) input.setText(input.getText() + "2");
				else if(source == b13) input.setText(input.getText() + "3");
				else if(source == b14) input.setText(input.getText() + "4");
				else if(source == b15) input.setText(input.getText() + "5");
				else if(source == b16) input.setText(input.getText() + "6");
				else if(source == b17) input.setText(input.getText() + "7");
				else if(source == b18) input.setText(input.getText() + "8");
				else if(source == b19) input.setText(input.getText() + "9");
				else if(source == back) input.setText(text.substring(0, last));
				else if(source == cancel) EastPanel.enterCard();
				if(source == enter) WestPanel.promptUser();
		}
		
	}
	
	public void keypad(String num){
		JTextField input = CenterPanel.getInput();
		input.setText(input.getText() + num);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			keypad(event);
		}
	}
	
	private class Action0 extends AbstractAction{
		public Action0(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("0");
		}
	}
	
	private class Action1 extends AbstractAction{
		public Action1(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("1");
		}
	}
	
	private class Action2 extends AbstractAction{
		public Action2(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("2");
		}
	}
	
	private class Action3 extends AbstractAction{
		public Action3(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("3");
		}
	}
	
	private class Action4 extends AbstractAction{
		public Action4(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("4");
		}
	}
	
	private class Action5 extends AbstractAction{
		public Action5(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("5");
		}
	}
	
	private class Action6 extends AbstractAction{
		public Action6(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("6");
		}
	}
	
	private class Action7 extends AbstractAction{
		public Action7(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("7");
		}
	}
	
	private class Action8 extends AbstractAction{
		public Action8(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("8");
		}
	}
	
	private class Action9 extends AbstractAction{
		public Action9(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			keypad("9");
		}
	}
	
	private class ActionE extends AbstractAction{
		public ActionE(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			if(count == 0) EastPanel.enterPin();
			else if(count == 1) EastPanel.displayAccounts();
			else if(count == 21) WestPanel.promptUser();
		}
	}
	
	private class ActionB extends AbstractAction{
		public ActionB(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			if(count == 0 || count == 1 || count == 21){
				JTextField input = CenterPanel.getInput();
				String text = input.getText();
				int last = text.length() - 1;
				
				input.setText(text.substring(0, last));
			}
		}
	}
} 
