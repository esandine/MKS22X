public class Driver{
    public static void main(String [] args){
	MyDeque<Integer> m1 = new MyDeque<Integer>();
	m1.addLast(3);
	m1.addFirst(5);
	m1.addLast(3);
	m1.addLast(3);
	m1.addFirst(5);
	m1.addLast(3);
	m1.addLast(3);
	m1.addLast(3);
	m1.addFirst(5);
	System.out.println(m1);
	System.out.println(m1.printData());
	m1.addLast(3);
	System.out.println("Start"+ m1.getStart());
	System.out.println("End"+m1.getEnd());/*
	m1.addLast(3);
	m1.addLast(3);
	m1.addLast(3);
	m1.addFirst(5);
	m1.addLast(3);
	m1.addLast(3);*/

	System.out.println(m1);
    }
}
