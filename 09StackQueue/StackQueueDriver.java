public class StackQueueDriver{
    public static void main(String[]args){
    MyStack<Integer> s1 = new MyStack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    double randVal = 0;
    for(int i = 0; i<1000000; i++){
	randValue = Math.random()*3;
	if(randValue>2){
	    if(s1.pop()!=s2.pop()){
		System.out.println("OH NO");
	    }
	}else{
	    randValue = Math.random()*Integer.MAX_VALUE;
	    s1.push((int)randValue);
	    s2.push((int)randValue);
	}
    }
    }
}
