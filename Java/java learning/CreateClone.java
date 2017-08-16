import java.util.Date;
import java.text.*;

class Employee implements Cloneable{
	private int empid;
	public Date dob = new Date();
	Employee(int id){
		this.empid = id;
	}
	public Employee clone() throws CloneNotSupportedException {
		Employee clonedobject = null;
		//System.out.println(this.dob);
		clonedobject =  (Employee)super.clone();
		try{
		clonedobject.dob = this.dob.clone();

		}
		catch (CloneNotSupportedException e){
			System.out.println("Cant clone date");
		}
		return clonedobject;

	}
	public String toString(){

		SimpleDateFormat dateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		return " Employee with id, "+this.empid+" and dob"+dateFormat.format(this.dob);
	}
}

class Date implements Cloneable{

	public Date clone() throws CloneNotSupportedException{
		return (Date)super.clone();
	}
	 // public String toString(){
		// return this.dd+"-"+this.MM+"-"+this.yyyy;
	 // }
}

public class CreateClone{
	public static void main(String[] args) {
		Employee e1 = new Employee(1);
		System.out.println("Employee 1 "+e1);
		
		try{
			Employee e2 = (Employee)e1.clone();
			System.out.println(" Cloned object is, "+e2);
			if(e1.dob == e2.dob){
			System.out.println("Shallow Cloned.");
		}
		else{
			System.out.println("Deep cloned.");
		}
		}
		catch(CloneNotSupportedException e){
			System.out.println("Cant clone");
		}
		
				
	}
}