public class Driver{
    public static void main(String[] args){
	Bronze b1 = new Bronze("hello.txt");
	System.out.println(b1);
	System.out.println("test rows");
	System.out.println(b1.getRows());
	System.out.println(b1.getCols());
	System.out.println(b1.getElevation());
	System.out.println(b1.getSteps());
	System.out.println("test farm");
	b1.printFarm();
	b1.printCommands();
	System.out.println(b1.calcVolume());
	b1.printFarm();
	b1.stompsalot();
	b1.printFarm();
	System.out.println(b1.calcVolume());
    }
}
