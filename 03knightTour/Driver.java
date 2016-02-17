public class Driver{
    public static void main(String[]args){
	KnightBoard b1 = new KnightBoard(5);
	System.out.println(b1.solve());
	b1.printSolution();
    }
}
