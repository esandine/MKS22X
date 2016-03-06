public class Sorts{
    private static boolean debug = true;
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
    public static void insertionSort(int[]data){
	if(debug){
	    System.out.println("Insertion Sort:");
	}
	int tempValue=0;
	int tempIndex=0;
	for(int i = 1;i<data.length;i++){
      	    tempValue=data[i];
	    tempIndex=i;
	    //System.out.println(tempValue);
	    //System.out.println(tempIndex);
	    while(tempIndex>=1&&tempValue<=data[tempIndex-1]){
		//System.out.println("yo");
		//System.out.println(tempValue);
		//System.out.println(tempIndex);
		data[tempIndex]=data[tempIndex-1];
		tempIndex-=1;
	    }
	    data[tempIndex]=tempValue;
	if(debug){
		  printArray(data);
	}
	}
	//your code here to make data re-order its elements
	//from least to greatest just like we did in class
	//same algorithm as the way you created your OrderedSuperArray
    }

    public static void selectionSort(int[] ary){
	if(debug){
	    System.out.println("Selection Sort:");
	}
	int minValue;
	int minIndex;
	for(int i = 0;i<ary.length;i++){
	    minValue=ary[i];
	    minIndex=i;
	    for(int index=i;index<ary.length;index++){
		if(ary[index]<minValue){
		    minValue = ary[index];
		    minIndex=index;
		}
	    }
	    ary[minIndex]=ary[i];
	    ary[i]=minValue;
	    if(debug){
		printArray(ary);
	    }
	}
    }
    public static void bubbleSort(int[] data){
	if(debug){
	    System.out.println("Bubble Sort:");
	}

	int smaller;
	for(int i = 1;i<data.length;i++){
	    for(int index = 0;index<data.length-i;index++){
		if(data[index]>data[index+1]){
		    smaller = data[index+1];
		    data[index+1]=data[index];
		    data[index]=smaller;
		}
	    }
	    if(debug){
		 printArray(data);
	    }

	}
    }
    public static int[] merge(int[]dataOld,int startA,int endA,int startB,int endB){
	int aindex = startA;
      	//debug(aindex);
	int bindex = startB;
	int index = startA;
	int[] dataNew = new int[dataOld.length];
	while((aindex<=endA)&&(bindex<=endB)){
	    if(dataOld[aindex]<dataOld[bindex]){
		/*if((index>endA)&&(index<startB)){
		    debug(aindex);
		    debug(index);
		    dataNew[index+aindex]=dataOld[index];
		    }*/
		dataNew[index]=dataOld[aindex];
		aindex++;
		//debug("a");
		//System.out.println(dataNew[index]);
	    }else{
		/*if((bindex>endA)&&(index<startB)){
		    debug(bindex);
		    debug(index);
		    dataNew[index+bindex]=dataOld[index];
		    }*/
		//System.out.println(dataOld[aindex]);
		dataNew[index]=dataOld[bindex];
		bindex++;
		//debug("b");
		//System.out.println(dataOld[aindex]);
		//System.out.println(dataNew[index]);
	    }
	    index++;
	    if(index==endA+1){
		while(index<startB){
		    dataNew[index]=dataOld[index];
		    index++;
		}
		debug("Make the leap first");
		debug(index);
	    }/*else{
		debug("no leap");
		index++;
		}*/
	}
	//debug(aindex);
	//debug(bindex);
	//debug(index);
	//printArray(dataOld);
	//printArray(dataNew);
	while(aindex<=endA){
    	    //debug("afinish");
	    //debug(aindex);
	    //debug(index);
	    dataNew[index]=dataOld[aindex];
	    aindex++;
	    //System.out.println(dataNew[index]);
	    index++;
	    if(index==endA+1){
		while(index<startB){
		    dataNew[index]=dataOld[index];
		    index++;
		}
		debug(index);
		debug("Make the leap  A");
	    }/*else{
		debug("no leap");
		index++;
		}*/
	}
	while(bindex<=endB){
	    dataNew[index]=dataOld[bindex];
	    bindex++;
	    //System.out.println(dataNew[index]);
	    //debug("bfinish");
	    index++;
	    if(index==endA+1){
		while(index<startB){
		    dataNew[index]=dataOld[index];
		    index++;
		}
		debug("Make the leap B");
		debug(index);
	    }/*else{
		debug("no leap");
		index++;
		}*/
	}
	for(int i = 0;i<dataOld.length;i++){
	    if(dataNew[i]==0){
		//debug(dataOld[i]);
		dataNew[i]=dataOld[i];
	    }
	}
	return dataNew;
    }
    public static void mergeSortIter(int[] data, int data2, int startA, int endA, int StartB, int endB, int ctr){/*
	if(data.length==1){
	    return data;
	}else if(ctr/2 == 0){
	return merge(data,data2,0,data.length/2,data.length/2+1,data.length);*/
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
    }
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}
