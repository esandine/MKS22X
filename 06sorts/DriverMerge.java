public class DriverMerge{
    public static void main(String[]args){
	int [] data = {6,5,4,3,45,23,2,1,5,6,6,6,8,};
	int[] tester = {5,6,3,4};
	Sorts.printArray(tester);
	tester = Sorts.merge(tester,3,3,3,3);
	Sorts.printArray(tester);
	System.out.println("Done testing");
	Sorts.printArray(data);
	Sorts.mergesort(data);
	Sorts.printArray(data);
    }
}
