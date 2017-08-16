class Employee {
	private int id;
	private double salary;
	public Employee(int id, double salary){
		this.id = id;
		this.salary = salary;
	}
	public double getSalary(){
		return this.salary;
	}
}

class Labour extends Employee {
	private double overtime;
	public Labour(int id, double salary , double overtime){
		super(id,salary);
		this.overtime = overtime;
	}
	public double getSalary(){
		return this.overtime + super.getSalary() ;
	}
}
class Manager extends Employee {
	private double incentive;
	public Manager(int id, double salary , double incentive){
		super(id,salary);
		this.incentive = incentive;
	}
	public double getSalary(){
		return this.incentive + super.getSalary() ;
	}
}

public class CalculateSalary{
	private static double totalsalary=0;
	public static double getTotalSalaryOfAllEmployees(Employee a[]){
		
		for(int i = 0 ; i<a.length ; i++){
			totalsalary = totalsalary + a[i].getSalary();
		}
		return totalsalary;
	}
	public static void main(String[] args) {
		double totalsalary;
		Employee a[] = new Employee[4];
		a[0] = new Labour(1,250,20);
		a[1] = new Labour(2,330,10);
		a[2] = new Manager(1,2000,200);
		a[3] = new Manager(1,3000,1500);
		totalsalary = CalculateSalary.getTotalSalaryOfAllEmployees(a);
		System.out.println("Total Salary of all employees is, " + totalsalary );
	}
}