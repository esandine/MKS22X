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
	}/*else{
	    retStr+=head.getValue();
	    retStr+=",";
	    }*/
	while(head!=null){
	    retStr+=head.getValue();
	    retStr+=",";
	    head=head.getNext();
	}
	return retStr+"]";
    }
}
