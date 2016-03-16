public class Driver{
    public static void main(String[]args){
	System.out.println("Linked List Driver");
	MyLinkedList l1 = new MyLinkedList();
	System.out.println(l1);
	l1.add(4);
	System.out.println(l1);
	l1.add(3);
	System.out.println(l1);
	l1.add(145345);
	System.out.println(l1);
	l1.set(0,12121212);
	System.out.println(l1);
	System.out.println(l1.size());
	l1.remove(1);
	System.out.println(l1);
	l1.add(2,317);
	System.out.println(l1);
	System.out.println(l1.indexOf(31));
    }
}
