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
	try{
	    File f1 = new File(fileName);
	    Scanner s1 = new Scanner(f1);
	    while(s1.hasNextLine()){
		//file+="hello";
		currentLine = s1.nextLine();
		if(lineNumber== 0){
		    int index = 0;
		    int value = 0;
		    while(index<currentLine.length()){
			if(currentLine.charAt(index)==' '){
				if(value == 0){
				    System.out.println(currentLine.substring(0,index));
				    rows=Integer.parseInt(currentLine.substring(0,index));
				    value+=1;
				}else if(value == 1){
				    cols=Integer.parseInt(currentLine.substring(0,index));
				    value+=1;
				}else{
				    elevation=Integer.parseInt(currentLine.substring(0,index));
				    value+=1;
				}
				//System.out.println(index);
				currentLine=currentLine.substring(index+1,currentLine.length());
				index = 0;
			}else{
				index+=1;
			}
			
		    }
		    steps=Integer.parseInt(currentLine);
       		    //while(currentLine.charAt(index)!=' '){
		    //rows = rows * 10 + Integer.parseInt(""+currentLine.charAt(index));
		    //index += 1;
		    //}
		}
		lineNumber+=1;
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
    public int getCols(){
	return cols;
    }
    public int getElevation(){
	return elevation;
    }
    public int getSteps(){
	return steps;
    }
}
