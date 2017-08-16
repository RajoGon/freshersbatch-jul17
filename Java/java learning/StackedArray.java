import java.util.Arrays;
public class StackedArray {
	private int ary[] = new int [5];
	private static int currentposition = -1;
	public void push(int m){
		if(currentposition < 4)
		{
			currentposition++;
			ary[currentposition] = m;
			System.out.println("Element pushed, "+m);
		}
		else{
			System.out.println("Array full.. please pop an element to push");
		}
	}
	public void pop(){
		if(currentposition == -1  )
		{
			System.out.println("Array already empty");
		}
		else{
			System.out.println("Element popped, "+ary[currentposition]);
			ary[currentposition] = 0;
			currentposition = currentposition -1;
			
		}
	}
	
	 public void printArray(){
		System.out.println("Array is "+Arrays.toString(ary));
	} 
	public static void main(String args[]){
		StackedArray  a = new StackedArray ();
		a.push(3);
		a.push(7);
		a.push(8);
		a.pop();
		a.push(7);
		a.push(3);
		a.push(5);
		a.push(1);
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.printArray();
		
	}
}