import java.util.*;
class Person implements Comparable<Person>{
	public int height;
	public int weight;
	public String name;
	Person(int height, int weight, String name){
		this.height = height;
		this.weight = weight;
		this.name = name;
	}
	public int compareTo(Person Pt){

		if(this.height == Pt.height){
			return 0;
		}
		else if(this.height > Pt.height){
			return -1;
		}
		else{
			return 1;
		}
	}
}

class WeightCompare implements Comparator<Person>{
	public int compare(Person o1,Person o2){
		if(o1.weight == o2.weight){
			return 0;
		}
		else if(o1.weight > o2.weight){
			return 1;
		}
		else{
			return -1;
		}
	}
}


class NameCompare implements Comparator<Person>{
	public int compare(Person o1,Person o2){
		return o1.name.compareTo(o2.name);
	}
}

public class Comparing{
	public static void main(String[] args) {

		Person P[] = new Person[5];
		P[0] = new Person(2,32,"AB");
		P[1] = new Person(4,71,"AC");
		P[2] = new Person(1,23,"M");
		P[3] = new Person(7,11,"E");
		P[4] = new Person(5,9,"F");
		Arrays.sort(P);
		System.out.println("Sorted Height wise (descending) ");
		for(int i=0 ; i<P.length;i++){
			System.out.println(P[i].height);
		}

		Arrays.sort(P,new WeightCompare());
		System.out.println("Sorted weight wise (ascending) ");
		for(int i=0 ; i<P.length;i++){
			System.out.println(P[i].weight);
		}

		Arrays.sort(P,new NameCompare());
		System.out.println("Sorted name wise (ascending) ");
		for(int i=0 ; i<P.length;i++){
			System.out.println(P[i].name);
		}
	}
}