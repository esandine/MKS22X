public class KnightBoard{
    private int[][] board;
    private boolean DEBUG = true;
    private int[] possibleMoves = {2,-1,2,1,1,-2,1,2,-1,-2,-1,2,-2,1,-2,-1};
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
		if((board[row][col]<10)&&(board.length*board[0].length>10)){
		    retStr+="_";
		}
		retStr+=board[row][col];
	    }
	}
	System.out.println(retStr);
    }
    public boolean solve(){
	return solveIter(0,0,0,0);
    }
    public void revert(int n){
	for(int row = 0;row<board.length;row++){
	    for(int col = 0;col<board.length;col++){
		if(board[row][col]>=n){
		    board[row][col]=0;
		}
	    }
	}
    }
    public boolean solveIter(int x, int y, int ctr, int iter){
	revert(ctr);
	if(ctr == board.length*board[0].length+1){
	    return true;
	}
	if(isValidSpot(x+possibleMoves[iter*2],y+possibleMoves[iter*2+1])){
	    board[x+possibleMoves[iter*2]][y+possibleMoves[iter*2+1]]=ctr;
	    //printSolution();
	    if(iter<7){
		return solveIter(x+possibleMoves[iter*2],y+possibleMoves[iter*2+1],ctr+1,0)||solveIter(x,y,ctr,iter+1);
	    }
	    return solveIter(x+possibleMoves[iter*2],y+possibleMoves[iter*2+1],ctr+1,0);
	}
	if(iter<7){
	    return solveIter(x,y,ctr,iter+1);
	}
	return false;
    }
    public boolean isValidSpot(int x, int y){
	if((x>=board.length)||(x<0)||(y>=board[0].length)||(y<0)||(board[x][y]!=0)){
	    return false;
	}
	return true;
    }
}
