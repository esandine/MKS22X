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
    public MyHeap(boolean isMax){
	data = (T[])new Comparable[10];
	data[0]=null;
	size=0;
	max=isMax;
    }
    public MyHeap(){
	this(true);
    }
    public MyHeap(T[] array,boolean isMax){
	this(isMax);
	data=array;
	heapify();
    }
    private void swap(int i, int ii){
	T temp = data[i];
	data[i]=data[ii];
	data[ii]=temp;
    }
    private void pushDown(int k){
	//System.out.println(k);
	if((k<size/2)&&
	   !(compare(data[k],data[2*k])&&(compare(data[k],data[2*k+1])))){
	    if(compare(data[2*k],data[2*k+1])){
		swap(2*k,k);
		pushDown(2*k);
	    }else{
		swap(2*k+1,k);
		pushDown(2*k+1);
	    }
	}
    }
    private void pushUp(int k){
	if((k>1)&&(compare(data[k],data[k/2]))){
	    swap(k/2,k);
	    pushUp(k/2);
	}

    }
    private void heapify(){
	size=data.length;
	doubleSize();
	data[size]=data[0];
	data[0]=null;
	for(int i = size/2;i>0;i--){
	    pushDown(i);
	}
    }
    public T delete(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T retValue = data[1];
	data[1]=data[size];
	pushDown(1);
	size--;
	return retValue;
    }
    public T peek(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[1];
    }
    public void add(T x){
	size++;
	if(data.length<=size){
	    doubleSize();
	}
	data[size]=x;
	pushUp(size);
    }
    private void doubleSize(){
	T[]newData=(T[]) new Comparable[data.length*2];
	for(int i = 0; i< data.length; i++){
	    newData[i]=data[i];
	}
	data=newData;
    }
    public String toString(){
	String retStr = "[";
	for(int i = 1; i<size;i++){
	    retStr+=data[i]+",";
	}
	return retStr+data[size]+"]";
    }
    //do this last
    //public MyHeap(boolean isMax)
    //public MyHeap(T[] array, boolean isMax)
}
