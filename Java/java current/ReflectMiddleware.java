import java.lang.reflect.*; 
import java.util.Locale;
class Student{

	public void getMarks(Integer marks){
		System.out.println("Hello Student with marks "+marks);
	}
}

class Middleware{
	public static void callMethod(String classname,String functionname,Class[] paramtypes, int x) throws InvocationTargetException,ClassNotFoundException,InstantiationException,NoSuchMethodException,IllegalAccessException{
		Object c = Class.forName(classname).newInstance();
		Class d = Class.forName(classname);
		Method  method = d.getDeclaredMethod(functionname,paramtypes);
		method.invoke(c,x);
		
	}
}

class ReflectMiddleware{
	public static void main(String[] args) throws IllegalAccessException,InvocationTargetException,NoSuchMethodException,InstantiationException, ClassNotFoundException{
		String name = args[0];
		String fname = args[1];
		Class[] paramtypes = {Integer.class};
		int x = 90;
		Middleware.callMethod(name,fname,paramtypes,x);
	}
}