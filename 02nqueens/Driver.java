public class Driver{
    public static void main(String[]args){
	Board b1 = new Board(5);
	System.out.println(b1);
	System.out.println(b1.placeQueen(2,3));
	System.out.println(b1.placeQueen(3,4));
	System.out.println(b1.placeQueen(0,0));
	System.out.println(b1);
    }
}