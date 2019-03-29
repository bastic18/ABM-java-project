package bank;

import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CenterPanel extends JPanel{
	static JPanel tPanel, pPanel, dPanel;
	JLabel title, date;
	private static JLabel prompt;
	private static int count = 0;
	private static JTextArea display;
	private static JTextField input;
	
	public CenterPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(640, 420));
		
		Dimension standard = new Dimension(640, 5);
		tPanel = new JPanel();
		pPanel = new JPanel();
		dPanel = new JPanel();
		
		display = new JTextArea("Enter Card Number");
		display.setPreferredSize(new Dimension(640, 200));
		
		title = new JLabel("JLCB Automated Banking Machine", JLabel.CENTER);
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		date = new JLabel(today(), JLabel.CENTER);
		date.setPreferredSize(new Dimension(600, 10));
		input = new JTextField(12);
		input.setBackground(Color.yellow);
		prompt = new JLabel("Enter Card Number", JLabel.CENTER);
		
		tPanel.add(title);
		tPanel.setPreferredSize(new Dimension(640, 20));
		tPanel.add(date);
		dPanel.add(display);
		pPanel.add(prompt);
		pPanel.setPreferredSize(standard);
		pPanel.add(input);
		
		add(tPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(pPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(dPanel);
		add(Box.createVerticalGlue());
	}
	
	public static void setLabel(String str, JLabel label){
		label.setText(str);
	}
	
	public static void setCount(int num){
		count = num;
	}
	
	public static void setDisplay(String str){
		display.setText(str);
	}
	
	public static int getCount(){
		return count;
	}
	
	public static JLabel getPrompt(){
		return prompt;
	}
	
	public static JTextField getInput(){
		return input;
	}
	
	public static void removeField(){
		input.setVisible(false);
	}
	
	public static void addField(){
		input.setVisible(true);
	}
	
	public static void clearDisplay(){
		display.setText("Display Info Here...");
	}
	
	public static String today(){
		Calendar today = Calendar.getInstance();
		today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), 0, 0, 1);
		String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).format(Calendar.getInstance().getTime());
		
		return dateStr;
	}
}