public class Silver{
    private char[][] data;
    private int R1;
    private int C1;
    private int R2;
    private int C2;
    public Silver(String filename){
	try{
	    File f1 = new File(filename);
	    Scanner s1 = new Scanner(f1);
	    String currentLine = "";
	    int rows = 0;
	    int n = 0;
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
	    }
	}catch(FileNotFoundException e){
	    System.out.println("no file found");
	}
}
