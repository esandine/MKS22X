public class BSTree<T extends Comparable<T>>{
    private class Node{
	//Instance Variables
	Node Left,Right;
	T data;
	//Mutators
	private void setLeft(Node n){
	    Left=n;
	}
	private void setRight(Node n){
	    Right=n;
	}
	private void setData(T n){
	    data=n;
	}
	private Node getLeft(){
	    return Left;
	}
	private Node getRight(){
	    return Right;
	}
	private T getData(){
	    return data;
	}
	public Node(T value){
	    setData(value);
	}
	private int height(){
	    if(getLeft()==null&&getRight()==null){
		return 1;
	    }
	    else if(getLeft() == null){
		return 1 + getRight().height();
	    }
	    else if(getRight() == null){
		return 1 + getLeft().height();
	    }else{
		return 1 + Math.max(getLeft().height(),getRight().height());
	    }
	}
	
	private void add(T value){
	    if(value.compareTo(getData())<0){
		if(getLeft()==null){
		    setLeft(new Node(value));
		}else{
		    getLeft().add(value);
		}
	    }else{
		if(getRight()==null){
		    setRight(new Node(value));
		}else{
		    getRight().add(value);
		}
	    }
	}
	private void add(Node n){
	    add(n.getData());
	    if(n.getLeft()!=null){
		add(n.getLeft());
	    }
	    if(n.getRight()!=null){
		add(n.getRight());
	    }
	}
	public String toString(){
	    String retStr=getData()+" ";
	    if(getLeft()!=null){
		retStr+=getLeft().toString();
	    }else{
		retStr+="_ ";
	    }
	    if(getRight()!=null){
		retStr+=getRight().toString();
	    }else{
		retStr+="_ ";
	    }
	    return retStr;
	}
	private boolean contains(T value){
	    if(getData().equals(value)){
		return true;
	    }
	    if(getLeft()==null&&getRight()==null){
		return false;
	    }
	    if(getLeft()==null){
		return getRight().contains(value);
	    }
	    if(getRight()==null){
		return getLeft().contains(value);
	    }
	    else{
		return getLeft().contains(value)||getRight().contains(value);
	    }	    
	}
	private void remove(T value){
	    if(getLeft()!=null){
		Node left = getLeft();
		if(left.getData().equals(value)){
		    if((left.getLeft()==null)&&(left.getRight()==null)){
			setLeft(null);
		    }else if(left.getRight()==null){
			setLeft(left.getLeft());
		    }else{
			setLeft(left.getRight());
		    }
		}else{
		    getLeft().remove(value);
		}
	    }
	    if(getRight()!=null){
		Node right = getRight();
		if(right.getData().equals(value)){
		    if((right.getLeft()==null)&&(right.getRight()==null)){
			setRight(null);
		    }else if(right.getLeft()==null){
			setRight(right.getRight());
		    }else{
			setRight(right.getLeft());
		    }
		}else{
		    getRight().remove(value);
		}
	    }
	}
    }
    private Node root;
    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	if(root==null){
	    return 0;
	}else{
	    return root.height();
	}
    }

    public void add(T value){
	if(root==null){
	    root = new Node(value);
	}else{
	    root.add(value);
	}
    }
    public String toString(){
	//check for empty before you do things with root.
	if(root==null){
	    return "";
	}else{
	    return root.toString();
	}

    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	if(root==null){
	    return false;
	}
	else{
	    return root.contains(value);
	}
    }
    public void remove(T value){
	if(root!=null){
	    if(root.getData().equals(value)){
	        if((root.getLeft()==null)&&(root.getRight()==null)){
		    root = null;
		}else if(root.getLeft()==null){
		    root=root.getRight();
		}else if(root.getRight()==null){
		    root=root.getLeft();
		}else{
		    Node toBeAdded = root.getLeft();
		    root=root.getRight();
		    root.add(toBeAdded);
		}
	    }else{
		root.remove(value);
	    }
	}
    }
}

