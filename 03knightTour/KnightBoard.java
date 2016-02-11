public class KnightBoard{
    private int[][] board;
    private boolean DEBUG = true;
    private int[] possibleMoves = {2,-1,2,1,1,-2,1,2,-1,-2,-1,1,-2,1,-2,-1};
    public KnightBoard(int n){
	board = new int[n][n];
    }
    public void printSolution(){
	String retStr = "Board:";
	for(int row = 0;row<board.length;row++){
	    retStr += "\n";
	    for(int col = 0;col<board[row].length;col++){
		retStr += " ";
		retStr+=board[row][col];
	    }
	}
	System.out.println(retStr);
    }
}
