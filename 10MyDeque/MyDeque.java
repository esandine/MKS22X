import java.util.*;
public class MyDeque<T>{
    private int start;
    private int end;
    private int size;
    private T[] data;
    @SuppressWarnings({"unchecked"})
	public MyDeque(){
	data=(T[])new Object[10];
    }
    public int size(){
	return size;
    }
    public boolean isEmpty(){
	return size()==0;
    }
    public int getStart(){
	return start;
    }
    public int getEnd(){
	return end;
    }
    public String printData(){
	String retStr="[";
	for(int i = 0;i<data.length;i++){
	    retStr+=data[i]+",";
	}
	return retStr;
    }
    @SuppressWarnings({"unchecked"})
	private void grow(){
	T[] newData = (T[])new Object[data.length*2];
	int i = start;
	int newI = 0;
	while(i!=end){
	    newData[newI]=data[i];
	    if(i==data.length-1){
		i=0;
	    }else{
		i++;
	    }
	    newI++;
	}
	newData[newI]=data[end];
	start=0;
	end=newI;
	data=newData;
    }
	
    public void addLast(T value){
	if(size()==data.length){
	    grow();
	}
	if(end<data.length-1){
	    end += 1;
	}
	else{
	    end = 0;
	}
	if(size()==0){
	    start = 0;
	    end = 0;
	}
	data[end]=value;
	size+=1;
    }
    public void addFirst(T value){
	if(size()==data.length){
	    grow();
	}
	if(start>0){
	    start -= 1;
	}
	else{
	    start=data.length-1;
	}
	if(size()==0){
	    start = 0;
	    end = 0;
	}
	data[start]=value;
	size+=1;
    }
    public T removeFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	T retValue = data[start];
	if(start==data.length-1){
	    start=0;
	}else{
	    start += 1;
	}
	size-=1;
	return retValue;
    }
    public T removeLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	T retValue = data[end];
	if(end==0){
	    end=data.length-1;
	}else{
	    end -= 1;
	}
	size-=1;
	return retValue;
    }
    public T getFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    public T getLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    public String toString(){
	int i = start;
	String retStr="[";
	while(i!=end){
	    retStr+=data[i];
	    retStr+=",";
	    if(i==data.length-1){
		i = 0;
	    }else{
		i++;
	    }
	}
	retStr+=data[i];
	return retStr+"]";
    }
}
