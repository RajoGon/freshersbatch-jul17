class ComplexSwapper{
	ComplexNumber c;
	ComplexSwapper(ComplexNumber c){
	   this.c = c;
	} 
	public String toString(){
	 return this.c.real+" + i"+this.c.imaginary;
	}
}


public class ComplexNumber{
	public int real;
	public int imaginary;
	public ComplexNumber(int r, int img){
		this.real = r;
		this.imaginary = img;
		
	}
	public void add(ComplexNumber number2){
		
		int tempreal = this.real + number2.real;
		int tempimaginary = this.imaginary + number2.imaginary;
		System.out.println("Sum of the numbers is, "+tempreal+" + i"+tempimaginary);
		
	}
	public void subtract(ComplexNumber number2){
		
		int tempreal = this.real - number2.real;
		int tempimaginary = this.imaginary - number2.imaginary;
		System.out.println("Difference of the numbers is, "+tempreal+" + i"+tempimaginary);
		
	}
	public void multiply(ComplexNumber number2){
		
		int tempreal = this.real * number2.real;
		int tempimaginary = this.imaginary * number2.imaginary;
		System.out.println("Product of the numbers is, "+tempreal+" + i"+tempimaginary);	
	}
	public static void swap(ComplexSwapper s1,ComplexSwapper s2){
		ComplexNumber temp = s1.c;
		s1.c=s2.c;
		s2.c = temp;		
	}
	public String toString(){
	 return this.real+" + i"+this.imaginary;
	}
	
	public static void main(String args[]){
		ComplexNumber a = new ComplexNumber(5,6);
		ComplexNumber b = new ComplexNumber(2,3);
		a.add(b);
		a.subtract(b);
		a.multiply(b);
		ComplexSwapper a1 = new ComplexSwapper(a);
		ComplexSwapper b1 = new ComplexSwapper(b);
		System.out.println("Before swap, a = "+a1);
		System.out.println("Before swap, b = "+b1);
		swap(a1,b1);
		System.out.println("After swap, a = "+a1);
		System.out.println("After swap, b = "+b1);
		
	}
}