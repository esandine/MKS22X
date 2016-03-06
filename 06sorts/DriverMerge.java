public class DriverMerge{
    public static void main(String[]args){
	int [] data = {6,5,4,3,6,2,5,1};
	Sorts.printArray(data);
	Sorts.mergeSort(data);
	Sorts.printArray(data);
    }
}
