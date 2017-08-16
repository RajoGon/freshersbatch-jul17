package integerwrapper;
import java.util.*;
public class IntegerWrapper{
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0;i<args.length;i++)
		{
			a.add(Integer.parseInt(args[i]));
		}
		Collections.sort(a);
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i));
		}
	}
}