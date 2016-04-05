public class MyDeque<T>{
    private int start;
    private int end;
    private int size;
    private T[] data;
    @SuppressWarnings({"unchecked"})
	public MyDeque(){
	data=(T[])new Object[10];
    }
    
}
