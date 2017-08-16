import java.lang.reflect.*; 
class Student{
	private static int marks=100;

	private void getMarks(String name){

		System.out.println("Hello "+name+" your marks, marks "+this.marks);
	}
}

public class PrivateAccess{
	public static void main(String[] args) throws  InvocationTargetException,NoSuchMethodException,NoSuchFieldException,IllegalAccessException{
		Student a = new Student();
		Field field = Student.class.getDeclaredField("marks");
		field.setAccessible(true);
		int value = (int)field.get(Integer.class);
        System.out.println(value);
        Method m = Student.class.getDeclaredMethod("getMarks",String.class);
        m.setAccessible(true);
        m.invoke(a,"Rajo");
	}
}