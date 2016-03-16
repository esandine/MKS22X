public class MyLinkedList{
    private class LNode{
	private int value;
	private LNode next;
	public LNode(int v, LNode n){
	    value = v;
	    next = n;
	}
	public LNode(){
	    value = 0;
	    next = null;
	}
	public void setValue(int n){
	    value = n;
	}
	public int getValue(){
	    return value;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public LNode getNext(){
	    return next;
	}
	public boolean hasNext(){
	    if(getNext()==null){
		return false;
	    }
	    return true;
	}
    }
    private LNode start;
    private int size;
    public int size(){
	return size;
    }
    public MyLinkedList(){
	size = 0;
    }
    public boolean add(int value){
	size+=1;
	if(start==null){
	    start=new LNode(value,null);
	    return true;
	}
	LNode head = start;
	while(head.hasNext()){
	    head=head.getNext();
	}
	head.setNext(new LNode(value,null));
	return true;
    }
    public String toString(){
	LNode head = start;
	String retStr="[";
	if(head==null){
	    return retStr+"]";
	}
	while(head!=null){
	    retStr+=head.getValue();
	    retStr+=",";
	    head=head.getNext();
	}
	return retStr+"]";
    }
    public int get(int index){
	if(index>=size()){
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
	return -1;
    }
    public int set(int index,int newValue){
	int i = 0;
	LNode head = start;
	while(head!=null){
	    if(i==index){
		i = head.getValue();
		head.setValue(newValue);
		return i;
	    }
	    i++;
	    head=head.getNext();
	}
	return -1;
    }
    public int remove(int index){
	if(index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode head = start;
	int i = 0;
	if(index==0){
	    start=start.getNext();
	}
	while(head!=null){
	    if(i == index-1){
		i = head.getNext().getValue();
		head.setNext(head.getNext().getNext());
		return i;
	    }
	    head = head.getNext();
	    i++;
	}
	return 0;
    }
    public boolean add(int index,int value){
	if(index>size()){
	    throw new IndexOutOfBoundsException();
	}
	if(index==size()){
	    add(value);
	}
	if(index==0){
	    start=new LNode(value,start);
	}
	LNode head = start;
	int i = 0;
	while(i<size()){
	    if(i==index-1){
		head.setNext(new LNode(value,head.getNext()));
		return true;
	    }
	    i++;
	    head=head.getNext();
	}
	return false;
    }
    public int indexOf(int value){
	int index = 0;
	LNode head=start;
	while(head!=null){
	    if(head.getValue()==value){
		return index;
	    }
	    index++;
	    head=head.getNext();
	}
	return -1;
    }
}
