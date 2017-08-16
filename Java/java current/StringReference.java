package stref;
public class StringReference{
	String s1 = "Hello";
	String s2= "Hello";
	StringBuilder st1 = "Hello";
	StringBuilder st2 = "Hello";
	public static void main(String[] args) {
		if(s1==s2){
			System.out.println("Reference to one object");
		} else{
			System.out.println("Different References to different objects");
		}

		if(s1.equals(s2)){
			System.out.println("Same content");
		}else{
			System.out.println("Different contents");
		}
	}
}