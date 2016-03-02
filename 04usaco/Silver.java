import java.io.*;
import java.util.*;
public class Silver{
    private static boolean debug  = true;
    private char[][] data;
    private int R1;
    private int C1;
    private int R2;
    private int C2;
    private int time;
    public Silver(String filename){
	data = new char[0][0];
	R1 = 0;
	R2 = 0;
	C1 = 0;
	C2 = 0;
	time = 0;
	try{
	    int rows = 0;
	    int cols = 0;
	    File f1 = new File(filename);
	    Scanner s1 = new Scanner(f1);
	    String currentLine = "";
	    int index = 0;
	    if(s1.hasNextLine()){
		currentLine = s1.nextLine();
		boolean first = true;
		while(index<currentLine.length()){
		    if(currentLine.charAt(index)==' '){
			if(first){
			    rows = Integer.parseInt(currentLine.substring(0,index));
			    debug(rows);
			    currentLine=currentLine.substring(index+1);
			    index = 0;
			    first  = false;
			    debug("First time passedc");
			}else{
			    cols = Integer.parseInt(currentLine.substring(0,index));
			    debug(cols);
			    time = Integer.parseInt(currentLine.substring(index+1));
			    index = currentLine.length();
			}
		    }else{
			index++;
		    }
		    
		}
		int counter = 0;
		data = new char[rows][cols];
		while(counter<rows){
		    currentLine = s1.nextLine();
		    for(int i = 0;i<cols;i++){
			data[counter][i]=currentLine.charAt(i);
		    }
		    counter++;
		}
		for(int r = 0;r<data.length;r++){
		    String current = "";
		    for(int c = 0;c<data[r].length;c++){
			current+=data[r][c];
		    }
		    debug(current);
		}
		currentLine = s1.nextLine();
		index = 0;
		int val = 0;
		while(index<currentLine.length()){
		    if(currentLine.charAt(index)==' '){
			if(val == 0){
			    R1 = Integer.parseInt(currentLine.substring(0,index));
			}else if (val == 1){
			    C1 = Integer.parseInt(currentLine.substring(0,index));
			}else if (val == 2){
			    R2 = Integer.parseInt(currentLine.substring(0,index));
			    C2 = Integer.parseInt(currentLine.substring(index+1));
			}
			if(val==2){
			    index = currentLine.length();
			}else{
			currentLine = currentLine.substring(index+1);
			index = 0;
			val++;
			}
		    }else{
			index++;
		    }
		}
	    }/*
	    maze = new char[currentLine.length()][rows];
	    Scanner s2 = new Scanner(f1);
	    int row = 0;
	    while(s2.hasNextLine()){
		currentLine = s2.nextLine();
		//System.out.println(currentLine);
		for(int i = 0;i<currentLine.length();i++){
		    maze[i][row]=currentLine.charAt(i);
		    if(maze[i][row]=='S'){
			starty = row;
			startx = i;
		    }
		}
		row++;
		}*/
	}catch(FileNotFoundException e){
	    System.out.println("no file found");
	}
    }
    public int getTime(){
	return time;
    }
    public static void main(String[]args){
	Silver s1 = new Silver("ctravel.in");
	System.out.println(s1.getTime());
	debug(s1.R1);
	debug(s1.C1);
	debug(s1.R2);
	debug(s1.C2);
    }
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}
