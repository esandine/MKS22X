public class Recursion{
    public String name(){
	return "Sandine,Ely";
    }
    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}
	return sqrt(n,n);
    }
    public double sqrt(double n,double guess){
	if(Math.abs((guess*guess-n)/n)<.00000001){
	    return guess;
	}else{
	    return sqrt(n,(n/guess+guess)/2);
	}
    }
}