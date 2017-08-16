import java.lang.reflect.*; 
import java.util.Locale;
class Student{

	public void getMarks(Integer marks, String name){
		System.out.println("Hello "+name+" with marks "+marks);
	}
}

class Middleware{
	public static void callMethod(String classname,String functionname, int x, String name) throws InvocationTargetException,ClassNotFoundException,InstantiationException,NoSuchMethodException,IllegalAccessException{
		Object c = Class.forName(classname).newInstance();
		Class d = Class.forName(classname);
		
		Method m1=null;
		Method  method[] = d.getDeclaredMethods();
		for(int i=0; i<method.length;i++){
			if(method[i].getName().equals(functionname)){
				m1 = method[i];	
			}
		}

		Class[] param = m1.getParameterTypes();
		//Class[] paramtypes = method2.getParameterTypes();
		//Class[] paramtypes = {Integer.class};
		//Method  method = d.getDeclaredMethod(functionname,paramtypes);
		Method  m = d.getDeclaredMethod(functionname,param);

		m.invoke(c,x,name);
	}
}

class ReflectMiddleware2{
	public static void main(String[] args) throws IllegalAccessException,InvocationTargetException,NoSuchMethodException,InstantiationException, ClassNotFoundException{
		String name = args[0];
		String fname = args[1];
		int x = 90;
		String sname = "Rajo";
		Middleware.callMethod(name,fname,x,sname);
	}
}