/*public class Driver{
    public static void main(String [] args){
	MyDeque<Double> m1 = new MyDeque<Double>();
	m1.addFirst(1.0);
	m1.addFirst(2.0);
	m1.addLast(3.0);
	System.out.println(m1.removeFirst());
	System.out.println(m1.removeLast());
	System.out.println(m1.removeLast());
	m1.addFirst(1.0);
	m1.addFirst(2.0);
	m1.addLast(3.0);
	System.out.println(m1.getLast());
	System.out.println(m1.getFirst());
	double randValue;
	for(int i = 0;i<100;i++){
	    randValue=Math.random()*2;
	    if(randValue<1){
		m1.addFirst(randValue*100);
	    }else{
		m1.addLast(randValue*100);
	    }
	}					
	System.out.println(m1);

    }
}
*/
import java.util.*;
public class Driver{
    public static void main(String[] args) {
	MyDeque<Integer> a = new MyDeque<Integer>();
	Deque<Integer> b = new ArrayDeque<Integer>();
	Random r = new Random();
	for(int i =0; i < 10000;i++){
	    int c;
	    c = r.nextInt(40);
	    //this way the same number is added to both a and b
	    a.addFirst(c);
	    b.addFirst(c);
	}
   
	//System.out.println(a==b); //assuming that there is a toString for MyDeque
	//System.out.println(b); //assuming that there is a toString for Deque
	int counter=0;
	while(counter < 10000 && !a.isEmpty() && !b.isEmpty()){
	    int op = r.nextInt(4);
	    if(op == 0){
		if(a.removeFirst()!=b.removeFirst()){
		    System.out.println("removeFirst Error");
		    return;
		}
	    }else if(op == 1){
		if(a.removeLast()!=b.removeLast()){
		    System.out.println("removeLast Error");
		    return;
		}
	    }else if(op == 2){
		if(a.getFirst()!=b.getFirst()){
		    System.out.println("getFirst Error");
		    return;
		}
	    }else if(op == 3){
		if(a.getLast()!=b.getLast()){
		    System.out.println("getLast Error");
		    return;
		}
	    }
	    counter++;
	}
	MyDeque d = new MyDeque();
 
	try{
 
	    d.removeFirst();
 
	}catch(NoSuchElementException e){
 
	    System.out.println("removeFirst works");
 
	}
 
 
 
 
	try{
 
	    d.removeLast();
 
	}catch(NoSuchElementException e){
 
	    System.out.println("removeLast works");
 
	}
 
 
 
	try{
 
	    d.getFirst();
 
	}catch(NoSuchElementException e){
 
	    System.out.println("getFirst works");
 
	}
 
 
 
 
	try{
 
	    d.getLast();
 
	}catch(NoSuchElementException e){
 
	    System.out.println("getLast works");
 
	}
    }
}