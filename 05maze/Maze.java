import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
	animate = ani;	
        startx = -1;
	starty = -1;
	try{
	File f1 = new File(filename);
	Scanner s1 = new Scanner(f1);
	String currentLine = "";
	int rows = 0;
	int n = 0;
	while(s1.hasNextLine()){
	    //n++;
	    currentLine = s1.nextLine();
	    //System.out.println(currentLine);
	    rows+=1;
	    //System.out.println(n);
	}
	maze = new char[currentLine.length()][rows];
	Scanner s2 = new Scanner(f1);
	int row = 0;
	while(s2.hasNextLine()){
	    currentLine = s2.nextLine();
	    //System.out.println(currentLine);
	    for(int i = 0;i<currentLine.length();i++){
		maze[i][row]=currentLine.charAt(i);
		if(maze[i][row]=='S'){
		    startx = row;
		    starty = i;
		}
	    }
	    row++;
	}}catch(FileNotFoundException e){
	    System.out.println("no file found");
	}
        //COMPLETE CONSTRUCTOR
    }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
	if(maze[x][y]=='E'){
	    return true;
	}
       	return branch(x+1,y)||
	    branch(x-1,y)||
	    branch(x,y+1)||
	    branch(x,y-1);
	/*
	if(isFree(x+1,y)){
	    return solve(x+1,y);
	}else if(isFree(x-1,y)){
	    return solve(x-1,y);
	}else if(isFree(x,y+1)){
	    return solve(x,y+1);
	}else if(isFree(x,y-1)){
	    return solve(x,y-1);
	}
	maze[x][y]='.';
	return false;
	/*return  solve(x+1,y)||
	   solve(x-1,y)||
	   solve(x,y+1)||
	    solve(x,y-1);{
	    maze[x][y]= '@';
	}else{
	    maze[x][y]='.';
	}
        //so it compiles
	if(!((maze[x+1][y]==' ')||
	   (maze[x-1][y]==' ')||
	   (maze[x][y+1]==' ')||
	     (maze[x][y-1]==' '))){
	    maze[x][y]='.';
	    System.out.println("Dot me");
	    return false;
	    }*/

	}
    private boolean isFree(int x,int y){
	if(maze[x][y]=='E'){
	    //System.out.println("Yooooo");
	    return true;
	}
	if(maze[x][y]==' '){
	    maze[x][y]='@';
	    return true;
	}

	return false;
    }
    private boolean branch(int x, int y){
	if(isFree(x,y)){
	    if(solve(x,y)){
		return true;
	    }else{
		maze[x][y]='.';
	    }
	}
	return false;
    }

    //FREE STUFF!!! *you should be aware of this*

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i % maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(32,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }

    //MORE FREE STUFF!!! *you can ignore all of this*
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    
    //END FREE STUFF



}
