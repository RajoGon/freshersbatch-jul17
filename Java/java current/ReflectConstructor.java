import java.lang.reflect.*; 
class Student{

	Student(String name){
		System.out.println("Hello"+name);
	}
}

public class ReflectConstructor{
	public static void main(String[] args) throws InvocationTargetException,NoSuchMethodException,IllegalAccessException,InstantiationException,ClassNotFoundException{
		String fname = "Student";
		String myname="Rajo";
		Object c = Class.forName(fname);
		Class d = Class.forName(fname);

		 Constructor c1=null;
		 Constructor  constructor[] = d.getDeclaredConstructors();


		 Class[] param = constructor[0].getParameterTypes();

		Object j = d.getDeclaredConstructor(param[0]).newInstance(myname);
		
		// Constructor  m = d.getDeclaredConstructor(fname,param);

		// m.invoke(c,myname);
	}
}