package reflectclass;
import java.lang.reflect.*; 
public class ReflectClass {
	public static void main(String[] args) throws Exception, ClassNotFoundException {
		Class c = Class.forName(args[0]);
		Field f[] = c.getDeclaredFields();
		Method m[] = c.getDeclaredMethods();
		Constructor d[] = c.getDeclaredConstructors();
		for(int i=0;i<f.length;i++){
			System.out.println(f[i]);
		}
		for(int i=0;i<m.length;i++){
			System.out.println(m[i]);
		}
		for(int i=0;i<d.length;i++){
			System.out.println(d[i]);
		}
	}
}