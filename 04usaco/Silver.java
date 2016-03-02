import java.io.*;
import java.util.*;
public class Silver{
    private static boolean debug  = false;
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
	    }
	}catch(FileNotFoundException e){
	    System.out.println("no file found");
	}
    }
    public int[][] solveIter(int[][] board){
	int val = 0;
	int[][] retBoard = new int[board.length][board[0].length];
	for(int r = 0;r<board.length;r++){
	    for(int c = 0;c<board[r].length;c++){
		if(board[r][c]!=-1){
		if((c>0) && (board[r][c-1]!=-1)){
		    retBoard[r][c]+=board[r][c-1];
		}
		if((c<board[r].length-1) && (board[r][c+1]!=-1)){
		    retBoard[r][c]+=board[r][c+1];
		}
		if((r>0) && (board[r-1][c]!=-1)){
		    retBoard[r][c]+=board[r-1][c];
		}
		if((r<board.length-1) && (board[r+1][c]!=-1)){
		    retBoard[r][c]+=board[r+1][c];
		}
		}else{
		    retBoard[r][c]= -1;
		}
	    }
	}
	return retBoard;
    }
    public int[][] toIntArray(){
	int[][] retBoard 
= new int[data.length][data[0].length];
	for(int r = 0;r<data.length;r++){
	    for(int c = 0;c<data[0].length;c++){
		if(data[r][c]=='*'){
		    retBoard[r][c]=-1;
		}else{
		    retBoard[r][c]=0;
		}
	    }
	}
	retBoard[R1-1][C1-1]=1;
	return retBoard;
    }
    public static void printData(char[][] data){
	String current = "";
	for(int r = 0;r<data.length;r++){
	    current = "";
	    for(int c = 0;c<data[0].length;c++){
		current+=data[r][c];
	    }
	    debug(current);
	}
    }
    public static void printData(int[][] data){
	String current = "";
	for(int r = 0;r<data.length;r++){
	    current = "";
	    for(int c = 0;c<data[0].length;c++){
		current+=data[r][c];
	    }
	    debug(current);
	}
    }
    public int getTime(){
	return time;
    }
    public int solve(){
	int [][] board = toIntArray();
	printData(board);
	for(int i = 0;i<time;i++){
	    board = solveIter(board);
	    printData(board);
	}
	return board[R2-1][C2-1];
    }
    public static void main(String[]args){
	Silver s1 = new Silver("ctravel.in");
	/*debug(s1.R1);
	debug(s1.C1);
	debug(s1.R2);
	debug(s1.C2);
	printData(s1.data);
	printData(s1.toIntArray());*/
	String retStr = "";
	retStr+=s1.solve();
	retStr+=",Sandine,Ely,6";
	System.out.println(retStr);
    }
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}
