package stref;
public class StringRef{
	static String s1 = "Hello";
	static String s2 = "Hello";

	static StringBuilder st1 =new  StringBuilder("Hello");
	static StringBuilder st2 =new  StringBuilder("Hello");

	static StringBuffer st3 =new StringBuffer("Hello");
	static StringBuffer st4 =new StringBuffer("Hello");
	
	

	public static void main(String[] args) {
		System.out.println("Before ");

		StringBuilder temp=st1;

		if(st1==temp){
			System.out.println("Reference to one object");
		} else{
			System.out.println("Different References to different objects");
		}

		// if(st3.equals(st4)){
		// 	System.out.println("Same content");
		// }else{
		// 	System.out.println("Different contents");
		// }

		st1 = st1.append("world");
		System.out.println("After ");
		if(st1==temp){
			System.out.println("Reference to one object");
		} else{
			System.out.println("Different References to different objects");
		}

	}
}