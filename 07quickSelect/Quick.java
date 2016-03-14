import java.util.*;
public class Quick{
    private static int partitionOld(int[]data,int left, int right){
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
    public static int quickselectOld(int[]data,int k){
	return quickselectOld(data,k,0,data.length-1);
    }
    private static int quickselectOld(int[]data,int k,int left,int right){
	int i = partitionOld(data,left,right);
	if(i==k){
	    return data[k];
	}else if(i>k){
	    return quickselectOld(data,k,left,i-1);
	}else{
	    return quickselectOld(data,k,i+1,right);
	}
    }
    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }
    private static void quickSortOld(int[]data,int left,int right){
	if(left<right){
	    int i = partitionOld(data,left,right);
	    quickSortOld(data,left,i-1);
	    quickSortOld(data,i+1,right);
	}
    }
    private static int[] partition(int[]data,int left, int right){
	int randIndex = (int)(Math.random()*(right-left))+left;
	//randIndex = left;
	int value = data[randIndex];
	int tempLeft = left;
	int tempRight = right;
	int rightValues = right;
	//System.out.println(value);
	//swap(data,randIndex,tempRight);
	//tempRight-=1;
	while(tempLeft<=tempRight){
	    //printArray(data);
	    //System.out.println(" "+tempLeft+" "+tempRight+" "+rightValues);
	    if(data[tempLeft]>value){
		swap(data,tempLeft,tempRight);
		tempRight-=1;
	    }else if(data[tempLeft]==value){
		/*System.out.println(rightValues);
		  System.out.println(tempLeft);*/
		swap(data,tempLeft,rightValues);
		rightValues-=1;
		if(rightValues<=tempRight){
		    tempRight--;
		}
	    }else{
		tempLeft+=1;
	    }
	    //printArray(data);
	}
	//printArray(data);
 	//System.out.println(" "+tempLeft+" "+tempRight+" "+rightValues);
 	for(int i = right;i-(right-rightValues)>=tempLeft;i--){
 	    data[i]=data[i-(right-rightValues)];
 	}
 	//printArray(data);
 	for(int i = tempLeft;i<tempLeft+right-rightValues;i++){
 	    data[i]=value;
 	}
	//printArray(data);
	int[] retValues = new int[2];
	retValues[0] = tempLeft;
	retValues[1] = tempLeft+right-rightValues-1;
	return retValues;
    }
    public static int quickselect(int[]data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    private static int quickselect(int[]data,int k,int left,int right){
	int[] indices = partition(data,left,right);
	if((indices[0]<=k)&&(indices[1]>k)){
	    return data[k];
	}else if(indices[0]>k){
	    return quickselect(data,k,left,indices[0]-1);
	}else{
	    return quickselect(data,k,indices[1],right);
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
	    int[] indices = partition(data,left,right);
	    quickSort(data,left,indices[0]-1);
	    quickSort(data,indices[1]+1,right);
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
    public static boolean checkPartition(int[]data){
	int[]test = new int[2];
	test=partition(data,0,data.length-1);
	int value = data[test[0]];
	for(int i = 0;i<test[0];i++){
	    if(data[i]>=value){
		System.out.println("Left failure");
		return false;
	    }
	}
	for(int i = test[1]+1;i<data.length;i++){
	    if(data[i]<=value){
		System.out.println("Right failure");
		return false;
	    }
	}
	for(int i = test[0];i<test[1]+1;i++){
	    if(data[i]!=value){
		System.out.println("Middle failure");
		return false;
	    }
	}
	return true;
    }
    public static boolean checkQuickselect(int[]data){
	for(int i = 0;i<data.length;i++){
	    if(quickselect(data,i)!=quickselectOld(data,i)){
		return false;
	    }
	}
	return true;
    }
    public static void main(String[]args){
	//int[]data = {4,4,34,3,5,7,9,0,9,9};
	//System.out.println(checkPartition(data));
	//printArray(partition(data,0,data.length-1));
	//printArray(data);
	//if(args[0]==1){
	//    fillRandom(data);
	//}else{
	//    for(int i = 0;i<data.length;i++){
	//	data[i]=(int)Math.random()*4;
	//    }
	//}
	//if(
	//System.out.println(checkQuickselect(data));
	//quickSort(data);
	//printArray(data);
	//Arrays.sort(data);
	//printArray(data);
	int[] d = new int [4000000];
	//int[] c = new int [d.length];
	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*4);
	    //c[i]= d[i];
	}
	//for(int i = 0;i<100000;i++){
	//    if(!checkPartition(d)){
	//	counter++;
	//	System.out.println(counter);
	//    }
	//}
	//quickSortOld(d); //*or even your old quicksort!!!
	Arrays.sort(d);
	//int co = 0;
	//for(int i = 0; i<d.length;i++){
	//    if(d[i]!=c[i]){
	//System.out.println(i);
		//System.out.println(d[i-1]);
		//System.out.println(d[i]);
	//    }
	//}
	//printArray(d);
	//printArray(c);
	//System.out.println(co);
	//System.out.println("Done: Sorted="+Arrays.equals(d,c));
    }
}
