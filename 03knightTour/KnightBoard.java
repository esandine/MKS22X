public class KnightBoard{
    private int[][] board;
    private boolean DEBUG = true;
    private int[] possibleMoves = {2,-1,2,1,1,-2,1,2,-1,-2,-1,1,-2,1,-2,-1};
    public KnightBoard(int n, int m){
	board = new int[n][m];
    }
    public KnightBoard(int n){
	this(n,n);
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
    public boolean solve(){
	return solve(0,0,0,0);
    }
    public boolean solve(int x, int y, int ctr, int try){
	if(ctr == board.length*board[0].length){
	    return true;
	}
	if(isValidSpot(x+possibleMoves[try*2],y+possibleMoves[try*2+1])){
	    return solve(x+possibleMoves[try*2],y+possibleMoves[try*2+1]
    }
    public boolean isValidSpot(int x, int y){
	if((x>board.length)||(y>board[0].length)||(board[x,y]!=0)){
	    return false;
	}
	return true;
    }
}
