import java.util.*;
public class RunningMedian{
    private MyHeap<Integer> smaller;
    private MyHeap<Integer> bigger;
    public RunningMedian(){
	smaller = new MyHeap<Integer>(true);
	bigger = new MyHeap<Integer>(false);
    }
    public double getMedian(){
	if(smaller.size()+bigger.size()==0){
	    throw new NoSuchElementException();
	}
	if(smaller.size()>bigger.size()){
	    return smaller.peek();
	}else if(smaller.size()<bigger.size()){
	    return bigger.peek();
	}else{//same size
	    return (bigger.peek()+smaller.peek())/2;
	}
    }
    public void add(Integer x){
	if(smaller.size()+bigger.size()==0){
	    smaller.add(x);
	}
	else if(x<getMedian()){
	    smaller.add(x);
	    if(smaller.size()-bigger.size()>1){
		bigger.add(smaller.delete());
	    }
	}else{
	    bigger.add(x);
	    if(bigger.size()-smaller.size()>1){
		smaller.add(bigger.delete());
	    }
	}
    }
}
