public class Driver{
    public static void main(String [] args){
	MyDeque<Double> m1 = new MyDeque<Double>();
	double randValue;
	for(int i = 0;i<100;i++){
	    randValue=Math.random()*2;
	    if(randValue<1){
		m1.addFirst(randValue*100);
	    }else{
		m1.addFirst(randValue*100);
	    }
	}					
	System.out.println(m1);

    }
}
