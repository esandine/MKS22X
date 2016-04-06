public class Driver{
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
