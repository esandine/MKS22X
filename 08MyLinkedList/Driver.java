import java.util.*;
public class Driver{
    public static void main(String[]args){
        MyLinkedList<String> m = new MyLinkedList<String>();
        ArrayList<String>    n = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            n.add(""+i);
            m.add(""+i);
        }

        try{
            m.add(-1,"oops");
            System.out.println("\n\nAdd -1 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.add(12,"oops");
            System.out.println("\n\n add 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.remove(12);
            System.out.println("\n\n remove 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }

        try{
            m.set(12,"Fwazzat?!?");
            System.out.println("\n\n set 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }





        //replace toString(true) with a debug to string that shows the head/tail
        System.out.println(m.toString(true));
        System.out.println(n);

        //test removing from head/tail/middle
        m.remove(0);
        n.remove(0);
        System.out.println(m.toString(true));

        m.remove(2);
        n.remove(2);
        System.out.println(m.toString(true));

        m.remove(m.size()-1);
        n.remove(n.size()-1);
        System.out.println(m.toString(true));
        System.out.println(n);

        //test adding to end/start
        m.add(0,"START");
        n.add(0,"START");
        m.add(m.size(),"PENULTIMATE");
        n.add(n.size(),"PENULTIMATE");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test add
        m.add("Z-END!");
        n.add("Z-END!");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test remove random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);

            if(op == 0 || n.size()==0){//ensure never empty
                n.add(""+i);
                m.add(""+i);
            }else if(op == 1 ){
                int x = rand.nextInt(n.size());
                n.add(x,""+i);
                m.add(x,""+i);
            }else{
                int x = rand.nextInt(n.size());
                if(!n.remove(x).equals(m.remove(x))){
                    System.out.println("Non matching elements removed\n");
                    System.exit(1);
                }
            }
        }
        System.out.println(m.toString(true));
        System.out.println(n);
	for(int i = 0;i<m.size();i++){
	    if(!(m.get(i).equals(n.get(i)))){
		System.out.println("Falsity");
	    }
	}
	System.out.println("\n\nTesting Iterator\n\n");
	for(String s:m){
	    System.out.println(s);
	}
        /*test speed of add in front and at end.
        long start,end;
        System.out.println("Add 100k to front");

        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
            n.add(0,""+i);
        end = System.currentTimeMillis();
        System.out.println( "ArrayList "+(end-start)/1000.0 );

        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++)
            m.add(0,""+i);
        end = System.currentTimeMillis();
        System.out.println( "LinkedList "+(end-start)/1000.0 );


        System.out.println("Add 1m to end");

        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            n.add(""+i);
        end = System.currentTimeMillis();
        System.out.println( "ArrayList "+(end-start)/1000.0 );

        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
            m.add(""+i);
        end = System.currentTimeMillis();
        System.out.println( "LinkedList "+(end-start)/1000.0 );

        */
    }
}
/*public class Driver{
    public static void main(String[]args){
	System.out.println("Linked List Driver");
	MyLinkedList<Integer> l1 = new MyLinkedList<Integer>();
	ArrayList<Integer> l2 = new ArrayList<Integer>();
	long start = 0;
	long end = 0;
	//Adding to the end
	System.out.println("Adding to the end");
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 1000000;i++){
	    l1.add((int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for Linked List"+((end-start)/1000.0));
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 1000000;i++){
	    l2.add((int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for ArrayList"+((end-start)/1000.0));       
	l1.clear();
	l2.clear();
	//Adding to the beginning
	System.out.println("Adding to the beginning");
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l1.add(0,(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for Linked List"+((end-start)/1000.0));
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l2.add(0,(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for ArrayList"+((end-start)/1000.0));       
	l1.clear();
	l2.clear();
	//ADding to a random spot
	System.out.println("Adding to a random spot");
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l1.add((int)(Math.random()*l1.size()),(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for Linked List"+((end-start)/1000.0));
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l2.add((int)(Math.random()*l2.size()),(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for ArrayList"+((end-start)/1000.0));       
    }
    }*/

