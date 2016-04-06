public class MyDeque<T>{
    private int start;
    private int end;
    private int size;
    private T[] data;
    @SuppressWarnings({"unchecked"})
	public MyDeque(){
	data=(T[])new Object[10];
    }
    private int size(){
	return size;
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
	newData[i]=data[end];
	data=newData;
    }
	
    public void addLast(T value){
	if(size()+1==data.length){
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
