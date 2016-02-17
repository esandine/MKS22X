public class Driver{
    public static void main(String[]args){
	KnightBoard[] knights = new KnightBoard[8];
	for(int n = 0;n<8;n++){
	    knights[n]=new KnightBoard(n+1);
	    knights[n].solve();
	    knights[n].printSolution();
	}
	KnightBoard b1 = new KnightBoard(5);
	System.out.println(b1.solve());
	b1.printSolution();
    }
}
