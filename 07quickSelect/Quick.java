import java.util.*;
public class Quick{
    private static int partition(int[]data,int left, int right){
	int randIndex = (int)(Math.random()*(right-left))+left;
	int value = data[randIndex];
	int tempLeft = left;
	int tempRight = right;
	swap(data,randIndex,tempRight);
	tempRight-=1;
	while(tempLeft<=tempRight){
	    if(data[tempLeft]>value){
		swap(data,tempLeft,tempRight);
		tempRight-=1;
	    }else{
		tempLeft+=1;
	    }
	}
	//printArray(data);
	for(int i = right;i>1+tempRight;i--){
	    data[i]=data[i-1];
	}
	data[tempRight+1]=value;
	return tempRight+1;
    }
    public static int quickselect(int[]data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    private static int quickselect(int[]data,int k,int left,int right){
	int i = partition(data,left,right);
	if(i==k){
	    return data[k];
	}else if(i>k){
	    return quickselect(data,k,left,i-1);
	}else{
	    return quickselect(data,k,i+1,right);
	}
    }
    public static String name(){
	return "6,Sandine,Ely"; //e.g. "7,Kim,Bob"
    }
    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[]data,int left,int right){
	if(left<right){
	    int i = partition(data,left,right);
	    quickSort(data,left,i-1);
	    quickSort(data,i+1,right);
	}
    }
    public static void fillRandom(int[] data){
	for(int i = 0;i<data.length;i++){
            data[i]=(int)(Integer.MAX_VALUE*Math.random());
	}
    }
    public static void swap(int[] data,int i1,int i2){
	int storage = data[i2];
	data[i2]=data[i1];
	data[i1]=storage;
    }/*
    public static void debug(Object o){
	if(debug){
            System.out.println(o);
	}
	}*/
    public static void printArray(int[]data){
        String retStr="";
        retStr+="[";
        for(int i = 0;i<data.length;i++){
            retStr+=" ";
            retStr+=data[i];
            retStr+=",";
        }
        if(retStr.length()>1){
            retStr=retStr.substring(0,retStr.length()-1);
        }
        retStr+="]";
        System.out.println(retStr);
    }
    public static void main(String[]args){
	int[]data = new int[4000000];
	if(args[0]==1){
	    fillRandom(data);
	}else{
	    for(int i = 0;i<data.length;i++){
		data[i]=(int)Math.random()*4;
	    }
	}
	if(
	quickSort(data);
	printArray(data);
    }
}
