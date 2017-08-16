interface Sortable{
	int compareThem();
	int sortThem(Sortable x,Sortable y);
}
class Employee implements Sortable{
	public int empid;
	Employee(int empid){
		this.empid = empid;
	}
	public int sortThem(Sortable Sj1,Sortable Sj2){
		System.out.println("in Employee");
		if (Sj1.compareThem() > Sj2.compareThem()){
				return 1;
			 }	
			else{
				return 0;
			}
	}
	public int compareThem(){
		return this.empid;
	}
}

class Circle implements Sortable{
	public int radius;
	public Sortable temp;
	Circle(int radius){
		this.radius = radius;
	}
	public int sortThem(Sortable Sj1,Sortable Sj2){
		System.out.println("in Circle");
		if (Sj1.compareThem() > Sj2.compareThem()){
				return 1;
			 }	
			else{
				return 0;
			}
	}

	public int compareThem(){
		return this.radius;
	}
}

public class SortMain{
	public static int compare;
	public static Sortable temp;
	public static void SortAll(Sortable St[]){


		for(int i=0 ; i<St.length;i++){
			for(int j=0;j<St.length-1;j++){
			compare = St[j].sortThem(St[j],St[j+1]);
			 	if (compare == 1){
			 	temp = St[j];
			 	St[j]= St[j+1];
			 	St[j+1] = temp;
			 	}
                         
			}
		}
		System.out.println("Sorted array is.");
		for(int i=0 ; i<St.length;i++){
			System.out.println(St[i].compareThem());
		}

	}

	public static void main(String[] args) {
		Sortable P[] = new Sortable[7];
		P[0] = new Circle(17);
		P[1] = new Circle(4);
		P[2] = new Circle(2);
		P[3] = new Circle(11);
		P[4] = new Circle(9);
		P[5] = new Circle(79);
		P[6] = new Circle(1);
		SortMain.SortAll(P);
	}
}
