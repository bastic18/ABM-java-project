package bank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EastPanel extends JPanel{
	private static JButton b5, b6, b7, b8;
	JPanel buttonPanel, b5Panel, b6Panel, b7Panel, b8Panel;
	static Lab5Main abm;
	static String idin, idin1;
	
	public EastPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(160, 480));
		
		abm = new Lab5Main();
		
		int map = JComponent.WHEN_IN_FOCUSED_WINDOW;
		
		Dimension button = new Dimension(100, 60);
		ButtonListener listener = new ButtonListener();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		b5Panel = new JPanel();
		b6Panel = new JPanel();
		b7Panel = new JPanel();
		b8Panel = new JPanel();
		
		PAction p = new PAction("pressed");
		OAction o = new OAction("pressed");
		KAction k = new KAction("pressed");
		MAction m = new MAction("pressed");
		
		b5 = new JButton();
		b5.setPreferredSize(button);
		b5.addActionListener(listener);
		b5.getInputMap(map).put(KeyStroke.getKeyStroke("P"), "pressed");
		b5.getActionMap().put("pressed", p);
		
		b6 = new JButton();
		b6.setPreferredSize(button);
		b6.addActionListener(listener);
		b6.getInputMap(map).put(KeyStroke.getKeyStroke("O"), "pressed");
		b6.getActionMap().put("pressed", o);
		
		b7 = new JButton();
		b7.setPreferredSize(button);
		b7.addActionListener(listener);
		b7.getInputMap(map).put(KeyStroke.getKeyStroke("K"), "pressed");
		b7.getActionMap().put("pressed", k);
		
		b8 = new JButton("Continue");
		b8.addActionListener(listener);
		b8.setPreferredSize(button);
		b8.getInputMap(map).put(KeyStroke.getKeyStroke("M"), "pressed");
		b8.getActionMap().put("pressed", m);
		
		b5Panel.add(b5);
		b6Panel.add(b6);
		b7Panel.add(b7);
		b8Panel.add(b8);
		
		buttonPanel.add(Box.createVerticalGlue());
		buttonPanel.add(b5Panel);
		buttonPanel.add(b6Panel);
		buttonPanel.add(b7Panel);
		buttonPanel.add(b8Panel);
		buttonPanel.add(Box.createVerticalGlue());
		
		add(Box.createVerticalGlue());
		add(buttonPanel);
		add(Box.createVerticalGlue());
	}
	
	public static void setBText(JButton b, String str){
		b.setText(str);
	}
	
	public static JButton getB5(){
		return b5;
	}
	
	public static JButton getB6(){
		return b6;
	}
	
	public static JButton getB7(){
		return b7;
	}
	
	public static JButton getB8(){
		return b8;
	}
	
	public static void enterPin(){
		setId(CenterPanel.getInput().getText());
		CenterPanel.getInput().setText("");
		b8.setText("Continue");
		CenterPanel.setLabel("Enter Pin", CenterPanel.getPrompt());
		CenterPanel.setDisplay("Please enter a valid pin to be checked and process");
		
		
		CenterPanel.setCount(1);
	}
	
	public static void displayAccounts(){
		setId1(CenterPanel.getInput().getText());
		
		if(abm.password(getId()).equalsIgnoreCase(getId1())){
			b8.setText("Cancel");
			CenterPanel.setLabel("", CenterPanel.getPrompt());
			CenterPanel.getInput().setText("");
			CenterPanel.removeField();
			CenterPanel.setDisplay(Menu.getDisplay());
			WestPanel.setBText(WestPanel.getB1(), "1");
			WestPanel.setBText(WestPanel.getB2(), "2");
			WestPanel.setBText(WestPanel.getB3(), "3");
			WestPanel.setBText(WestPanel.getB4(), "4");
			CenterPanel.setCount(2);
		}else{
			CenterPanel.setDisplay("Unknown Card or Invalid Pin");
			CenterPanel.setCount(0);
		}
	}
	
	public static String getId(){
		return idin;
	}
	
	public static void setId(String str){
		idin = str;
	}
	
	public static String getId1(){
		return idin1;
	}
	
	public static void setId1(String str){
		idin1 = str;
	}
	
	public static void enterCard(){
		CenterPanel.getInput().setText("");
		b8.setText("Continue");
		CenterPanel.setLabel("Enter Card Number", CenterPanel.getPrompt());
		CenterPanel.addField();
		CenterPanel.clearDisplay();
		
		WestPanel.setBText(WestPanel.getB1(), "");
		WestPanel.setBText(WestPanel.getB2(), "");
		WestPanel.setBText(WestPanel.getB3(), "");
		WestPanel.setBText(WestPanel.getB4(), "");
		
		CenterPanel.setDisplay("Please enter a valid card number to be checked and process");
		
		CenterPanel.setCount(0);
	}
	
	public void exit(){
		Abm.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CenterPanel.setDisplay("You may now exit by clicking the \"X\" at the top right hand corner.");
		b5.setText(null);
		b6.setText(null);
		b7.setText(null);
		b8.setText(null);
		WestPanel.setBText(WestPanel.getB1(), null);
		WestPanel.setBText(WestPanel.getB2(), null);
		WestPanel.setBText(WestPanel.getB3(), null);
		WestPanel.setBText(WestPanel.getB4(), null);
	}
	
	private class ButtonListener implements ActionListener{
		public  void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			if(event.getSource() == b8){
				if(count == 0){
					enterPin();
				}else if(count == 1){
					displayAccounts();
				}else if (count > 1 && count < 5){
					enterCard();
				}else if(count == 20){
					WestPanel.promptUser();
				}else if(count == 21){
					WestPanel.storeAmount();
				}
			}
			
		}
	}
	
	private class PAction extends AbstractAction{
		public PAction(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			if(count == 13){
				exit();
			}
		}
	}
	
	private class OAction extends AbstractAction{
		public OAction(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){}
	}
	
	private class KAction extends AbstractAction{
		public KAction(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){}
	}
	
	private class MAction extends AbstractAction{
		public MAction(String name){
			super(name);
		}
		
		public void actionPerformed(ActionEvent event){
			int count = CenterPanel.getCount();
			
			if(count == 0){
				enterPin();
			}else if(count == 1){
				displayAccounts();
			}else if (count > 1 && count < 5){
				enterCard();
			}else if(count == 20){
				WestPanel.storeAmount();
			}else if(count == 21){
				WestPanel.promptUser();
			}
		}
	}
}