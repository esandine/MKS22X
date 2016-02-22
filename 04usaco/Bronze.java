import java.io.*;
import java.util.*;
public class Bronze{
    private String file;
    private int rows;
    private int cols;
    private int elevation;
    private int steps;
    public Bronze(String fileName){
	file="";
	rows = 0;
	cols = 0;
	elevation = 0;
	steps = 0;
	String currentLine="";
	int lineNumber = 0;
	Scanner s2 = new Scanner(currentLine);
	try{
	    File f1 = new File(fileName);
	    Scanner s1 = new Scanner(f1);
	    while(s1.hasNextLine()){
		//file+="hello";
		currentLine = s1.nextLine();
		s2 = new Scanner(currentLine);
		if(lineNumber== 0&&currentLine.length()>7){
		    int index = 0;
		    rows=Integer.parseInt(s2.next());
		    s2.next();
		    s2.next();
		    //while(currentLine.charAt(index)!=' '){
		    //rows = rows * 10 + Integer.parseInt(""+currentLine.charAt(index));
		    //index += 1;
		    //}
		file+="\n";
		}
	    }
	}
       catch(FileNotFoundException e){
	    System.out.println("No file found");
	}
    }
    public String toString(){
	return file;
    }
    public int getRows(){
	return rows;
    }
}
