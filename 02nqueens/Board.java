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
}