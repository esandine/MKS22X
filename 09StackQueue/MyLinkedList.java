import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
	private T value;
	private LNode next;
	private LNode prev;
	public LNode(T v, LNode p, LNode n){
	    value = v;
	    prev = p;
	    next = n;
	}
	public LNode(T n){
	    this(n,null,null);
	}
	public void setValue(T n){
	    value = n;
	}
	public T getValue(){
	    return value;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public LNode getNext(){
	    return next;
	}
	public void setPrev(LNode n){
	    prev = n;
	}
	public LNode getPrev(){
	    return prev;
	}
	public boolean hasNext(){
	    if(getNext()==null){
		return false;
	    }
	    return true;
	}
    }
    public class ListViewer implements Iterator<T>{
	private LNode current;
	public ListViewer(){
	    current = start;
	}
	public boolean hasNext(){
	    return current!=null;
	}
	public T next(){
	    if(!hasNext()){
		throw new NoSuchElementException();
	    }
	    T retValue = current.getValue();
	    current = current.getNext();
	    return retValue;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    public ListViewer iterator(){
	return new ListViewer();
    }
    private LNode start;
    private LNode end;
    private int size;
    public int size(){
	return size;
    }
    public boolean add(T value){
	size++;
	if(start==null){
	    start=new LNode(value,null,null);
	    end=start;
	    return true;
	}
	end.setNext(new LNode(value));
	end.getNext().setPrev(end);
	end=end.getNext();
	//System.out.println("Added to the end");
	return true;
    }

    public String toString(boolean b){
	LNode head = start;
	String retStr="[";
	while(head!=null){
	    retStr+=head.getValue().toString();
	    if(head.getNext()!=null){
		retStr+=", ";
	    }
	    head=head.getNext();
	}
	retStr+="]";
	if(b){
	    retStr+=" Head: ";
	    retStr+=start.getValue();
	    retStr+=", Tail: ";
	    retStr+=end.getValue();
	    retStr+=", Size: ";
	    return retStr+size();
	}else{
	    return retStr;
	}
    }
    public String toString(){
	return toString(false);
    }
    public T get(int index){
	if((index>=size()||(index<0))){
	    throw new IndexOutOfBoundsException();
	}
	int i = 0;
	LNode head = start;
	while(head!=null){
	    if(i==index){
		return head.getValue();
	    }
	    i++;
	    head=head.getNext();
	}
	return null;
    }
    public T set(int index,T newValue){
	if((index>=size()||(index<0))){
	    throw new IndexOutOfBoundsException();
	}
	int i = 0;
	LNode head = start;
	T retValue = null;
	while(head!=null){
	    if(i==index){
		retValue = head.getValue();
		head.setValue(newValue);
		return retValue;
	    }
	    i++;
	    head=head.getNext();
	}
	return null;
    }
    public T remove(int index){
	if((index>=size()||(index<0))){
	    throw new IndexOutOfBoundsException();
	}
	size--;
	LNode head = start;
	int i = 0;
	T retValue = null;
	if(index==0){
	    retValue=start.getValue();
	    start=start.getNext();
	    //start.setPrev(null);
	    return retValue;
	}
	while(head!=null){
	    if(i == index-1){
		retValue = head.getNext().getValue();
		head.setNext(head.getNext().getNext());
		//head.getNext().getNext().setPrev(head);
		if(head.getNext()==null){
		    end=head;
		}
		return retValue;
	    }
	    head = head.getNext();
	    i++;
	}
	return null;
    }
    public boolean add(int index,T value){
	if((index>size()||(index<0))){
	    throw new IndexOutOfBoundsException();
	}
	if(index==size()){
	    return add(value);
	}
	if(index==0){
	    size++;
	    start=new LNode(value,null,start);
	    return true;
	}
	size++;
	LNode head = start;
	int i = 0;
	while(i<size()){
	    if(i==index-1){
		head.setNext(new LNode(value,head,head.getNext()));
		return true;
	    }
	    i++;
	    if(head.hasNext()){
		head=head.getNext();
	    }
	}
	return false;
    }
    public int indexOf(T value){
	int index = 0;
	LNode head=start;
	while(head!=null){
	    if(head.getValue().equals(value)){
		return index;
	    }
	    index++;
	    head=head.getNext();
	}
	return -1;
    }
    public boolean clear(){
	start = null;
	size=0;
	return true;
    }
}
