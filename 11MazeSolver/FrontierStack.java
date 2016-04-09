public class FrontierStack<T> extends MyStack<T> implements Frontier<T>{
    public void add(T element){
	add(0,element);
    }
    public T next(){
	return pop();
    }
    public boolean hasNext(){
	return size()>0;
    }
}