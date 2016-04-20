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
	    setData(t);
	}
	private void add(T value){
	    if(getLeft()==null){
		setLeft(new Node(value));
	    }else if(getRight()==null){
		
	    }
	    
	}
    }
}
