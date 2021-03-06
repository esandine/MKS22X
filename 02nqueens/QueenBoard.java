public class QueenBoard{
    public int[][] board;
    public QueenBoard(int[][] Board){
	board=new int[Board.length][Board[0].length];
	for(int row = 0;row<Board.length;row++){
	    for(int col=0;col<Board[row].length;col++){
		board[row][col]=Board[row][col];
	    }
	}
    }
    public QueenBoard(int n){
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
		retStr+=board[row][col];
		retStr+=" ";
	    }
	}
	return retStr;
    }
    public void printSolution(){
	String retStr = "";
	for(int row = 0;row<board.length;row++){
	    retStr+="\n";
	    for(int col = 0;col<board[row].length;col++){
		if(board[row][col]>0){
		    retStr+="Q";
		}else{
		    retStr+="_";
		}
		retStr+=" ";
	    }
	}
	System.out.println(retStr);
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
    public boolean removeQueen(int row,int col){
	if(!(board[row][col]==1)){
	    return false;
	}
	for(int r = 0;r<board.length;r++){
	    for(int c = 0;c<board.length;c++){
		if((r==row)||(c==col)||(r-c==row-col)||(r+c==row+col)){
		    if(board[r][c]>0){
			board[r][c]-=1;
		    }else if(board[r][c]<0){
		    board[r][c]+=1;
		    }
		}
	    }
	}
	return true;
    }
    public boolean solve(){
	return solveH(0);
    }
    public boolean solveH(int col){
	if(col>=board.length){
	    //System.out.println("Its working");
	    return true;
	}
	for(int n = 0;n<board.length;n++){
	    if(placeQueen(col,n)){
		if(solveH(col+1)){
		    return true;
		}else{
		    removeQueen(col,n);
		}
	    }
	}
	return false;
    }
}
