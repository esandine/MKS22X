public class Driver{
    public static void main(String[] args){
	BSTree<Integer> t1= new BSTree<Integer>();
	t1.add(3);
	t1.add(1);
	t1.add(2);
	t1.add(456456);
	System.out.println(t1);
	System.out.println(t1.getHeight());
	System.out.println(t1.contains(2));
	System.out.println(t1.contains(6));
    }
}