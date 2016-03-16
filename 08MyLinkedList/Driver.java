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
	System.out.println(l1.size());
	System.out.println(l1.get(2));
    }
}
