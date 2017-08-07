import java.util.Arrays;
public class QueuedArray {
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
			System.out.println("Element popped, "+ary[0]);
			for(int i=0 ; i<currentposition ; i++){				
				ary[i] = ary[i+1]; 
			}
			ary[currentposition] = 0;
			currentposition--;
			
		}
	}
	
	 public void printArray(){
		System.out.println("Array is "+Arrays.toString(ary));
	} 
	public static void main(String args[]){
		QueuedArray  a = new QueuedArray ();
		a.push(3);
		a.push(7);
		a.push(8);
		a.pop();
		a.push(5);
		a.push(4);
		a.push(2);
		a.push(16);
		a.push(19);
		a.printArray();		
		a.push(1);
		a.pop();
		a.printArray();
		a.pop();		
		a.pop();
		a.printArray();
		a.pop();
		a.pop();
		a.pop();
		a.printArray();
		
	}
}