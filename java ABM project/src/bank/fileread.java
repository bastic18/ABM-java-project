package bank;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.io.BufferedWriter;






public class fileread {

	public static ArrayList<String []> Read(String filepath,String delimiter) throws IOException{
		BufferedReader input= new BufferedReader(new FileReader(filepath));
		String line= input.readLine();
		String [] linedata;
		ArrayList<String []> output= new ArrayList<String []>();
		try {
	
		while (line!=null) {
			linedata= line.split(delimiter);
			output.add(linedata);
			line= input.readLine();
			
			
		}
			
		input.close();
		//return output;
		}catch(IOException e){
			
			System.out.println(e);
			System.out.println(" The file cannot be found");
			
		}
		return output;
		
	}
	
	
	
	public static boolean Write(String filepath, ArrayList<String> data, String delimiter) throws IOException{
		
		BufferedWriter writer= new BufferedWriter(new FileWriter(new File (filepath),true));
		String line;
		final int size = data.size();
		try {
		for (int i=0; i<size; i++ ) {
			line= data.get(i);
			writer.append(String.join(delimiter, line) );
			writer.newLine();
		}
		
		writer.close();
		} catch(IOException e) {
			System.out.println(e);
			System.out.println(" The file cannot be found");
		}
		return true;
		
	}
	
	
	
	
	
	
	
	public static boolean Writelist(String filepath, ArrayList<String[]> data, String delimiter) throws IOException{
		
		BufferedWriter writer= new BufferedWriter(new FileWriter(filepath));
		String[] line;
		final int size = data.size();
		try {
		for (int i=0; i<size; i++ ) {
			line= data.get(i);
			writer.write(String.join(delimiter, line) );
			writer.newLine();
		}
		
		writer.close();
		} catch(IOException e) {
			System.out.println(e);
			System.out.println(" The file cannot be found");
		}
		return true;
		
	}
	
	
	
	
}
