import java.io.*;
import java.util.*;
public class Bronze{
    private String file;
    private int rows;
    private int cols;
    private int elevation;
    private int steps;
    private int[][]farm;
    private int[][]commands;
    public Bronze(String fileName){
	file="";
	rows = 0;
	cols = 0;
	elevation = 0;
	steps = 0;
	farm = new int[0][0];
	commands=new int[0][0];
	String currentLine="";
	int lineNumber = 0;
	try{
	    File f1 = new File(fileName);
	    Scanner s1 = new Scanner(f1);
	    while(s1.hasNextLine()){
		//file+="hello";
		currentLine = s1.nextLine();
		//DEALS WITH THE FIRST LINE:
		if(lineNumber== 0){
		    int index = 0;
		    int value = 0;
		    while(index<currentLine.length()){
			if(currentLine.charAt(index)==' '){
				if(value == 0){
				    //System.out.println(currentLine.substring(0,index));
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
		farm = new int[rows][cols];
		commands = new int[steps][3];
	    //DEALS WITH THE ARRAY
		}else if(lineNumber<rows+1){
		int index = 0;
		int value = 0;
		//System.out.println("yo");
		while(index<currentLine.length()){
			if(currentLine.charAt(index)==' '){
			    //System.out.println(Integer.parseInt(currentLine.substring(0,index)));
			    farm[lineNumber-1][value]=Integer.parseInt(currentLine.substring(0,index));
			    value+=1;
			    currentLine=currentLine.substring(index+1,currentLine.length());
			    index = 0;
			}else{
			    index+=1;
			}
		}
		farm[lineNumber-1][value]=Integer.parseInt(currentLine);
		//DEALS WITH THE STEPS
		}else{
		int index = 0;
		int value = 0;
		while(index<currentLine.length()){
		       	if(currentLine.charAt(index)==' '){
			    //System.out.println(Integer.parseInt(currentLine.substring(0,index)));
			    commands[lineNumber-1-rows][value]=Integer.parseInt(currentLine.substring(0,index));
			    value+=1;
			    currentLine=currentLine.substring(index+1,currentLine.length());
			    index = 0;
			}else{
			    index+=1;
			}
		}
		commands[lineNumber-1-rows][value]=Integer.parseInt(currentLine);
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
    public void printFarm(){
	String retStr = "";
	for(int i = 0;i< farm.length;i++){
	    retStr+="\n";
	    for(int ii = 0;ii<farm[i].length;ii++){
		retStr+=farm[i][ii];
		retStr+=" ";
	    }
	}
	System.out.println(retStr);
    }
    public void printCommands(){
	String retStr = "";
	for(int i = 0;i< commands.length;i++){
	    retStr+="\n";
	    for(int ii = 0;ii<commands[i].length;ii++){
		retStr+=commands[i][ii];
		retStr+=" ";
	    }
	}
	System.out.println(retStr);
    }
    public int calcVolume(){
	int retValue = 0;
	for(int i = 0;i< farm.length;i++){
	    for(int ii = 0;ii<farm[i].length;ii++){
		if(farm[i][ii]<elevation){
		    retValue+=72*72*(elevation-farm[i][ii]);
		}
	    }
	}
	return retValue;
    }
    public void stomp(int n){
	int row = commands[n][0];
	int col = commands[n][1];
	int far = commands[n][2];
	int max = farm[row][col];
	//System.out.println(row);
	//System.out.println(col);
	//System.out.println(far);
	for(int i = -1; i < 2; i++){
	    for(int ii = -1;ii<2;ii++){
		if(farm[row+i][col+ii]>max){
		    max = farm[row+i][col+ii];
		}
	    }
	}
	//System.out.println(max-far);
	for(int i = -1; i < 2; i++){
	    for(int ii = -1;ii<2;ii++){
		if(farm[row+i][col+ii]>(max-far)){
		    farm[row+i][col+ii]=(max-far);
		}
	    }
	}
    }
    public void stompsalot(){
	for(int i  = 0;i<steps;i++){
	    stomp(i);
	}
    }
    public static void main(String[] args){
	Bronze b1 = new Bronze("makelake.in");
	b1.stompsalot();
	System.out.println(""+b1.calcVolume()+"6,Sandine,Ely");
    }
	
}
