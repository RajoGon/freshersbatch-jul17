interface Sortable{
	void compareThem();
}
class Employee implements Sortable{
	public void printMe(){
		System.out.println("I am an employee");
	}

}
class Circle implements Sortable{
	public void printMe(){
	System.out.println("I am a circle");

	}
}

public class SortCircle{
	public static void SortAll(Sortable St[]){
		for(int i=0 ; i<St.length;i++){
			St[i].printMe();
		}

	}
	public static void main(String[] args) {
		Sortable P[] = new Sortable[5];
		P[0] = new Circle();
		P[1] = new Circle();
		P[2] = new Circle();
		P[3] = new Circle();
		P[4] = new Circle();
		PrintCircle.SortAll(P);
	}
}
