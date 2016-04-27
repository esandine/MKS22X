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
	    if(getData()==value){
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
}
