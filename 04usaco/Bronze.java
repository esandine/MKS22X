import java.util.*;
public class Bronze{
    private String file;
    public Bronze(String fileName){
	Scanner s1 = new Scanner(fileName);
	while(s1.hasNextLine()){
	    file+=s1.nextLine();
	}
    }
    public String toString(){
	return file;
    }
}
