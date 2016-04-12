import java.util.*;
public class Driver{
    public static void main(String[]args){
	BetterMaze m1 = new BetterMaze("data1.dat");
	m1.solveBFS();
	System.out.println(m1.solve());
	System.out.println(m1);

	System.out.println(Arrays.toString(m1.solutionCoordinates()));
    }
}