public class Driver{
    public static void main(String[]args){
	/*QueenBoard b1 = new QueenBoard(5);
	System.out.println(b1);
	System.out.println(b1.placeQueen(2,3));
	System.out.println(b1.placeQueen(3,4));
	System.out.println(b1.placeQueen(0,0));
	System.out.println(b1);
	System.out.println(b1.removeQueen(4,2));
	System.out.println(b1.removeQueen(2,3));
	System.out.println(b1);
	System.out.println(b1.printSolution());*/
	QueenBoard[] boards = new QueenBoard[10];
	for(int n = 0;n<10;n++){
	    boards[n]=new QueenBoard(n);
	}
	for(int i = 0;i<boards.length;i++){
	    System.out.println(i);
	    System.out.println(boards[i].solve());
	    System.out.println(boards[i].printSolution());
	}
    }
}
