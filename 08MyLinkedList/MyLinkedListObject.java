public class MyLinkedListObject{
    private class LNode{
	private Object value;
	private LNode next;
	public LNode(Object v, LNode n){
	    value = v;
	    next = n;
	}
	public LNode(Object n){
	    this(n,null);
	}
	public void setValue(Object n){
	    value = n;
	}
	public Object getValue(){
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
    public boolean add(Object value){
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
	while(head!=null){
	    retStr+=head.getValue();
	    if(head.getNext()!=null){
		retStr+=", ";
	    }
	    head=head.getNext();
	}
	return retStr+"]";
    }
    public Object get(int index){
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
    public Object set(int index,Object newValue){
	if(index>=size()){
	    throw new IndexOutOfBoundsException();
	}
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
    public boolean add(int index,Object value){
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
    public int indexOf(Object value){
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
