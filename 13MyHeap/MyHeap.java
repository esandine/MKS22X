import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private int size;
    private boolean max;
    private boolean compare(T t1, T t2){
	if(max){
	    return t1.compareTo(t2)>=0;
	}else{
	    return t1.compareTo(t2)<=0;
	}
    }
    public MyHeap(){
	data = new T[10];
	size=0;
	max=true;
    }
    private void swap(int i, int ii){
	T temp = data[i];
	data[i]=data[ii];
	data[ii]=temp;
    }
    private void pushDown(int k){
	if((k<size()/2)&&
	   !(compare(data[k],data[2*k])&&(compare(data[k],data[2*k+1]))))){
	    if(compare(data[2*k],data[2*k+1])){
		swap(2*k,k);
		pushDown(2*k);
	    }else{
		swap(2*k+1,k);
		pushDown(2*k+1);
	    }
    }
private void pushUp(int k)
	//private void heapify()
	//public T delete()
	//public void add(T x)
	//private void doubleSize()
	//public String toString()

	//do this last
	//public MyHeap(boolean isMax)
	//public MyHeap(T[] array, boolean isMax)

	//}
}
