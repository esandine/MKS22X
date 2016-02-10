public class Board{
    public int[][] board;
    public Board(int[][] Board){
	board=new int[Board.length][Board[0].length];
	for(int row = 0;row<Board.length;row++){
	    for(int col=0;col<Board[row].length;col++){
		board[row][col]=Board[row][col];
	    }
	}
    }
    public Board(int n){
	board = new int[n][n];
	for(int row = 0;row<n;row++){
	    for(int col = 0;col<n;col++){
		board[row][col]=0;
	    }
	}
    }
    public String toStringDebug(){
	String retStr = "";
	for(int row = 0;row<board.length;row++){
	    retStr+="\n";
	    for(int col = 0;col<board[row].length;col++){
		retStr+=board[row][col];
		retStr+=" ";
	    }
	}
	return retStr;
    }
    public String toString(){
	String retStr = "";
	for(int row = 0;row<board.length;row++){
	    retStr+="\n";
	    for(int col = 0;col<board[row].length;col++){
		if(board[row][col]>0){
		    retStr+="Q";
		}else{
		    retStr+="e";
		}
		retStr+=" ";
	    }
	}
	return retStr;
    }
    public boolean placeQueen(int row, int col){
	if(!(board[row][col]==0)){
	    return false;
	}
	for(int r = 0;r<board.length;r++){
	    for(int c = 0;c<board.length;c++){
		if((r==row)||(c==col)||(r-c==row-col)||(r+c==row+col)){
		    board[r][c]-=1;
		}
	    }
	}
	board[row][col]=1;
	return true;
    }
}