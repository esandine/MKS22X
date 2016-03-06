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
	int bindex = startB;
	int index = startA;
	int[] dataNew = new int[dataOld.length];
	while((aindex<=endA)&&(bindex<=endB)){
	    if(dataOld[aindex]<dataOld[bindex]){
		dataNew[index]=dataOld[aindex];
		aindex++;
	    }else{
		dataNew[index]=dataOld[bindex];
		bindex++;
	    }
	    index++;
	    if(index==endA+1){
		while(index<startB){
		    dataNew[index]=dataOld[index];
		    index++;
		}
	    }
	}
	while(aindex<=endA){
	    dataNew[index]=dataOld[aindex];
	    aindex++;
	    index++;
	    if(index==endA+1){
		while(index<startB){
		    dataNew[index]=dataOld[index];
		    index++;
		}
	    }
	}
	while(bindex<=endB){
	    dataNew[index]=dataOld[bindex];
	    bindex++;
	    index++;
	    if(index==endA+1){
		while(index<startB){
		    dataNew[index]=dataOld[index];
		    index++;
		}
	    }
	}
	for(int i = 0;i<dataOld.length;i++){
	    if((i<startA)||(i>endB)){
		dataNew[i]=dataOld[i];
	    }
	}
	return dataNew;
    }
    public static void mergeSort(int[] data){
	int delemeter = 1;
	while(delemeter<data.length){
	    debug(delemeter);
	    for(int i = 0;i+delemeter+1<data.length;i+=(delemeter+1)){
		if(delemeter%2==0){
		    data = merge(data,i,i+delemeter/2,i+delemeter/2+1,i+delemeter+1);
		}else{
		    data = merge(data,i,i+delemeter/2,i+delemeter/2+1,i+delemeter);
		}
		printArray(data);
		//debug(i);
	    }
	    debug("Last One");
	    data=merge(data,data.length-delemeter-1,data.length-delemeter/2-2,data.length-delemeter/2-1,data.length-1);
	    printArray(data);
	    delemeter*=2;
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
    }
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}
