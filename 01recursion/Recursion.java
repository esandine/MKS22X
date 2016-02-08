public class Recursion{
    public String name(){
	return "Sandine,Ely";
    }
    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrt(n,n);
    }
    public double sqrt(double n,double guess){
	if((guess*guess-n)/n<.00000001){
	    return guess;
	}else{
	    return sqrt(n,(n/guess+guess)/2);
	}
    }
}