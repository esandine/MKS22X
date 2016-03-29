public class Driver{
    public static void main(String[]args){
	MyQueue<String> q1 = new MyQueue<String>();
	MyStack<String> s1 = new MyStack<String>();
	q1.enqueue("hello");
	s1.push("heyo");
	q1.enqueue("bye");
	s1.push("byo");
	System.out.println(q1.dequeue());
	System.out.println(s1.pop());
    }
}