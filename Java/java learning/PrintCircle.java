interface Printable{
	public void printMe();
}
class Employee implements Printable{
	public void printMe(){
		System.out.println("I am an employee");
	}

}
class Circle implements Printable{
	public void printMe(){
	System.out.println("I am a circle");

	}
}
public class PrintCircle{
	public static void PrintAll(Printable Pt[]){
		for(int i=0 ; i<Pt.length;i++){
			Pt[i].printMe();
		}

	}
	public static void main(String[] args) {
		Printable P[] = new Printable[5];
		P[0] = new Circle();
		P[1] = new Employee();
		P[2] = new Circle();
		P[3] = new Employee();
		P[4] = new Circle();
		PrintCircle.PrintAll(P);
	}
}
