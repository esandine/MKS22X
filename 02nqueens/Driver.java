public class Driver{
    public static void main(String[]args){
	QueenBoard b1 = new QueenBoard(5);
	System.out.println(b1);
	System.out.println(b1.placeQueen(2,3));
	System.out.println(b1.placeQueen(3,4));
	System.out.println(b1.placeQueen(0,0));
	System.out.println(b1);
	System.out.println(b1.removeQueen(4,2));
	System.out.println(b1.removeQueen(2,3));
	System.out.println(b1);
	System.out.println(b1.printSolution());
	QueenBoard b2 = new QueenBoard(4);
	b2.solve();
	System.out.println(b2.printSolution());
    }
}
