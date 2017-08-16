package student;
import faculty.Faculty;

public class Student{
	public static void main(String[] args) {
		System.out.println("Marks of the student is "+new Faculty().getMarks());
	}
}